package containers

import kotlinext.js.assign
import react.*
import react.dom.div
import redux.connect
import redux.connectRedux
import store.ReduxStore

class DumbComponent : RComponent<DumbComponent.Props, RState>() {

    companion object {

        private val connector = connect<DumbComponent.Props, ReduxStore>({ state: ReduxStore,
                                                                           props -> initState(props, state) })

        private fun initState(props: Props, state: ReduxStore): Props {
            return assign(props) {
                car = state.active.car
            }
        }

        fun RBuilder.dumb(): ReactElement = connectRedux<DumbComponent, DumbComponent.Props>(DumbComponent.connector)
    }

    override fun RBuilder.render() {
        div {
            +props.car
        }
    }

    class Props(var car: String) : RProps
}


