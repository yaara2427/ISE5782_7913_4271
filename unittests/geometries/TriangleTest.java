package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Triangle tr=new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals( new Vector(sqrt3, sqrt3, sqrt3), tr.getNormal(new Point(1d / 3, 1d / 3, 1d / 3)),"Bad normal to triangle");
    }

    @Test
    void testFindIntersections() {

        // ============ Equivalence Partitions Tests ==============
        Triangle tr = new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
        Plane pl = new Plane(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));

        // TC01: Inside triangle
        Ray ray = new Ray(new Point(1, 1, 1), new Vector(-1, -1, -1));
        assertEquals(List.of(new Point(1d / 3, 1d / 3, 1d / 3)), tr.findIntersections(ray),
                "Bad intersection");


        // TC02: Against edge
        ray = new Ray(new Point(0, 0, -1), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(1, 1, -1)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC03: Against vertex
        ray = new Ray(new Point(0, 0, 2), new Vector(-1, -1, 0));
        assertEquals(List.of(new Point(-0.5, -0.5, 2)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // =============== Boundary Values Tests ==================
        // TC11: In vertex
        ray = new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0, 1, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC12: On edge
        ray = new Ray(new Point(-1, -1, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0.5, 0.5, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC13: On edge continuation
        ray = new Ray(new Point(-2, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(-0.5, 1.5, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");
    }
}