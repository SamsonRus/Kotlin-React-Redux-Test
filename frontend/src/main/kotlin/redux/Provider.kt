package redux

import react.RProps
import util.require

val Provider: dynamic = require("react-redux").Provider

class ReactProviderProps(var store: Any) : RProps

open class ReactExternalComponentSpec<P : RProps>(val ref: dynamic)

object ProviderComponent : ReactExternalComponentSpec<ReactProviderProps>(Provider)