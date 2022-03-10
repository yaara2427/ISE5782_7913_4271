package geometries;

import primitives.Point;
import primitives.Vector;
/**
 * Class for representing a plane
 */
public class Plane {
    /**
     * The reference point on the plane
     */
    Point p0;
    /**
     * The normal vector to the plane
     */
    Vector normal;
/**
     * Ctor for plane that calculates normal vector to plane using cross product and saves @param p1 as reference point
     *
     * @param _p0 is the reference point
     * @param _normal is the normal vector to the plane
     */
    public Plane(Point p1, Point p2, Point p3) {
        p0 = p1;
        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector _normal = U.crossProduct(V);

        _normal.normalize();
        normal =_normal;
    } 
/**
     * Ctor for plane
     *
     * @param _p0 is the reference point
     * @param _normal is the normal vector to the plane
     */
    public Plane(Point _p0, Vector _normal) {
        p0= _p0;
        normal=_normal.normalize();
    }
    /** 
    * Get function for reference point on plane
    * @return p0
    */

    public Point getP0() {
        return p0;
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
                "p0=" + p0 +
                ", normal=" + normal +
                '}';
    }
}
