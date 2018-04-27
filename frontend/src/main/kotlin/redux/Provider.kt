package redux

import react.*
import util.require

val Provider: dynamic = require("react-redux").Provider

@JsModule("react-redux")
@JsNonModule
external object ReactRedux {

    interface ProviderProps : RProps {
        var store: Any
    }

    @JsName("Provider")
    class ProviderComponent : Component<ProviderProps, RState> {
        override fun render(): ReactElement?
    }

}
//class ReactProviderProps(var store: Any) : reactRedefine.RProps()
//
//object ProviderObject : ReactExternalComponentSpec<ReactProviderProps>(Provider)

//class ProviderComponent: RComponent<ProviderRProps, RState>() {
//    override fun RBuilder.render() {
//        //val childrenList = listOf<Any>(props.children)
//        child(
//                type = Provider,
//                props = props,
//                children = listOf<Any>(props.children)
//             )
//    }
//}
//
//class ProviderRProps(var store: Any, var children: ReactElement) : RProps

//fun RBuilder.provider(store: Any, children: ReactElement) = child(ProviderComponent::class) {
//    attrs.store = store
//    attrs.children = children
//}

fun RBuilder.redux(store: Store, handler: RHandler<RProps>) =
        child(ReactRedux.ProviderComponent::class) {
            attrs {
                this.store = store
            }
            handler()
        }