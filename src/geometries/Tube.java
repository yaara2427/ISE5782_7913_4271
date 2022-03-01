package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;

public class Tube implements Geometry {
    protected Ray _axisRay;
    protected double _radius;

    public Tube(Ray axisRay, double radius) {
        _axisRay = axisRay;
        _radius = radius;
    }
    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
