package redux

import kotlinext.js.jsObject
import react.*

/**
 * Function for connection to a redux
 *
 * @param {component} connect function
 * @param {props} for component
 *
 * return ReactElement connected redux
 **/
inline fun <reified T : Component<P, *>, reified P : RProps> RBuilder.connectRedux(
        crossinline connectFunction: (RClass<P>) -> ReactElement,
        noinline handler: RHandler<out P> = {}): ReactElement {
    val type = T::class.js.unsafeCast<RClass<P>>()
    return child(connectFunction(type), jsObject {}, handler).asDynamic()
}

fun thunk(f: Redux.Store.() -> Any) =
        { dispatch: (Any) -> dynamic, getState: () -> Redux.ReduxState, subscribe: (dynamic) -> dynamic, replaceReducer: (dynamic) -> dynamic ->
            val store = object : Redux.Store {
                override fun getState() = getState()
                override fun doDispatch(action: dynamic) = dispatch(action)
                override fun replaceReducer(router: dynamic) = replaceReducer(router)
                override fun subscribe(block: dynamic) = subscribe(block)
            }
            store.f()
        }