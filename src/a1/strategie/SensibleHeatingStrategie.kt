package a1.strategie

import a1.interfaces.HeatingStrategy

class SensibleHeatingStrategie() : HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
        val min = last10measurements.min()


            return  min!! <20
    }
}