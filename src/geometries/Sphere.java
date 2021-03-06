package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * Class for representing a sphere
 */
public class Sphere extends Geometry {
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
     * @param radius sphere radius
     * @param center sphere center
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
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
        Vector v = point.subtract(center);
        return v.normalize();
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        Point p0 = ray.getP0();
        Point D = center;
        Vector V = ray.getDir();
        double tm = 0, d = 0;

        try {
            Vector U = D.subtract(p0);
            tm = V.dotProduct(U);
            d = Math.sqrt(U.lengthSquared() - tm * tm);
        } catch (IllegalArgumentException e) {
        }

        if (d >= radius) {
            return null;
        }
        double th = Math.sqrt(radius * radius - d * d);
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if ((t1 > 0) && (t2 > 0)) {
            Point p1 = ray.getPoint(t1);
            Point p2 = ray.getPoint(t2);
            return (List.of(new GeoPoint(this,p1), new GeoPoint(this,p2)));
        }

        if (t1 > 0) {
            Point p1 = ray.getPoint(t1);
            return List.of(new GeoPoint(this,p1));
        }

        if (t2 > 0) {
            Point p2 = ray.getPoint(t2);
            return List.of(new GeoPoint(this,p2));
        }

        return null;
    }
}
