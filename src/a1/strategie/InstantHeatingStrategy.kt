package a1.strategie;

import a1.interfaces.HeatingStrategy

class InstantHeatingStrategy: HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
        return (last10measurements.last() < 19)
    }

}