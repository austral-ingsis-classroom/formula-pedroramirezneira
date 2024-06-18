import edu.austral.ingsis.math.arguments.Constant
import edu.austral.ingsis.math.arguments.Variable
import edu.austral.ingsis.math.functions.Function
import edu.austral.ingsis.math.arguments.operations.Addition
import edu.austral.ingsis.math.arguments.operations.Subtraction

fun main() {
    val function = Function(
        Addition(
            Constant(1.toDouble()),
            Subtraction(
                Variable("x"),
                Variable("y")
            )
        )
    )
    println(function.toString())
    println(function.evaluate("x = 2, y = 1"))
}
