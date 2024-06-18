package edu.austral.ingsis.math

import edu.austral.ingsis.math.arguments.IArgument
import edu.austral.ingsis.math.functions.IFunction

class DummyFunction(private val child: IArgument) : IFunction {
    override fun evaluate(args: String?): Number = child.getValue(args)

    override fun toString(): String = toString(null)

    private fun toString(args: String? = null): String {
        try {
            evaluate(args)
            return args?.split(", ")?.joinToString(", ") { it.split(" = ")[0] } ?: ""
        } catch (e: RuntimeException) {
            val variable = e.toString().split("No value for ")[1]
            return when (args) {
                null -> toString("$variable = 1")
                else -> toString("$args, $variable = 1")
            }
        }
    }
}
