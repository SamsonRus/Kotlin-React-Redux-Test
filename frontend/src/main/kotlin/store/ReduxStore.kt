@file:Suppress("ArrayInDataClass")

package store

import model.Car
import redux.ReduxState

data class ReduxStore(
        val selectedCar: Car = Car()
                     ) : ReduxState