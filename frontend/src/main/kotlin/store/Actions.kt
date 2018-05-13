@file:Suppress("ArrayInDataClass")

package store

import model.Car
import redux.ActionPayload
import redux.ActionType

enum class ActionType : ActionType {
    SELECT_CAR {
        override fun value(): String {
            return name
        }
    }
}

data class SelectCar(val car: Car) : ActionPayload