package org.pandawarrior.app.dagger

import dagger.Component
import org.pandawarrior.app.vehicle.Car
import org.pandawarrior.app.vehicle.WeirdCar
import javax.inject.Singleton

/**
 * The @Inject and @Provides-annotated classes form a graph of objects, linked by their dependencies.
 * Calling code like an application’s main method or an Android Application accesses that graph via a well-defined set of roots.
 * In Dagger 2, that set is defined by an interface with methods that have no arguments and return the desired type.
 * By applying the @Component annotation to such an interface and passing the module types to the modules parameter,
 * Dagger 2 then fully generates an implementation of that contract.
 * source: https://google.github.io/dagger/users-guide.html
 */
@Singleton
@Component(modules = arrayOf(CarModule::class, EngineModule::class, GearModule::class))
interface CarMakerComponent {
    fun weirdCar(car: WeirdCar)
    fun normalCar(): Car
}