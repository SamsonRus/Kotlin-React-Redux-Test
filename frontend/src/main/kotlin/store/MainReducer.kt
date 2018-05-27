package store

import redux.Reducer

class MainReducer : Reducer<ReduxStore>() {

    override fun addReducers() {
        addSelectCarReducer()
    }

    private fun addSelectCarReducer() {
        val selectCarAction = { reduxAction: dynamic, reduxState: ReduxStore ->
            val selectCar = reduxAction.payload as SelectCar
            reduxState.copy(active = selectCar.car)
        }

        addReducer(ActionType.SELECT_CAR, selectCarAction)
    }
}