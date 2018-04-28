package containers

import kotlinext.js.assign
import kotlinx.html.js.onClickFunction
import model.Car
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.key
import react.dom.li
import react.dom.ol
import redux.connect
import store.ReduxStore
import store.changeActiveCar

val carsListConnector = connect<CarsListRProps, ReduxStore>({ state: ReduxStore, props ->
    assign(props) {
        cars = state.cars
    }
}, { dispatch, props ->
    assign(props) {
        changeSelectCar = { selectedCar: Car ->
            dispatch(changeActiveCar(selectedCar))
        }
    }
})

class CarsList : RComponent<CarsListRProps, RState>() {
    private fun RBuilder.showList(car: Car) {
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

class CarsListRProps(var cars: List<Car> = arrayListOf(), var changeSelectCar: (Car) -> Unit) :
        RProps
