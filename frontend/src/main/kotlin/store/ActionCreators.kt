package store

import model.Car
import redux.ReduxAction
import util.async

fun changeSelectedCar(car: Car): ((dynamic) -> Unit, () -> ReduxStore) -> Unit {
    return { dispatch: (dynamic) -> Unit, _: () -> ReduxStore ->
        async {
            dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(car)))
        }
    }
}