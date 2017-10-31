package org.pandawarrior.app.vehicle.engine

import javax.inject.Inject

class BadEngine : Engine {
    override val condition: Boolean
        get() = false
    val fuelInjector = BadFuelInjector()

    override fun start(): String {
        if (fuelInjector == null) {
            return "Engine can't start: No fuel injector"
        }

        val fuelQuality = fuelInjector.injectFuel()
        if (fuelQuality > 70) {
            return "Starting Engine: It can travel very very fast and far"
        } else if (fuelQuality > 40) {
            return "Starting Engine: It can travel fast and far"
        } else if (fuelQuality > 0) {
            return "Starting Engine: It can travel in normal speed and distance"
        } else {
            return "Engine can't start: No fuel"
        }
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class GoodEngine @Inject constructor(val fuelInjector: FuelInjector?) : Engine {
    override var condition: Boolean = false

    override fun start(): String {
        if (fuelInjector == null) {
            return "Engine can't start: No fuel injector"
        }

        val fuelQuality = fuelInjector.injectFuel()
        if (fuelQuality > 70) {
            condition = true
            return "Starting Engine: It can travel very very fast and far"
        } else if (fuelQuality > 40) {
            condition = true
            return "Starting Engine: It can travel fast and far"
        } else if (fuelQuality > 0) {
            condition = true
            return "Starting Engine: It can travel in normal speed and distance"
        } else {
            return "Engine can't start: No fuel"
        }
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface Engine {
    val condition: Boolean

    fun start(): String

    fun stop()
}