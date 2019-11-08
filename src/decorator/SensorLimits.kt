package decorator

import interfaces.Sensor

class SensorLimits(private val current: Sensor, private val rangeLower:Int, private val rangeUpper:Int): Sensor {
    override fun getTemperatur(): Float {
        val tmp =current.getTemperatur()
        println("$tmp/${rangeLower.toFloat()}/${rangeUpper.toFloat()}")
        return if (tmp in rangeLower.toFloat()..rangeUpper.toFloat()) {
            tmp
        } else {
            getTemperatur()
        }
    }
}