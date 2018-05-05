package store

import model.Car
import redux.dispatchToRedux

fun changeActiveCar(car: Car) = dispatchToRedux(ActionType.SELECT_CAR, SelectCar(car))
