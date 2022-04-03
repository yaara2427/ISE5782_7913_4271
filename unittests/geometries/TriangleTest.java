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
        Triangle tr = new Triangle(new Point(3, 2, 1), new Point(-2, 2, 1), new Point(0, -3, 1));

        // TC01: Inside triangle
        Ray ray = new Ray(new Point(4, -2, -1), new Vector(-6, 4, 4));
        List<Point> result = tr.findIntersections(ray);
        assertEquals(1, result.size(), "Ray intersection inside triangle");
        assertEquals(new Point(1, 0, 1), result.get(0), "Wrong point value");
    }
}