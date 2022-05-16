package renderer;

import geometries.Intersectable.GeoPoint;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.List;

public class RayTracerBasic extends RayTracerBase{

    /**
     * constructor with parameter
     * @param scene shapes scene
     */
    protected RayTracerBasic(Scene scene) {
        super(scene);
    }



    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        if (intersections == null)
            return scene.background;
        GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
        return calcColor(closestPoint, ray);
    }

    /**
     * calculates the color in a given point
     * @param closestPoint closest point to that ray start
     * @return color in the point
     */
    private Color calcColor(GeoPoint closestPoint, Ray ray) {
        return scene.ambientLight.getIntensity()
                .add(closestPoint.geometry.getEmission());
   }

}