package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * Class for representing a sphere
 */
public class Sphere implements Geometry {
    /**
     * Center of sphere
     */
    private Point center;
    /**
     * Radius of sphere
     */
    private double radius;

    /**
     * Ctor for sphere
     *
     * @param _radius sphere radius
     * @param _center sphere center
     */
    public Sphere(Point _center, double _radius) {
        center = _center;
        radius = _radius;
    }

    /**
     * get function for center of sphere
     *
     * @return sphere center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * get function for radius of sphere
     *
     * @return sphere radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * function for printing sphere info
     */
    @Override
    public String toString() {
        return "Sphere: " +
                "center: " + center +
                "radius: " + radius;
    }

    @Override
    public Vector getNormal(Point point) {
        Vector v=point.subtract(center);
        return v.normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {

        Point p0 = ray.getP0();
        Point D = center;
        Vector V = ray.getDir();

        double tm=0,d=0;
        try{
            Vector U = D.subtract(p0);
            tm = V.dotProduct(U);
            d = Math.sqrt(U.lengthSquared() - tm * tm);
        }
        catch (IllegalArgumentException e){ }

        // no intersections : the ray direction is above the sphere
        if (d >= radius) {
            return null;
        }

        double th = Math.sqrt(radius * radius - d * d);
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if ((t1 > 0) && (t2 > 0)) {
            // Point P1 = P0.add(v.scale(t1));
            // Point P2 = P0.add(v.scale(t2));
            Point p1 = ray.getPoint(t1);
            Point p2 = ray.getPoint(t2);
            return (List.of(p1, p2));
        }

        if (t1 > 0) {
            // Point P1 = P0.add(v.scale(t1));
            Point p1 = ray.getPoint(t1);
            return List.of(p1);
        }

        if (t2 > 0) {
            // Point P2 = P0.add(v.scale(t2));
            Point p2 = ray.getPoint(t2);
            return List.of(p2);
        }

        return null;
    }
}
