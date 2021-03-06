package store

import model.Car
import reducers.getCars
import redux.ActionPayload
import redux.Redux

data class ReduxStore(val cars: List<Car> = getCars(), val active: Car = Car()) : Redux.ReduxState