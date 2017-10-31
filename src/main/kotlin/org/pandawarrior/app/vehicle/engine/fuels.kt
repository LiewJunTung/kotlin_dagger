package org.pandawarrior.app.vehicle.engine

data class Fuel(val name: String, val quality: FuelQuality, val quantity: Int)

enum class FuelQuality {
    NORMAL, GOOD, BEST
}