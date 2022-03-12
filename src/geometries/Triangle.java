package geometries;

import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * class for triangle
 */
public class Triangle extends Polygon {
    /**
     * constructor that gets points and builds a triangle accordingly
     *
     * @param p1 first vertex
     * @param p2 second vertex
     * @param p3 third vertex
     */

    public Triangle(Point p1, Point p2, Point p3)
    {
        super(p1,p2,p3);
    }
/**
*function for printing triangle info 
*/
    @Override
    public String toString() {
        return "Triangle: " + "vertices: " + vertices + "plane: " + plane;}

    @Override
    public Vector getNormal(Point point) {
        return super.getNormal(point);
    }
}
