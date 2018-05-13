package store

import redux.Reducer

class MyReducer : Reducer() {

    override fun addReducers() {
        addSelectCardReducer()
    }

    private fun addSelectCardReducer() {
        val selectCarAction = { reduxAction: dynamic, reduxState: ReduxStore ->
            val selectCar = reduxAction.payload as SelectCar
            reduxState.copy(active = selectCar.car)
        }

        addReducer(ActionType.SELECT_CAR, selectCarAction)
    }
}