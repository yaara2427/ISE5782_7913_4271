package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class VectorTest {
    @Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        // =============== Boundary Values Tests ==================
        assertTrue(isZero(v1.dotProduct(v3)),"ERROR: dotProduct() for orthogonal vectors is not zero");
        // ============ Equivalence Partitions Tests ==============
        assertTrue(isZero(v1.dotProduct(v2)+28),"ERROR: dotProduct() wrong value");
    }
    @Test
    void testAdd() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector v1 = new Vector(1, -5, 20);
        Vector v2 = new Vector(-8, 3, 10);
        assertEquals(v1.add(v2),
                new Vector(-7,-2,30),
                "ERROR: add() wrong value");
    }
    @Test
    void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector v1 = new Vector(17, 5, 2);
        Vector v2 = new Vector(-7, 4, 8);
        assertEquals(v1.subtract(v2),
                new Vector(24,1,-6),
                "ERROR: subtract() wrong value");
    }
    @Test
    void testLengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        assertTrue(isZero(v1.lengthSquared()-14),"ERROR: lengthSquared() wrong value");
    }
    @Test
    void testLength() {
        // ============ Equivalence Partitions Tests ==============
        assertTrue(isZero(new Vector(0, 3, 4).length()-5),"ERROR: length() wrong value");
    }
    @Test
    void testScale() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        double t=5;
        assertEquals(v1.scale(t),new Vector(5,10,15),"ERROR: scale() wrong value");
    }
    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);
        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals( v1.length() * v2.length(), vr.length(), 0.00001,"crossProduct() wrong result length");
        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 2nd operand");
        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows(IllegalArgumentException.class,
                () -> v1.crossProduct(v3),
                "" + "crossProduct() for parallel vectors does not throw an exception");
    }
    @Test
    void testNormalize()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();
        assertTrue(isZero(u.length() - 1),
                "ERROR: the normalized vector is not a unit vector");
        assertThrows(IllegalArgumentException.class,
                () ->v.crossProduct(u),
                "ERROR: the normalized vector is not parallel to the original one");
        assertTrue(v.dotProduct(u) > 0,
                "ERROR: the normalized vector is opposite to the original one");
    }


    @Test
    void testConstructorZero() {
        assertThrows(IllegalArgumentException.class,
                ()->{ new Vector(0,0,0);},
        "ERROR: zero vector should have thrown an exception");
    }
}