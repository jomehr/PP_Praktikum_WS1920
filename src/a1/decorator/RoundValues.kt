package a1.decorator

import a1.interfaces.Sensor
import kotlin.math.round

class RoundValues(private val current: Sensor): Sensor {
    override fun getTemperature(): Float {
        return round(current.getTemperature())
    }

}