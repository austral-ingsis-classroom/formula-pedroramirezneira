package edu.austral.ingsis.math.functions

import edu.austral.ingsis.math.arguments.IArgument

class Function(private val child: IArgument) : IFunction {
    override fun evaluate(args: String?): Double {
        return child.getValue(args)
    }

    override fun toString(): String {
        return "f = $child"
    }
}
