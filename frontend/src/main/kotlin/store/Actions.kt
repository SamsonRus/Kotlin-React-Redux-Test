@file:Suppress("ArrayInDataClass")

package store

import model.Car
import redux.ActionPayload

enum class ActionType {
    SELECT_CAR
}

data class SelectCar(val car: Car) : ActionPayload