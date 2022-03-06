package geometries;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * class for cylinder which is a finite tube
 */
public class Cylinder extends Tube {
    /**
     * height of cylinder
     */
    private double height;
/**
     * ctor for cylinder
     *
     * @param axisRay cylinder direction
     * @param radius  cylinder radius
     * @param _height  cylinder height
     */
    public Cylinder(Ray axisRay, double radius, double _height) {
        super(axisRay, radius);
        if (_height <= 0)
            throw new IllegalArgumentException("height has to be positive");
       height = _height;
    }
/**
     * get function for cylinder height
     *
     * @return the height of the cylinder
     */
    public double getHeight() {
        return height;
    }
/** 
*function for printing cylinder parameters to string
*/
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
