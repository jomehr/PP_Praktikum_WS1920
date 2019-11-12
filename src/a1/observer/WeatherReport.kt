package a1.observer

import a1.interfaces.TemperatureObserver


class WeatherReport: TemperatureObserver {
    private val report:MutableList<Float> = ArrayList()
    private var oldTemp:Float = 0.0f
    override fun update(temperature: Float) {
        while(temperature != oldTemp && report.size != 100) {
            report.add(temperature)
            //println("size ${report.size}")
            oldTemp = temperature
        }
        if(report.size == 100) {
            println(report)
            report.clear()
        }


    }
}