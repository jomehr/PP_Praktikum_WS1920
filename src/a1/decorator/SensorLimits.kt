package a1.decorator

import a1.interfaces.Sensor

class SensorLimits(private val current: Sensor, private val rangeLower:Int,
                   private val rangeUpper:Int): Sensor {
    override fun getTemperature(): Float {
        val tmp =current.getTemperature()
        //println("$tmp")
        return if (tmp in rangeLower.toFloat()..rangeUpper.toFloat()) {
            tmp
        } else {
            getTemperature()
        }
    }
}