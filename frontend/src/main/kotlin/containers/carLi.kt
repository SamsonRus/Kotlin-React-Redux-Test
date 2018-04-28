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
import redux.connect
import store.ReduxStore
import store.changeActiveCar

val carLiConnector = connect<CarsListRProps, ReduxStore>({ state: ReduxStore, props ->
    assign(props) {}
}, { dispatch, props ->
    assign(props) {
        changeSelectCar = { selectedCar: Car ->
            dispatch(changeActiveCar(selectedCar))
        }
    }
})

class CarLi : RComponent<CarLiRProps, RState>() {
    override fun RBuilder.render() {
        li {
            if (props.car != null) {
                +props.car!!.car
                attrs.key = "${props.car!!.id}"
                attrs.onClickFunction = {
                    props.changeSelectCar(props.car!!)
                }
            }
        }
    }
}

class CarLiRProps(var car: Car?, var changeSelectCar: (Car) -> Unit) : RProps