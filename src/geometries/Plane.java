package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane {
    Point p0;
    Vector normal;

    public Plane(Point p1, Point p2, Point p3) {
        p0 = p1;
        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector _normal = U.crossProduct(V);

        _normal.normalize();
        normal =_normal;
    }

    public Plane(Point _p0, Vector _normal) {
        p0= _p0;
        normal=_normal.normalize();
    }

    public Point getP0() {
        return p0;
    }

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
