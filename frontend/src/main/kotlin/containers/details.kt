package containers

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.p

class Details : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2{}
            p{}
            p{
                +"Скорость:, Вес:"
            }
        }
    }

}

fun RBuilder.details() = child(Details::class) {}