package renderer;

import primitives.*;
import scene.Scene;


/**
 * abstract class for the color of the shape that intersects the ray first.
 */
public abstract class RayTracerBase {
    /**
     * scene of the shapes
     */
    protected final Scene scene;

    /**
     * constructor with parameter
     * @param scene shapes scene
     */
    protected RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * finds the color of the shape that intersects the ray first
     * @param ray camera ray
     * @return shape color
     */
    public abstract Color traceRay(Ray ray);
}
