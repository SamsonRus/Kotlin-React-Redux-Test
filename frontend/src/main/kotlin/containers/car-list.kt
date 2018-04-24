package containers

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.ol

class CarsList : RComponent<RProps, RState>() {
    fun RBuilder.showList() {

    }

    override fun RBuilder.render() {
        ol{

        }
    }
}

fun RBuilder.carsList() = child(CarsList::class) {}