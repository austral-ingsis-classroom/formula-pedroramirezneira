package edu.austral.ingsis.math.arguments.operations

import edu.austral.ingsis.math.arguments.IArgument
import kotlin.math.sqrt

class Roots(private val value: IArgument) : IArgument {
    override fun getValue(args: String?): Double = sqrt(value.getValue(args))

    override fun toString(): String = "√($value)"
}
