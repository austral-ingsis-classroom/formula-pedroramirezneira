package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.arguments.Constant;
import edu.austral.ingsis.math.arguments.Variable;
import edu.austral.ingsis.math.arguments.operations.AbsoluteValue;
import edu.austral.ingsis.math.arguments.operations.Addition;
import edu.austral.ingsis.math.arguments.operations.Division;
import edu.austral.ingsis.math.arguments.operations.Exponentiation;
import edu.austral.ingsis.math.arguments.operations.Multiplication;
import edu.austral.ingsis.math.arguments.operations.Subtraction;
import edu.austral.ingsis.math.functions.Function;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final var function = new Function(new Addition(new Constant(1), new Variable("x")));
    final var result = function.evaluate("x = 3");
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final var function = new Function(new Division(new Constant(12), new Variable("div")));
    final var result = function.evaluate("div = 4");
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final var function =
        new Function(
            new Multiplication(
                new Division(new Constant(9), new Variable("x")), new Variable("y")));

    final var result = function.evaluate("x = 3, y = 4");
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final var function =
        new Function(
            new Exponentiation(
                new Division(new Constant(27), new Variable("a")), new Variable("b")));
    final var result = function.evaluate("a = 9, b = 3");
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final var function =
        new Function(
            new Exponentiation(new Variable("z"), new Division(new Constant(1), new Constant(2))));
    final var result = function.evaluate("z = 36");
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final var function =
        new Function(new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8)));
    final var result = function.evaluate("value = 8");
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final var function =
        new Function(new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8)));
    final var result = function.evaluate("value = 8");
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final var function =
        new Function(
            new Multiplication(
                new Subtraction(new Constant(5), new Variable("i")), new Constant(8)));
    final var result = function.evaluate("i = 2");
    assertThat(result, equalTo(24d));
  }
}
