package components

import interfaces.Sensor

class Thermometer(val sensor: Sensor) {

    fun run(iterations: Int) {
        for (x in 0..iterations) sensor.getTemperatur()
    }
}