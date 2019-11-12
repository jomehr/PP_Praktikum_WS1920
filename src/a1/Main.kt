package a1

import a1.components.RandomSensor
import a1.components.Thermometer
import a1.decorator.IgnoreDuplicates
import a1.decorator.SensorLimits
import a1.decorator.SensorLogger
import a1.observer.TemperatureAlert
import a1.observer.WeatherReport

fun main () {
    val t1 = Thermometer(
        SensorLogger(((IgnoreDuplicates(SensorLimits
        (RandomSensor(), 0,40)))))
    )
    t1.register(TemperatureAlert())
    t1.register(WeatherReport())
    t1.run(200)

    println("-----")
    //val t2 = Thermometer(SensorLogger(RoundValues(IgnoreDuplicates(UpDownSensor())))).run(20)
}