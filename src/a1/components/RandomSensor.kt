package a1.components

import a1.interfaces.Sensor
import kotlin.random.Random

class RandomSensor : Sensor {
    private val min  = -10
    private val max = 40
    override fun getTemperature(): Float = Random.nextFloat() * (max - min) + min
}
