@file:Suppress("ArrayInDataClass")

package store

import redux.ReduxState

data class ReduxStore(val selectedCar: SelectCar? = null) : ReduxState