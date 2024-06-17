package edu.austral.ingsis.math.arguments

class Variable(private val name: String) : IArgument {
    override fun getValue(args: String?): Double {
        if (args == null) throw RuntimeException("No value for $name")
        val value = args.split(", ").find {
            it.split(" = ")[0] == name
        }
        return value?.split(" = ")?.get(1)?.toDouble()
            ?: throw RuntimeException("No value for $name")
    }

    override fun toString(): String = name
}
