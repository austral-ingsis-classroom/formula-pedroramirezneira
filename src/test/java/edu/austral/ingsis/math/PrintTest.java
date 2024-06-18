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

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "f = 1 + 6";
    final var function = new Function(new Addition(new Constant(1), new Constant(6)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "f = 12 / 2";
    final var function = new Function(new Division(new Constant(12), new Constant(2)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "f = (9 / 2) * 3";
    final var function =
        new Function(
            new Multiplication(new Division(new Constant(9), new Constant(2)), new Constant(3)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "f = (27 / 6) ^ 2";
    final var function =
        new Function(
            new Exponentiation(new Division(new Constant(27), new Constant(6)), new Constant(2)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "f = |value| - 8";
    final String result = expected;

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "f = |value| - 8";
    final var function =
        new Function(new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "f = (5 - i) * 8";
    final var function =
        new Function(
            new Multiplication(
                new Subtraction(new Constant(5), new Variable("i")), new Constant(8)));
    final var result = function.toString();
    assertThat(result, equalTo(expected));
  }
}
