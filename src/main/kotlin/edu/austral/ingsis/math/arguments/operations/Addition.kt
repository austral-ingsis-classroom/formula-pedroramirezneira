package edu.austral.ingsis.math.arguments.operations

import edu.austral.ingsis.math.arguments.IArgument

class Addition(private val a: IArgument, private val b: IArgument) : IArgument {
    override fun getValue(args: String?): Double = a.getValue(args) + b.getValue(args)

    override fun toString(): String = "($a + $b)"
}
