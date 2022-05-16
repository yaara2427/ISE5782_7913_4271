package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Geometries extends Intersectable {
    private List<Intersectable> intersectables;

    public Geometries() {
        intersectables = new LinkedList<Intersectable>();
    }
    public Geometries(Intersectable... list){
        intersectables=new LinkedList<Intersectable>(Arrays.asList(list.clone()));
    }
    public void add(Intersectable... list)
    {
        Collections.addAll(intersectables, list);
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        if (intersectables == null) {
            return null;
        }
        List<GeoPoint> result = null;

        for (Intersectable geo : intersectables) {
            List<GeoPoint> geoPoints = geo.findGeoIntersectionsHelper(ray);
            if (geoPoints != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(geoPoints);
            }
        }
        return result;    }
}
