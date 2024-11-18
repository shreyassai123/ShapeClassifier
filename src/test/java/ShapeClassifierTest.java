import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapeClassifierTest {

    /**
     * This is an example test 
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    @Test
    void testEvaluateGuess_MultipleIncorrectGuesses() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Scalene,Small,No,100,100,100"; // Multiple incorrect guesses
        String result = classifier.evaluateGuess(input);
        assertTrue(result.startsWith("No:"));
    }

    @Test
    void testEvaluateGuess_LineShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Line,Small,Yes,5";
        String result = classifier.evaluateGuess(input);
        assertEquals("Wrong Size,Wrong Even/Odd", result);
    }

    @Test
    void testEvaluateGuess_CircleShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Circle,Large,No,50,50";
        String result = classifier.evaluateGuess(input);
        assertEquals("Wrong Size,Wrong Even/Odd", result);
    }

    @Test
    void testEvaluateGuess_SquareShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Square,Small,Yes,5,5,5,5";
        String result = classifier.evaluateGuess(input);
        assertEquals("Yes: Wrong Even/Odd", result);
    }
}
