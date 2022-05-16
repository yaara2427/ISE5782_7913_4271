package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Class for representing a plane
 */
public class Plane extends Geometry{
    /**
     * The reference point on the plane
     */
    Point q0;
    /**
     * The normal vector to the plane
     */
    Vector normal;

    /**
     * Ctor for plane that calculates normal vector to plane using cross product and saves @param p1 as reference point
     **
     * @param p1 first point of the plane
     * @param p2
     * @param p3
     */
    public Plane(Point p1, Point p2, Point p3) {
        q0 = p1;
        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector _normal = U.crossProduct(V);

        normal= _normal.normalize();
    } 
/**
     * Ctor for plane
     *
     * @param p0 is the reference point
     * @param normal is the normal vector to the plane
     */
    public Plane(Point p0, Vector normal) {
        q0= p0;
        this.normal=normal.normalize();
    }
    /** 
    * Get function for reference point on plane
    * @return p0
    */

    public Point getQ0() {
        return q0;
    }
    /** 
    * Get function for normal vector to plane
    * @return normal
    */

    public Vector getNormal() {
        return normal;
    }

    public Vector getNormal(Point point) {
        return normal;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "p0=" + q0 +
                ", normal=" + normal +
                '}';
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        Point p0 = ray.getP0();
        Vector V = ray.getDir();
        if (p0.equals(q0))
            return null;
        Vector U = q0.subtract(p0);

        //tD=denominator of parameter t
        double tD = normal.dotProduct(U);

        //tN=numerator of parameter t
        double tN = normal.dotProduct(V);

        //the ray begins in the same point which appears as
        //reference point in the plane
        if (p0.equals(q0)) {
            return null;
        }

        //the ray begins in the plane
        if (isZero(tD)) {
            return null;
        }

        //Ray is parallel to the plane
        if (isZero(tN)) {
            return null;
        }
        double t = tD / tN;

        //if there is an intersection point
        if (t > 0) {
            Point iP = ray.getPoint(t);
            return List.of(new GeoPoint(this,iP));
        } else {
            return null;
        }
    }
}
