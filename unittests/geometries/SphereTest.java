package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void testGetNormal() {

        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Sphere sp=new Sphere(new Point(1,2,3),1d);
        assertEquals( new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)), sp.getNormal(new Point(2, 3, 4)),"Bad normal to sphere");
    }

    /**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(new Point (1, 0, 0), 1d);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),
                "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals(2, result.size(), "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(p1, p2), result, "Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        sphere = new Sphere(new Point(0, 0, 2), 1d);
        Ray ray=new Ray(new Point(0, 1d/2, 2),new Vector(0,1d/2,0));
        result= sphere.findIntersections(ray);
        assertEquals(1,result.size(),"Wrong number of points");
        assertEquals(new Point(0,1,2),result.get(0),"Ray starts inside the sphere");

        // TC04: Ray starts after the sphere (0 points)
        ray=new Ray(new Point(0, 2, 2),new Vector(0,3,0));
        assertNull(sphere.findIntersections(ray),"Ray starts after the sphere");


        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        ray=new Ray(new Point(0, 1, 2),new Vector(1,-2,0));
        result=sphere.findIntersections(ray);
        assertEquals(1,result.size(),"Wrong number of points");
        assertEquals(new Point(0.8,-0.6,2),result.get(0),"Ray starts at sphere and goes inside");

        // TC12: Ray starts at sphere and goes outside (0 points)
        ray=new Ray(new Point(0.8, -0.6, 2),new Vector(0.2,-0.4,0));
        assertNull(sphere.findIntersections(ray),"Ray starts at sphere and goes outside");

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        ray=new Ray(new Point(0, 2, 2),new Vector(0,-2,0));
        result=sphere.findIntersections(ray);
        assertEquals(result.size(),2,"Wrong number of points");
        if (result.get(0).getY() > result.get(1).getY())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(new Point(0,-1,2), new Point(0,1,2)), result, "Ray starts before the sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        ray=new Ray(new Point(0, 1, 2),new Vector(0,-1,0));
        result=sphere.findIntersections(ray);
        assertEquals(1,result.size(),"Wrong number of points");
        assertEquals(new Point(0,-1,2),result.get(0),"Ray starts at sphere and goes inside");

        // TC15: Ray starts inside (1 points)
        ray=new Ray(new Point(0, 0.5, 2),new Vector(0,-0.5,0));
        result=sphere.findIntersections(ray);
        assertEquals(1,result.size(),"Wrong number of points");
        assertEquals(new Point(0,-1,2),result.get(0),"Ray starts inside");

        // TC16: Ray starts at the center (1 points)
        ray=new Ray(new Point(0, 0, 2),new Vector(0,-1,0));
        result=sphere.findIntersections(ray);
        assertEquals(1,result.size(),"Wrong number of points");
        assertEquals(new Point(0,-1,2),result.get(0),"Ray starts at the center");

        // TC17: Ray starts at sphere and goes outside (0 points)
        ray=new Ray(new Point(0, -1, 2),new Vector(0,-1,0));
        assertNull(sphere.findIntersections(ray),"Ray starts at sphere and goes outside");

        // TC18: Ray starts after sphere (0 points)
        ray=new Ray(new Point(0, -2, 2),new Vector(0,-1,0));
        assertNull(sphere.findIntersections(ray),"Ray starts at sphere and goes outside");

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        ray=new Ray(new Point(0, -2, 3),new Vector(0,1,0));
        assertNull(sphere.findIntersections(ray),"Ray's line is tangent to the sphere, Ray starts before the tangent point");

        // TC20: Ray starts at the tangent point
        ray=new Ray(new Point(0, 0, 3),new Vector(0,2,0));
        assertNull(sphere.findIntersections(ray),"Ray's line is tangent to the sphere, Ray starts at the tangent point");

        // TC21: Ray starts after the tangent point
        ray=new Ray(new Point(0, 1, 3),new Vector(0,1,0));
        assertNull(sphere.findIntersections(ray),"Ray's line is tangent to the sphere, Ray starts after the tangent point");


        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        ray=new Ray(new Point(-2, 2, 2),new Vector(2,0,0));
        assertNull(sphere.findIntersections(ray),"Ray's line is outside, ray is orthogonal to ray start to sphere's center line");
    }
}