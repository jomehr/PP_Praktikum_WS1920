package components

import interfaces.Sensor
import kotlin.random.Random

class UpDownSensor: Sensor {
    var startTemp = 10F

    override fun getTemperatur(): Float {
        startTemp += Random.nextInt(-1,1)
        return startTemp
    }
}