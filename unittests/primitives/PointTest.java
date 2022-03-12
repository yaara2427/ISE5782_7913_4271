package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    /**
     * Test for distanceSquared function
     */
    void testDistanceSquared() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(4,6,8);
        assertEquals( 50 ,p1.distanceSquared(p2),"ERROR: distanceSquared() does not work correctly");
    }
    /**
     * Test for distance function.
     */
    @Test
    void testDistance() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(4,6,8);
        assertEquals( Math.sqrt(50) ,p1.distance(p2),"ERROR: distance() does not work correctly");
    }
    /**
     * Test add distance function.
     */
    @Test
    void testAdd() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);
        assertEquals(p1.add(new Vector(-1, -2, -3)),Point.ZERO,"ERROR: Point + Vector does not work correctly");
    }
    /**
     * Test for subtract function.
     */
    @Test
    void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);
        assertEquals(new Vector(1, 1, 1), new Point(2, 3, 4).subtract(p1), "ERROR: Point - Point does not work correctly");
    }
}
