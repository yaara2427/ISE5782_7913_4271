package primitives;

import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
//import static org.testng.AssertJUnit.assertTrue;
import static primitives.Util.isZero;
class VectorTest {

    @Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);

        // =============== Boundary Values Tests ==================
        assertTrue(isZero(v1.dotProduct(v3)), "ERROR: dotProduct() for orthogonal vectors is not zero");

        // ============ Equivalence Partitions Tests ==============
        assertTrue(isZero(v1.dotProduct(v2) + 28), "ERROR: dotProduct() wrong value");
    }

    @Test
    void testAdd() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector v1 = new Vector(1, -5, 20);
        Vector v2 = new Vector(-8, 3, 10);
        assertEquals(v1.add(v2), new Vector(-7, -2, 30), "ERROR: add() wrong value");
    }

    @Test
    void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector v1 = new Vector(17, 5, 2);
        Vector v2 = new Vector(-7, 4, 8);
        assertEquals(v1.subtract(v2), new Vector(24, 1, -6), "ERROR: subtract() wrong value");
    }

    @Test
    void testLengthSquared() {
        Vector v1 = new Vector(1, 2, 3);
        assertTrue(isZero(v1.lengthSquared() - 14), "ERROR: lengthSquared() wrong value");

    }

    @Test
    void testLength() {
        assertTrue(isZero(new Vector(0, 3, 4).length() - 5), "ERROR: length() wrong value");
    }
}
