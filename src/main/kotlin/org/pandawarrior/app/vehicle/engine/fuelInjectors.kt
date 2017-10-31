package org.pandawarrior.app.vehicle.engine

import javax.inject.Inject

interface FuelInjector {
    fun injectFuel(): Int
}

class BadFuelInjector : FuelInjector {
    val fuel: Fuel? = Fuel("RON95", FuelQuality.NORMAL, 100)

    override fun injectFuel(): Int {
        if (fuel == null) {
            println("No fuel to inject!")
            return 0
        }
        println("Injecting ${fuel.name}")
        return when (fuel.quality) {
            FuelQuality.BEST -> 70
            FuelQuality.GOOD -> 40
            FuelQuality.NORMAL -> 20
        }
    }
}

class GoodFuelInjector @Inject constructor(val fuel: Fuel?) : FuelInjector {

    override fun injectFuel(): Int {
        if (fuel == null) {
            println("No fuel to inject!")
            return 0
        }
        println("Injecting ${fuel.name}")
        return when (fuel.quality) {
            FuelQuality.BEST -> 100
            FuelQuality.GOOD -> 80
            FuelQuality.NORMAL -> 50
        }
    }
}

