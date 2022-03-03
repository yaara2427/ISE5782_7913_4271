package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
public class Sphere implements Geometry {
    private Point center;
    private double radius;
    public Sphere(Point _center, double _radius)
    {
        center= _center;
        radius = _radius;
    }
    public Point getCenter()
    {
        return center;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public String toString() {
        return "Sphere: " +
                "center: " + center +
                "radius: " + radius;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }

}
