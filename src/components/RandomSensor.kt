package components

import interfaces.Sensor
import kotlin.random.Random

class RandomSensor : Sensor {
    private val min  = 0
    private val max = 20
    override fun getTemperatur(): Float = Random.nextFloat() * (max - min) + min
}
