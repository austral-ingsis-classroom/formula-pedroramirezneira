package edu.austral.ingsis.math.functions

import edu.austral.ingsis.math.arguments.IArgument

class Function(private val child: IArgument) : IFunction {
    override fun evaluate(args: String?): Number = child.getValue(args)

    override fun toString(): String {
        val text = child.toString()
        if (text.startsWith("(") && text.endsWith(")")) {
            return "f = ${text.substring(1, text.length - 1)}"
        }
        return "f = $text"
    }
}
