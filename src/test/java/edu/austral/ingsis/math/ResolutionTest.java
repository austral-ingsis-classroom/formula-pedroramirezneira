package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.arguments.Constant;
import edu.austral.ingsis.math.arguments.operations.AbsoluteValue;
import edu.austral.ingsis.math.arguments.operations.Addition;
import edu.austral.ingsis.math.arguments.operations.Division;
import edu.austral.ingsis.math.arguments.operations.Exponentiation;
import edu.austral.ingsis.math.arguments.operations.Multiplication;
import edu.austral.ingsis.math.arguments.operations.Subtraction;
import edu.austral.ingsis.math.functions.Function;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final var function = new Function(new Addition(new Constant(1), new Constant(6)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final var function = new Function(new Division(new Constant(12), new Constant(2)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final var function =
        new Function(
            new Multiplication(new Division(new Constant(9), new Constant(2)), new Constant(3)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final var function =
        new Function(
            new Exponentiation(new Division(new Constant(27), new Constant(6)), new Constant(2)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final var function =
        new Function(
            new Exponentiation(new Constant(36), new Division(new Constant(1), new Constant(2))));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final var function = new Function(new AbsoluteValue(new Constant(136)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final var function = new Function(new AbsoluteValue(new Constant(-136)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final var function =
        new Function(
            new Multiplication(new Subtraction(new Constant(5), new Constant(5)), new Constant(8)));
    final var result = function.evaluate(null);
    assertThat(result, equalTo(0d));
  }
}
