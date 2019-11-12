package a1.interfaces

interface HeatingStrategy {
    fun needsHeating (last10measurements: List<Float>): Boolean
}