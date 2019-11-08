package observer

import interfaces.TemperatureObserver

class WeatherReport: TemperatureObserver {

    private val report:MutableList<Float> = ArrayList()
    override fun update(temperature: Float) {
        while(report.size != 100) {
            report.add(temperature)
        }
        if(report.size == 100) print(report)

    }
}