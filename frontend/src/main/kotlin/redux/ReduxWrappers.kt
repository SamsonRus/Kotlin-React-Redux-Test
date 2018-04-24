package redux

import util.require

external interface ReduxState
external class Store {
    @JsName("getState")
    fun getState(): ReduxState

    @JsName("dispatch")
    fun doDispatch(action: dynamic)
}

@JsModule("redux")
@JsNonModule
external object Redux {
    @JsName("createStore")
    fun <ST : ReduxState> createStore(reducer: (ST, dynamic) -> ReduxState,
                                      initialState: ST,
                                      enhancer: (dynamic) -> ST = definedExternally)
            : Store

    @JsName("applyMiddleware")
    fun applyMiddleware(vararg middleware: () -> (dynamic) -> dynamic)
            : ((dynamic) -> Unit, () -> ReduxState) -> Unit

    @JsName("compose")
    fun compose(vararg funcs: dynamic): (dynamic) -> dynamic
}

val ReduxThunk: dynamic = require("redux-thunk").default
val composeWithDevTools: dynamic = require("redux-devtools-extension").composeWithDevTools


fun Store.dispatch(action: ReduxAction) {
    //this.doDispatch(action())
}
