package store

import kotlinx.coroutines.experimental.async
import model.Car
import redux.ReduxAction
import redux.dispatch
import redux.thunk

fun changeActiveCar(car: Car) = thunk {
    async {
        dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(car)))
    }
}