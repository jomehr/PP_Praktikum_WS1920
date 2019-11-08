import components.RandomSensor
import components.Thermometer
import components.UpDownSensor
import decorator.IgnoreDuplicates
import decorator.RoundValues
import decorator.SensorLimits
import decorator.SensorLogger

fun main () {
    Thermometer(SensorLogger(RoundValues(SensorLimits(RandomSensor(), 0,10))))
        .sensor.getTemperatur()
    println("-----")
    Thermometer(SensorLogger(RoundValues(IgnoreDuplicates(UpDownSensor())))).run(10)
}