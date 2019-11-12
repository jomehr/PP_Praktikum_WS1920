package a1.observer

import a1.interfaces.TemperatureObserver

class TemperatureAlert(): TemperatureObserver {
    override fun update(temperature: Float) {
        if (temperature >= 37F) println("Ganz schön heiß")
    }
}