package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Class for representing a plane
 */
public class Plane implements Geometry{
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
    public List<Point> findIntersections(Ray ray) {

        Point P0 = ray.getP0();
        Vector v = ray.getDir();
        Vector n = normal;

        double nv = alignZero(n.dotProduct(v));

        //direction of ray parallel to the plane : no intersections
        if (isZero(nv)){
            return null;
        }

        // ray origin cannot start from the plane
        if(P0.equals(q0)){
            return null;
        }
         Vector Q_P0 = q0.subtract(P0);

        double t = alignZero(n.dotProduct(Q_P0)/nv);

        if(t > 0){
            //Point P = P0.add(v.scale(t));
            Point P = ray.getPoint(t);
            return List.of(P);
        }
        return null;
    }
}
