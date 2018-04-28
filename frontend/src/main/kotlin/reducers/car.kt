package reducers

import model.Car

fun getCars(): ArrayList<Car> {
    val listCars = ArrayList<Car>()
    listCars.add(Car(id = 1,
            car = "Audi",
            speed = 234.45,
            weight = 1.4,
            desc = "R8 это замечательный спортивный автомобиль!",
            img = "http://apravda.com/sites/default/files/field/image/audi-r8.jpg"))
    listCars.add(Car(id = 2,
            car = "BMW",
            speed = 314.5,
            weight = 1.2,
            desc = "Автомобили с отметкой 'М' всегда были быстрее!",
            img = "https://mediapool.bmwgroup.com/cache/P9/201703/P90251035/P90251035-the-new-bmw-m4-cs-04-2017-2250px.jpg"))
    listCars.add(Car(id = 3,
            car = "Mercedes",
            speed = 286.1,
            weight = 1.35,
            desc = "Mercedes отличаются не только скоростью, но также комфортом!",
            img = "http://gallery.ykt.ru/gals/2017/07/25/euro/2426097_0.jpg"))
    return listCars
}