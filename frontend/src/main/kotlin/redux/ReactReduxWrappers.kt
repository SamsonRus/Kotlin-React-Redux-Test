@file:JsModule("react-redux")

package redux

import react.RProps
import react.ReactElement


@JsName("connect")
external fun <P : RProps, ST : ReduxState> connect(
        mapStateToProps: ((ST, P) -> P)? = definedExternally,
        mapDispatchToProps: (((dynamic) -> Unit, P) -> P)? = definedExternally
                                                  ): (Any) -> ReactElement

