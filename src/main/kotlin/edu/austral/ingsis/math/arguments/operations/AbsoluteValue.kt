package edu.austral.ingsis.math.arguments.operations

import edu.austral.ingsis.math.arguments.IArgument
import kotlin.math.abs

class AbsoluteValue(private val value: IArgument) : IArgument {
    override fun getValue(args: String?): Double = abs(value.getValue(args))

    override fun toString(): String = "|$value|"
}
