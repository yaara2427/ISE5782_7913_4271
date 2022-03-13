package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void testConstructor() {
        // =============== Boundary Values Tests ==================

        //TC01: 2 points coinciding
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 2, 3), new Point(1, 2, 3), new Point(4, 5, 6)),
                "Failed constructing a correct plane");

        //TC02: The 3 points are on one line
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 2, 3), new Point(2, 4, 6), new Point(3, 6, 9)),
                "Failed constructing a correct plane");
    }
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane pl = new Plane(new Point(1, 0, 0), new Point(1, 1, 0), new Point(0, 1, 0));
        assertEquals(new Vector(0, 0, 1), pl.getNormal(new Point(0, 0, 1)), "Bad normal to plane");
    }
}