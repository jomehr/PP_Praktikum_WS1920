package decorator

import components.RandomSensor
import interfaces.Sensor
import kotlin.math.round

class RoundValues(private val current: Sensor): Sensor {
    override fun getTemperatur(): Float {
        return round(current.getTemperatur())
    }

}