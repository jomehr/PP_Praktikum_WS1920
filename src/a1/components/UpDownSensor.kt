package a1.components

import kotlin.random.Random

class UpDownSensor: a1.interfaces.Sensor {
    private var startTemp = Random.nextInt(-10, 40).toFloat()

    override fun getTemperature(): Float {
        val random = Random.nextInt(-1,2)
        //println(random)
        startTemp += random
        return startTemp
    }
}