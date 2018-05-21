package containers

import kotlinext.js.assign
import kotlinx.html.INPUT
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import model.Car
import react.*
import react.dom.button
import react.dom.div
import react.dom.input
import redux.connect
import redux.connectRedux
import store.ReduxStore
import store.changeActiveCar

class SmartComponent : RComponent<SmartComponent.Props, RState>() {
    companion object {
        private val connector = connect({ state: ReduxStore, props -> initState(props, state) }, dispatch())

        private fun dispatch(): ((dynamic) -> Unit, Props) -> Props {
            return { dispatch, props ->
                assign(props) {
                    changeSelectCar = { selectedCar: Car ->
                        dispatch(changeActiveCar(selectedCar))
                    }
                }
            }
        }

        private fun initState(props: Props, state: ReduxStore): Props {
            return assign(props) {
                cars = state.cars
            }
        }


        fun RBuilder.smart(): ReactElement = connectRedux<SmartComponent, SmartComponent.Props>(SmartComponent.connector)
    }

    var inputRef: RReadableRef<INPUT> = createRef()

    override fun RBuilder.render() {
        div {

            input(InputType.text) {
                attrs.width = "100px"
                ref = inputRef
            }

            button {
                +"input Car"
                attrs.onClickFunction = {
                    val car = props.cars.firstOrNull { car -> car.car == inputRef.current!!.value }

                    car?.let {
                        props.changeSelectCar(it)
                        console.log("car: ${it.car}")
                    }

                    console.log("inputRef: ${inputRef.current!!.value}")
                }
            }
        }
    }

    class Props(var cars: List<Car> = arrayListOf(), var changeSelectCar: (Car) -> Unit) : RProps
}