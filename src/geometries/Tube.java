package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;

public class Tube implements Geometry {
    protected final Ray axisRay;
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
