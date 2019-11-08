package observer

import interfaces.TemperatureObserver

class TemperatureAlert: TemperatureObserver {
    override fun update(temperature: Float) {
        if (temperature == 37F) println("Ganz schön heiß")
    }
}