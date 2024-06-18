package edu.austral.ingsis.math.arguments

class Constant(private val value: Number) : IArgument {
    override fun getValue(args: String?): Double = value.toDouble()

    override fun toString(): String = value.toString()
}
