package org.pandawarrior.app

import org.junit.Test
import org.junit.Assert.assertEquals
import org.pandawarrior.app.vehicle.engine.FuelInjector
import org.pandawarrior.app.vehicle.engine.GoodEngine

class FakeFuelInjector(private val fakeFuel:Int): FuelInjector {
    override fun injectFuel(): Int {
        return fakeFuel
    }
}

class CarTest {
    @Test
    fun testEngine(){
        val fakeFuelEngine1 = FakeFuelInjector(90)
        val engine = GoodEngine(fakeFuelEngine1)
        assertEquals("Starting Engine: It can travel " +
                "very very fast and far", engine.start())
    }
}
