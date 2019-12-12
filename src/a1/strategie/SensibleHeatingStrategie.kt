package a1.strategie

import a1.interfaces.HeatingStrategy

class SensibleHeatingStrategie() : HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
            return  last10measurements.min()!! < 20
    }
}