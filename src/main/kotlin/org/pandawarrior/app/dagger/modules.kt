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
    /**
     * All @Provides methods must belong to a module. These are just classes that have an @Module annotation.
     * source: https://google.github.io/dagger/users-guide.html
     */
    @Provides
    fun provideFuelInjector(@Named("NORMAL_FUEL") fuel: Fuel): FuelInjector {
        return GoodFuelInjector(fuel)
    }

    @Provides
    @Named("QUALITY_FUEL")
    fun provideQualityFuel(): Fuel {
        return Fuel("RON9000", FuelQuality.BEST, 100)
    }

    @Provides
    @Named("NORMAL_FUEL")
    fun provideBadFuel(): Fuel {
        return Fuel("RON80", FuelQuality.NORMAL, 100)
    }


    @Provides
    fun provideEngine(fuelInjector: FuelInjector): Engine {
        return GoodEngine(fuelInjector)
    }
}

@Module
class GearModule {
    /**
     * Sometimes the type alone is insufficient to identify a dependency.
     * For example, a sophisticated car factory may want separate gears for the car.
     * In this case, we add a qualifier annotation.
     * This is any annotation that itself has a @Qualifier annotation.
     * Here’s the declaration of @Named, a qualifier annotation included in javax.inject:
     */
    @Provides
    @Named("auto")
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
    fun provideAutoCar(engine: Engine, @Named("auto") gear: Gear): Car {
        return GoodCar(engine, gear)
    }
}