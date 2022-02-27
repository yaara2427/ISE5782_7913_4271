package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane {
    Point p0;
    Vector normal;

    public Plane(Point p1, Point p2, Point p3) {

    }

    public Plane(Point _p0, Vector _normal) {
        p0= _p0;
        normal=_normal.normalize();
    }
}
