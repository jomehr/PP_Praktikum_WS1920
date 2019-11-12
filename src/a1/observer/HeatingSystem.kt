package a1.observer

import a1.interfaces.TemperatureObserver
import a1.strategie.InstantHeatingStrategy

class HeatingSystem: TemperatureObserver {

    private var last10measurements = mutableListOf<Float>()
    private val heat = InstantHeatingStrategy()
    private var status : Boolean = false

    override fun update(temperature: Float) {

        last10measurements.add(temperature)

        if(heat.needsHeating(last10measurements.takeLast(10))){
            println("Heizung wird eingeschaltet")
            status = true
        }
        else{
            status = false
            println("Heizung wird ausgeschaltet")
        }

    }

}