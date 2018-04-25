package containers

import kotlinx.html.js.onClickFunction
import model.Car
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.li
import react.dom.ol
import reducers.getCars
import redux.connect
import store.changeSelectedCar
import store.ReduxStore
import util.jsObject
import util.js

val carsListConnector =
        connect<CarsListRProps, ReduxStore>(
                {state: ReduxStore , _ ->
                    jsObject {
                        selectedCar = state.selectedCar
                    }
        }, { dispatch, _ ->
            jsObject {
                changeSelectCar = { selectedCar ->
                    js {
                        dispatch(changeSelectedCar(selectedCar))
                    }
                }
            }
        })

class CarsList : RComponent<CarsListRProps, RState>() {
    fun RBuilder.showList(car : Car) {
        li {
            +car.car
            attrs.onClickFunction = { props.changeSelectCar(car) }
//            attrs.onClickFunction = js {
//                dispatch(changeSelectedCar(car))
//            }
        }

    }

    override fun RBuilder.render() {
        val carList = getCars()

        ol{
            carList.map { showList(it) }
        }
    }
}

class CarsListRProps(var selectedCar: Car, var changeSelectCar: (Car) -> Unit) : RProps

fun RBuilder.carsList() = child(CarsList::class) {}