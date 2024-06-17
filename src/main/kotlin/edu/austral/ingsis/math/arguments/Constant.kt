package edu.austral.ingsis.math.arguments

class Constant(private val value: Double) : IArgument {
    override fun getValue(args: String?): Double = value

    override fun toString(): String = value.toString()
}
