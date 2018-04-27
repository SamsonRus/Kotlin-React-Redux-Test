package redux

import kotlinext.js.jsObject
import react.*

inline fun <reified T : Component<out RProps, *>> RBuilder.connectRedux(
        crossinline connectFunction: (RClass<RProps>) -> ReactElement,
        noinline handler: RHandler<out RProps> = {}
                                                                             ): ReactElement {
    val type = T::class.js.unsafeCast<RClass<RProps>>()
    return child(connectFunction(type), jsObject {}, handler).asDynamic()
}