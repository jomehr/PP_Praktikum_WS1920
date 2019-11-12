package a1.decorator

import a1.interfaces.Sensor


class IgnoreDuplicates(private val current: Sensor): Sensor {
    //var last:Float = BigDecimal(current.getTemperature().toDouble()).setScale(2, RoundingMode.HALF_EVEN).toFloat()
    private var last = current.getTemperature()

    override fun getTemperature(): Float {
        //print("last: $last")
        //val tmp = BigDecimal(current.getTemperature().toDouble()).setScale(2, RoundingMode.HALF_EVEN).toFloat()
        val tmp = current.getTemperature()
        return if(tmp != last) {
            //println("tmp: $tmp")
            last = tmp
            return tmp
        }else{
            getTemperature()
        }
    }
}