package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * class for representing a tube
 */
public class Tube implements Geometry {
    /**
     * tube direction
     */
    protected final Ray axisRay;
    /**
     * tube radius
     */
    protected final double radius;
/**
     * ctor for tube
     *
     * @param _axisRay tube direction
     * @param _radius  tube radius
     */
    public Tube(Ray _axisRay, double _radius) {
        axisRay = _axisRay;
        radius = _radius;
    }
/**
     * get function for tube direction
     *
     * @return tube direction
     */
    public Ray getAxisRay() {
        return axisRay;
    }
/**
     * get function for tube radius
     *
     * @return tube radius
     */
    public double getRadius() {
        return radius;
    }
/**
     * function for printing tube info
     */
    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
