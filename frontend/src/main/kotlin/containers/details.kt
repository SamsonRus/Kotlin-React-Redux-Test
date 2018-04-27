package containers

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.p
import model.Car
import react.dom.img
import redux.connect
import store.ReduxStore
import util.jsObject

val detailsConnector =
        connect<DetailsRProps, ReduxStore>(
                {state: ReduxStore , _ ->
                    jsObject {
                        car = state.active
                    }
                })


class Details : RComponent<DetailsRProps, RState>() {
    override fun RBuilder.render() {
        if(props.car!!.car=="" ){
            p{
                +"Выберите автомобиль.."
            }
        } else {
            div {
                h2 {+props.car!!.car}
                img {
                    attrs.src = props.car!!.img
                    attrs.height = "420px"
                }
                p {+props.car!!.desc}
                p {
                    +"Скорость:${props.car!!.speed}, Вес:${props.car!!.weight}"
                }
            }
        }
    }

}

class DetailsRProps(var car : Car? = null) : RProps

fun RBuilder.details() = child(Details::class) {}