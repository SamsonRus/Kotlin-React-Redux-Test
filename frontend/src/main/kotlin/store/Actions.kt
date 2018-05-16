package store

import model.Car
import redux.ActionPayload
import redux.ReduxActionType

enum class ActionType : ReduxActionType {
    SELECT_CAR {
        override fun value() = name
    }
}

data class SelectCar(val car: Car) : ActionPayload