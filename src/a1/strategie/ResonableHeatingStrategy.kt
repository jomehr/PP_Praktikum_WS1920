package a1.strategie

import a1.interfaces.HeatingStrategy

class ResonableHeatingStrategy : HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
        return last10measurements.count { it < 19 } >= 5 || last10measurements.count { it < 15 } >= 1
    }
}