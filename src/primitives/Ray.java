package primitives;

import geometries.Intersectable.GeoPoint;

import java.util.List;
import java.util.Objects;


import static primitives.Util.isZero;

/**
 * Class for representing a ray
 */
public class Ray {
    /**
     * Starting point of the ray
     */
    Point p0;
    /**
     * Vector that determines the ray's direction
     */
    Vector dir;
 /**
     * Constructor that normalizes the given vector and sets the starting point to @param _p0
     *
     * @param p0  point of the ray beginning
     * @param dir direction vector
     */
    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();
    }
 /**
     * get function for the ray's starting point
     * @return p0
     */
    public Point getP0() {
        return p0;
    }
     /**
     * get function for the ray's direction vector
     * @return dir
     */

    public Vector getDir() {
        return dir;
    }

     /**
     * function to print ray info
     */
    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }

    public Point getPoint(double t) {
        // if t = zero return p0
        if(isZero(t)) {
            return p0;
        }
        return p0.add(this.dir.scale(t));
    }

    /**
     * finding the closest point from the list to the ray start
     * @param points list of intersections points
     * @return closest point from the list
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
    }


    /**
     * finds the closest point intersected with the ry
     * @param geoPointsList list of tje shape intersected with the ray
     * @return closest geoPoint
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> geoPointsList) {
        GeoPoint result = null;
        if (geoPointsList == null) {
            return null;
        }

        //finding the shortest distance between the point and the ray start point
        double distance = Double.MAX_VALUE;
        for (GeoPoint gp : geoPointsList) {
            double dist = p0.distance(gp.point);
            if (dist < distance) {
                distance = dist;
                result = gp;
            }
        }
        return result;
    }
}