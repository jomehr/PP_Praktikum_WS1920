package decorator

import interfaces.Sensor


class SensorLogger(private val current: Sensor): Sensor{
    override fun getTemperatur() = current.getTemperatur().also { temperature -> println(temperature) }
}