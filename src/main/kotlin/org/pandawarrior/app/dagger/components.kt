package org.pandawarrior.app.dagger

import dagger.Component
import org.pandawarrior.app.vehicle.Car
import org.pandawarrior.app.vehicle.WeirdCar
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(CarModule::class, EngineModule::class, GearModule::class))
interface CarComponent {
    fun weirdCar(car: WeirdCar)
    fun normalCar(): Car
}