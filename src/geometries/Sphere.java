package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
public class Sphere implements Geometry {
    private Point _center;
    private double _radius;
    public Sphere(Point p, double radius)
    {
        _center=p;
        _radius =  radius;
    }
    @Override
    public Vector getNormal(Point p) {
        Vector v = p.subtract(_center);
        return v.normalize();
    }

    @Override
    public String toString() {
        return "Sphere: " +
                "center: " + _center +
                "radius: " + _radius;
    }
    public Point getCenter()
    {
        return _center;
    }
    public double getRadius()
    {
        return _radius;
    }
}
