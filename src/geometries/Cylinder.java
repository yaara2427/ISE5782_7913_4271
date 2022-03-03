package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
public class Cylinder extends Tube {
    private double height;

    public Cylinder(Ray axisRay, double radius, double _height) {
        super(axisRay, radius);
        if (_height <= 0)
            throw new IllegalArgumentException("height has to be positive");
       height = _height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "axisRay: " + axisRay+
                "radius: " + radius +
                '}';
    }

    public Vector getNormal(Point point) {
        return null;
    }

}
