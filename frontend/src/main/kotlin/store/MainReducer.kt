package store

import redux.ReduxState

fun mainReducer(reduxState: ReduxStore, reduxAction: dynamic): ReduxState =
        if (reduxAction.type == "@@INIT") {
            reduxState
        } else {
            when (ActionType.valueOf(reduxAction.type)) {
                ActionType.SELECT_CAR   -> {
                    val selectCar = reduxAction.payload as SelectCar
                    reduxState.copy(selectedCar = selectCar.car)
                }
            }
        }