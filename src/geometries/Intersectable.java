package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

public interface Intersectable {

    /***
     * finds the intersections of the ray and the shape
     * @param ray intersecting ray
     * @return intersections of the ray and the shape
     */
    List<Point> findIntersections(Ray ray);
}