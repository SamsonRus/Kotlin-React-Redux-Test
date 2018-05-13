package redux
import kotlinext.js.require
import kotlinx.coroutines.experimental.async

@JsModule("redux")
@JsNonModule
external object Redux {
    interface ReduxState
    interface Store {
        @JsName("getState")
        fun getState(): ReduxState

        @JsName("dispatch")
        fun doDispatch(action: dynamic)

        @JsName("subscribe")
        fun subscribe(block: dynamic): dynamic

        @JsName("replaceReducer")
        fun replaceReducer(router: dynamic)
    }

    @JsName("createStore")
    fun <ST : ReduxState> createStore(
            reducer: (ST, dynamic) -> ReduxState,
            initialState: ST,
            enhancer: (dynamic) -> ST = definedExternally): Store

    @JsName("applyMiddleware")
    fun applyMiddleware(vararg middleware: () -> (dynamic) -> dynamic): ((dynamic) -> Unit, () -> ReduxState) -> Unit

    @JsName("compose")
    fun compose(vararg funcs: dynamic): (dynamic) -> dynamic
}

val ReduxThunk: dynamic = require("redux-thunk").default
val composeWithDevTools: dynamic = require("redux-devtools-extension").composeWithDevTools

fun dispatchToRedux(action: ActionType, payload: ActionPayload) = thunk {
    async {
        dispatch(ReduxAction(action, payload))
    }
}
fun Redux.Store.dispatch(action: ReduxAction) {
    this.doDispatch(action())
}
