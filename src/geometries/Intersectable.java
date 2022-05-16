package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

public abstract class Intersectable {

    /**
     * class for representation a point on a shape
     */
    public static class GeoPoint {

        /**
         * the geometry of which the point is on
         */
        public Geometry geometry;

        /**
         * the point on the geometry
         */
        public Point point;

        /**
         * constructor with parameters
         * @param geometry shape
         * @param point on the shape
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GeoPoint geoPoint = (GeoPoint) o;

            return ((geometry.equals(geoPoint.geometry)) && (point.equals(geoPoint.point)));
        }

        @Override
        public int hashCode() {
            int result = geometry != null ? geometry.hashCode() : 0;
            result = 31 * result + (point != null ? point.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }

    /***
     * finds the intersections points of the ray with the shape
     * @param ray intersecting ray
     * @return intersections points
     */
    public List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream().map(gp -> gp.point).toList();
    }

    /**
     * finds the intersections geoPoints of the ray with the shape
     * @param ray intersecting ray
     * @return intersections geoPoints
     */
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray);
    }

    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);

}