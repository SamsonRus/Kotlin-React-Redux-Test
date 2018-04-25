package store

import model.Car
import redux.ReduxAction

fun changeSelectedCar(car: Car): ((dynamic) -> Unit, () -> ReduxStore) -> Unit {
    return { dispatch: (dynamic) -> Unit, _: () -> ReduxStore ->
        dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(car)))
    }
}