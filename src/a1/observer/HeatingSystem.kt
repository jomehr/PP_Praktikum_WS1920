package a1.observer

import a1.interfaces.HeatingStrategy
import a1.interfaces.TemperatureObserver
import a1.strategie.InstantHeatingStrategy

class HeatingSystem (private val heat: HeatingStrategy): TemperatureObserver {

    private var last10measurements = mutableListOf<Float>()

    override fun update(temperature: Float) {

        last10measurements.add(temperature)
        if(heat.needsHeating(last10measurements.takeLast(10))){
            println("Heizung wird eingeschaltet")
            last10measurements.removeAt(0)
        }
        else{
            println("Heizung wird ausgeschaltet")
            last10measurements.removeAt(0)
        }

    }

}