package store

import kotlinx.coroutines.experimental.async
import model.Car
import redux.*

fun changeActiveCar(car: Car) = dispatchToRedux(ActionType.SELECT_CAR, SelectCar(car))

fun dispatchToRedux(action: ActionType, payload: ActionPayload) = thunk {
    async {
        dispatch(ReduxAction(action, payload))
    }
}