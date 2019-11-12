package a1.decorator

import a1.interfaces.Sensor


class SensorLogger(private val current: Sensor): Sensor {
    override fun getTemperature() = current.getTemperature().also { temperature -> println(temperature) }
}