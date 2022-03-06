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
    public Sphere(Point _center, double _radius)
    {
        center= _center;
        radius = _radius;
    }
    /**
     * get function for center of sphere
     *
     * @return sphere center
     */
    public Point getCenter()
    {
        return center;
    }
/**
     * get function for radius of sphere
     *
     * @return sphere radius
     */
    public double getRadius()
    {
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
        return null;
    }

}
