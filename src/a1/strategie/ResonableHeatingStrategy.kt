package a1.strategie

import a1.interfaces.HeatingStrategy

class ResonableHeatingStrategy : HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
        /*   val temp = 0
        for(i in 0 until last10measurements.size){
            temp+last10measurements[1]
        }
        return temp<195
    }*/
        val below19 = last10measurements.count { it < 19 }
        val below15 = last10measurements.count { it < 15 }
        return below19 >= 5 || below15 >= 1
    }
}