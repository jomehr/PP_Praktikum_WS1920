package decorator

import interfaces.Sensor


class IgnoreDuplicates(private val current: Sensor): Sensor {
    private var last: Float = current.getTemperatur()

    override fun getTemperatur(): Float {
        //print("last$last")
        var bool = true
        while(bool) {
            val tmp = current.getTemperatur()
            if(tmp == last) {
                last = tmp
                return tmp
            }else bool = false
        }
        return last
    }
}