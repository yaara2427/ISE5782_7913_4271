package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
public class Cylinder extends Tube {
    private double _height;
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        if (height <= 0)
            throw new IllegalArgumentException("height has to be positive");
       _height = height;
    }
    public Vector getNormal(Point point) {
        return null;
    }
    @Override
    public String toString() {
        return "Cylinder: " + "height: " + _height + "axisRay: " + _axisRay + "radius: " + _radius;
    }

}
