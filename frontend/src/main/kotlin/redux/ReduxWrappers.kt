package redux
import kotlinext.js.require
import kotlinx.coroutines.experimental.async

@JsModule("redux")
@JsNonModule
external object Redux {
    interface ReduxState

    interface Store {
        /**
         * Reads the state tree managed by the store.
         *
         * @return redux state.
         */
        @JsName("getState")
        fun getState(): ReduxState

        /**
         * Dispatches an action. It is the only way to trigger a state change.
         *
         * The `reducer` function, used to create the store, will be called with the
         * current state tree and the given `action`. Its return value will
         * be considered the **next** state of the tree, and the change listeners
         * will be notified.
         *
         * The base implementation only supports plain object actions. If you want to
         * dispatch a Promise, an Observable, a thunk, or something else, you need to
         * wrap your store creating function into the corresponding middleware. For
         * example, see the documentation for the `redux-thunk` package. Even the
         * middleware will eventually dispatch plain object actions using this method.
         *
         * @param {Object} action A plain object representing “what changed”. It is
         * a good idea to keep actions serializable so you can record and replay user
         * sessions, or use the time travelling `redux-devtools`. An action must have
         * a `type` property which may not be `undefined`. It is a good idea to use
         * string constants for action types.
         *
         * @returns {Object} For convenience, the same action object you dispatched.
         *
         * Note that, if you use a custom middleware, it may wrap `dispatch()` to
         * return something else (for example, a Promise you can await).
         */
        @JsName("dispatch")
        fun doDispatch(action: dynamic)

        /**
         * Adds a change listener. It will be called any time an action is dispatched,
         * and some part of the state tree may potentially have changed. You may then
         * call `getState()` to read the current state tree inside the callback.
         *
         * You may call `dispatch()` from a change listener, with the following
         * caveats:
         *
         * 1. The subscriptions are snapshotted just before every `dispatch()` call.
         * If you subscribe or unsubscribe while the listeners are being invoked, this
         * will not have any effect on the `dispatch()` that is currently in progress.
         * However, the next `dispatch()` call, whether nested or not, will use a more
         * recent snapshot of the subscription list.
         *
         * 2. The listener should not expect to see all state changes, as the state
         * might have been updated multiple times during a nested `dispatch()` before
         * the listener is called. It is, however, guaranteed that all subscribers
         * registered before the `dispatch()` started will be called with the latest
         * state by the time it exits.
         *
         * @param {Function} listener A callback to be invoked on every dispatch.
         * @returns {Function} A function to remove this change listener.
         */
        @JsName("subscribe")
        fun subscribe(block: dynamic): dynamic

        /**
         * Replaces the reducer currently used by the store to calculate the state.
         *
         * You might need this if your app implements code splitting and you want to
         * load some of the reducers dynamically. You might also need this if you
         * implement a hot reloading mechanism for Redux.
         *
         * @param {Function} nextReducer The reducer for the store to use instead.
         * @returns {void}
         */
        @JsName("replaceReducer")
        fun replaceReducer(router: dynamic)
    }

    /**
     * Creates a Redux store that holds the state tree.
     *
     * @param reducer reducers.
     * @param initialState redux state.
     * @param enhancer .
     *
     * @return new redux store.
     */
    @JsName("createStore")
    fun <ST : ReduxState> createStore(
            reducer: (ST, dynamic) -> ReduxState,
            initialState: ST,
            enhancer: (dynamic) -> ST = definedExternally): Store

    /**
     * Creates a store enhancer that applies middleware to the dispatch method
     * of the Redux store. This is handy for a variety of tasks, such as expressing
     * asynchronous actions in a concise manner, or logging every action payload.
     *
     * See `redux-thunk` package as an example of the Redux middleware.
     *
     * Because middleware is potentially asynchronous, this should be the first
     * store enhancer in the composition chain.
     *
     * Note that each middleware will be given the `dispatch` and `getState` functions
     * as named arguments.
     *
     * @param {...Function} middlewares The middleware chain to be applied.
     * @returns {Function} A store enhancer applying the middleware.
     */
    @JsName("applyMiddleware")
    fun <T : ReduxState> applyMiddleware(vararg middleware: () -> (dynamic) -> dynamic): ((dynamic) -> Unit, () -> ReduxState) -> T

    /**
     * Composes single-argument functions from right to left. The rightmost
     * function can take multiple arguments as it provides the signature for
     * the resulting composite function.
     *
     * @param {...Function} funcs The functions to compose.
     * @returns {Function} A function obtained by composing the argument functions
     * from right to left. For example, compose(f, g, h) is identical to doing
     * (...args) => f(g(h(...args))).
     */
    @JsName("compose")
    fun compose(vararg funcs: dynamic): (dynamic) -> dynamic
}

val ReduxThunk: dynamic = require("redux-thunk").default
val composeWithDevTools: dynamic = require("redux-devtools-extension").composeWithDevTools

fun dispatchAsync(actionType: ReduxActionType, payload: ActionPayload) = thunk {
    dispatch(actionType, payload)
}

fun Redux.Store.dispatch(actionType: ReduxActionType, payload: ActionPayload) {
    this.doDispatch(ReduxAction(actionType, payload)())
}
