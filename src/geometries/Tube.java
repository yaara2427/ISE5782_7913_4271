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

    public Tube(Ray _axisRay, double _radius) {
        axisRay = _axisRay;
        radius = _radius;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    public double getRadius() {
        return radius;
    }

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
