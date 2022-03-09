package Lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    private App appUnderTest;

    @BeforeEach
    void setUp() {
        appUnderTest = new App();
    }

    @Test
    void testIsEventNumber() {
        assertTrue(appUnderTest.isEventNumber(4));
    }
    @Test
    void testIsEventNumber3() {
        assertTrue(appUnderTest.isEventNumber(3));
    }
@Test
    void testIsEventNumber5() {
        assertTrue(appUnderTest.isEventNumber(5));
    }

    @Test
    void testMain() {
        // Setup
        // Run the test
        App.main(new String[]{"args"});

        // Verify the results
    }
}
