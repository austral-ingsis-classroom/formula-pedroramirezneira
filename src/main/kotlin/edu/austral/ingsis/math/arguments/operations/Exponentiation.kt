package edu.austral.ingsis.math.arguments.operations

import edu.austral.ingsis.math.arguments.IArgument
import kotlin.math.pow

class Exponentiation(private val a: IArgument, private val b: IArgument) : IArgument {
    override fun getValue(args: String?): Double = a.getValue(args).pow(b.getValue(args))

    override fun toString(): String = "($a ^ $b)"
}
