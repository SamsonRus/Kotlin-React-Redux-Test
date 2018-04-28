package store

import redux.Redux

fun mainReducer(reduxState: ReduxStore, reduxAction: dynamic): Redux.ReduxState =
        if (reduxAction.type == "@@INIT") {
            reduxState
        } else {
            when (ActionType.valueOf(reduxAction.type)) {
                ActionType.SELECT_CAR -> {
                    val selectCar = reduxAction.payload as SelectCar
                    reduxState.copy(active = selectCar.car)
                }
            }
        }