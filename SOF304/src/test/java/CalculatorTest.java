import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculatorUnderTest;

    @BeforeEach
    void setUp() {
        calculatorUnderTest = new Calculator();
    }

    @Test
    void testTong() {
        assertEquals(4, calculatorUnderTest.tong(1, 3));
    }

    @Test
    void testTru() {
        assertEquals(3, calculatorUnderTest.tru(8, 5));
    }

    @Test
    void testNhan() {
        assertEquals(4, calculatorUnderTest.nhan(2, 2));
    }

    @Test
    void testChia() {
        assertEquals(5, calculatorUnderTest.chia(1, 2));
    }

    @Test
    void testMain() {
        // Setup
        // Run the test
        Calculator.main(new String[]{"args"});

        // Verify the results
    }
}
