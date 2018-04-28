package redux

import react.*

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

fun RBuilder.provider(store: Redux.Store, handler: RHandler<RProps>) =
        child(ReactRedux.ProviderComponent::class) {
            attrs {
                this.store = store
            }
            handler()
        }