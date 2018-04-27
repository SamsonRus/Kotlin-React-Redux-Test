package containers

import kotlinx.html.js.onClickFunction
import model.Car
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.key
import react.dom.li
import react.dom.ol
import reducers.getCars
import redux.ReduxAction
import redux.connect
import store.ActionType
import store.ReduxStore
import store.SelectCar
import store.changeSelectedCar
import util.js
import util.jsObject

val carsListConnector =
        connect<CarsListRProps, ReduxStore>(
                {state: ReduxStore , _ ->
                    jsObject {
                        cars = state.cars
                    }
        }, { dispatch, _ ->
            jsObject {
                changeSelectCar = { selectedCar ->
                    js {
                        dispatch(changeSelectedCar(selectedCar))
            }}}
        })

class CarsList : RComponent<CarsListRProps, RState>() {
    fun RBuilder.showList(car: Car) {
        li {
            +car.car
            attrs.key = "${car.id}"
            attrs.onClickFunction = {
                props.changeSelectCar(car)
            }
        }
    }

    override fun RBuilder.render() {
        ol {
            props.cars.map { showList(it) }
        }
    }
}

class CarsListRProps(var cars: List<Car> = arrayListOf(), var changeSelectCar: (Car) -> Unit) : RProps

fun RBuilder.carsList() = child(CarsList::class) {}