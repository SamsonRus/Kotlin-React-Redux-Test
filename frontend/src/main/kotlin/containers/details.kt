package containers

import kotlinext.js.assign
import model.Car
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.img
import react.dom.p
import redux.connect
import store.ReduxStore

val detailsConnector = connect<DetailsRProps, ReduxStore>({ state: ReduxStore, props ->
    assign(props) {
        car = state.active
    }
})


class Details : RComponent<DetailsRProps, RState>() {
    override fun RBuilder.render() {
        if (props.car!!.car == "") {
            p {
                +"Выберите автомобиль.."
            }
        } else {
            div {
                h2 { +props.car!!.car }
                img {
                    attrs.src = props.car!!.img
                    attrs.height = "420px"
                }
                p { +props.car!!.desc }
                p {
                    +"Скорость:${props.car!!.speed}, Вес:${props.car!!.weight}"
                }
            }
        }
    }
}

class DetailsRProps(var car: Car? = null) : RProps