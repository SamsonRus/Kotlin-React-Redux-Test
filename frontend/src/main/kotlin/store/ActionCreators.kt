package store

import model.Car
import redux.ReduxAction
import redux.dispatch
import redux.thunk
import util.async

fun changeActiveCar(car: Car) = thunk {
    async {
        dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(car)))
    }
}