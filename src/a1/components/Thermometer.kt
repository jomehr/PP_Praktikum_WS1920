package a1.components

import a1.interfaces.Sensor
import a1.interfaces.TemperatureObserver

class Thermometer(private val sensor: Sensor) {

    private val observerList = mutableListOf<TemperatureObserver>()

    fun run(iterations: Int) {
        for (x in 0..iterations) update(sensor.getTemperature())
    }

    fun register(observer: TemperatureObserver) {
        observerList.add(observer)
    }

    fun unregister(observer: TemperatureObserver) {
        observerList.remove(observer)
    }

    fun update(temperature: Float) {
        for(obs in observerList) {
            obs.update(temperature)
        }
    }
}