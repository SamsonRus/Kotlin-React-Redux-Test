package store

import model.Car
import redux.dispatchAsync

fun changeActiveCar(car: Car) = dispatchAsync(ActionType.SELECT_CAR, SelectCar(car))