package redux

import react.*
import util.require

val Provider: dynamic = require("react-redux").Provider

//class ReactProviderProps(var store: Any) : reactRedefine.RProps()
//
//object ProviderObject : ReactExternalComponentSpec<ReactProviderProps>(Provider)

class ProviderComponent: RComponent<ProviderRProps, RState>() {
    override fun RBuilder.render() {
        //val childrenList = listOf<Any>(props.children)
        child(
                type = Provider,
                props = props,
                children = listOf<Any>(props.children)
             )
    }
}

class ProviderRProps(var store: Any, var children: ReactElement) : RProps

fun RBuilder.provider(store: Any, children: ReactElement) = child(ProviderComponent::class) {
    attrs.store = store
    attrs.children = children
}