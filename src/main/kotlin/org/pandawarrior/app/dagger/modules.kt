package org.pandawarrior.app.dagger

import dagger.Module
import dagger.Provides
import org.pandawarrior.app.vehicle.Car
import org.pandawarrior.app.vehicle.GoodCar
import org.pandawarrior.app.vehicle.engine.*
import org.pandawarrior.app.vehicle.gear.AutoGear
import org.pandawarrior.app.vehicle.gear.Gear
import org.pandawarrior.app.vehicle.gear.ManualGear
import javax.inject.Named

@Module
class EngineModule {
    @Provides
    fun provideFuelInjector(fuel: Fuel): FuelInjector {
        return GoodFuelInjector(fuel)
    }

    @Provides
    fun provideQualityFuel(): Fuel {
        return Fuel("RON9000", FuelQuality.BEST, 100)
    }

    @Provides
    fun provideEngine(fuelInjector: FuelInjector): Engine {
        return GoodEngine(fuelInjector)
    }
}

@Module
class GearModule {
    @Provides
    fun provideAutoGear(): Gear {
        return AutoGear()
    }

    @Provides
    @Named("manual")
    fun provideManualGear(): Gear {
        return ManualGear()
    }
}

@Module
class CarModule {
    @Provides
    fun provideAutoCar(engine: Engine, @Named("manual") gear: Gear): Car {
        return GoodCar(engine, gear)
    }
}