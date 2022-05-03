package primitives;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void testFindClosestPoint() {
        Ray ray=new Ray(Point.ZERO,new Vector(1,0,0));
        // ============ Equivalence Partitions Tests ==============

        //TC01: A point in the middle of the list is closest to the beginning of the ray
        List<Point> points= new ArrayList<>(3);
        points.add(new Point(2,0,0));
        points.add(new Point(1,0,0));
        points.add(new Point(3,0,0));
        assertEquals(new Point(1,0,0),ray.findClosestPoint(points),"getClosestPoint() middle list point");

        // =============== Boundary Values Tests ==================

        // TC11: Empty list
        points=new LinkedList<>();
        assertNull(ray.findClosestPoint(points),"getClosestPoint() empty list");

        // TC12: First point is closest to the beginning of the ray
        points= new ArrayList<>(3);
        points.add(new Point(1,0,0));
        points.add(new Point(3,0,0));
        points.add(new Point(2,0,0));
        assertEquals(new Point(1,0,0),ray.findClosestPoint(points),"getClosestPoint() first point");

        // TC13: Last point is closest to the beginning of the ray
        points= new ArrayList<>(3);
        points.add(new Point(3,0,0));
        points.add(new Point(6,0,0));
        points.add(new Point(1,0,0));
        assertEquals(new Point(1,0,0),ray.findClosestPoint(points),"getClosestPoint() last point");
    }
}