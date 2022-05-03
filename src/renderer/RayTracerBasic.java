package renderer;

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
        List<Point> intersections = scene.geometries.findIntersections(ray);
        if (intersections == null)
            return scene.background;
        Point closestPoint = ray.findClosestPoint(intersections);
        return calcColor(closestPoint);
    }

    /**
     * calculates the color in a given point
     * @param closestPoint closest point to that ray start
     * @return color in the point
     */
    private Color calcColor(Point closestPoint) {
        return scene.ambientLight.getIntensity();
    }
}