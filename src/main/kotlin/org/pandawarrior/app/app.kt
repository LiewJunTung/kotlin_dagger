package org.pandawarrior.app

import org.pandawarrior.app.vehicle.BadCar
import org.pandawarrior.app.vehicle.GoodCar
import org.pandawarrior.app.vehicle.WeirdCar
import org.pandawarrior.app.vehicle.gear.ManualGear
import org.pandawarrior.app.dagger.DaggerCarComponent
import org.pandawarrior.app.vehicle.engine.Fuel
import org.pandawarrior.app.vehicle.engine.FuelQuality
import org.pandawarrior.app.vehicle.engine.GoodEngine
import org.pandawarrior.app.vehicle.engine.GoodFuelInjector

fun main(args: Array<String>) {
    noDependencyInjection()

    manualDependencyInjection()

    daggerConstructorInjection()

    daggerFieldInjection()
}

fun noDependencyInjection(){
    val badCar = BadCar()
    badCar.drive()
}

fun daggerConstructorInjection(){
    val normalCar = DaggerCarComponent.builder().build().normalCar()
    normalCar.drive()
}

fun daggerFieldInjection(){
    val weirdCar = WeirdCar()
    DaggerCarComponent.builder()
            .build()
            .weirdCar(weirdCar)
    weirdCar.drive()
}

fun manualDependencyInjection(){
    val fuel = Fuel("RON95", FuelQuality.GOOD, 100)
    val goodFuelInjector = GoodFuelInjector(fuel)
    val goodEngine = GoodEngine(goodFuelInjector)
    val manualGear = ManualGear()
    val goodCar = GoodCar(goodEngine, manualGear)
    goodCar.drive()
}