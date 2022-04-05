package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
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
    public List<Point> findIntersections(Ray ray) {
        if(intersectables==null){
            return null;
        }
        List<Point> result = null;
        for (Intersectable geo : intersectables) {
            List<Point> geoPoints = geo.findIntersections(ray);
            if (geoPoints != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(geoPoints);
            }
        }
        return result;
    }
}
