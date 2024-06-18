package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.arguments.Constant;
import edu.austral.ingsis.math.arguments.Variable;
import edu.austral.ingsis.math.arguments.operations.AbsoluteValue;
import edu.austral.ingsis.math.arguments.operations.Addition;
import edu.austral.ingsis.math.arguments.operations.Division;
import edu.austral.ingsis.math.arguments.operations.Exponentiation;
import edu.austral.ingsis.math.arguments.operations.Multiplication;
import edu.austral.ingsis.math.arguments.operations.Subtraction;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final var function = new DummyFunction(new Addition(new Constant(1), new Constant(6)));
    final var text = function.toString();
    final var result = text.split(", ");
    assertThat(text.isEmpty() ? List.of() : List.of(result), empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final var function = new DummyFunction(new Division(new Constant(12), new Variable("div")));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final var function =
        new DummyFunction(
            new Multiplication(
                new Division(new Constant(9), new Variable("x")), new Variable("y")));
    final var result = function.toString().split(", ");
    System.out.println(function);
    assertThat(List.of(result), containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final var function =
        new DummyFunction(
            new Exponentiation(
                new Division(new Constant(27), new Variable("a")), new Variable("b")));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final var function =
        new DummyFunction(
            new Exponentiation(new Variable("z"), new Division(new Constant(1), new Constant(2))));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final var function =
        new DummyFunction(
            new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8)));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final var function =
        new DummyFunction(
            new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8)));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final var function =
        new DummyFunction(
            new Multiplication(
                new Subtraction(new Constant(5), new Variable("i")), new Constant(8)));
    final var result = function.toString().split(", ");
    assertThat(List.of(result), containsInAnyOrder("i"));
  }
}
