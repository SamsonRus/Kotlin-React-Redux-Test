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
                        selectedCar = state.selectedCar
                    }
                })


class Details : RComponent<DetailsRProps, RState>() {
    override fun RBuilder.render() {
        if(props.selectedCar==null ){
            p{
                +"Выберите автомобиль.."
            }
        } else {
            div {
                h2 {+props.selectedCar.car}
                img {
                    attrs.src = props.selectedCar.img
                    attrs.height = "420px"
                }
                p {+props.selectedCar.desc}
                p {
                    +"Скорость:${props.selectedCar.speed}, Вес:${props.selectedCar.weight}"
                }
            }
        }
    }

}

class DetailsRProps(var selectedCar : Car) : RProps

fun RBuilder.details() = child(Details::class) {}