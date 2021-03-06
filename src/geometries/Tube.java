package geometries;

import primitives.*;

import java.util.List;
import java.util.Objects;
import static primitives.Util.*;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * class for representing a tube
 */
public class Tube extends Geometry {
    /**
     * tube direction
     */
    protected final Ray axisRay;
    /**
     * tube radius
     */
    protected final double radius;
/**
     * ctor for tube
     *
     * @param _axisRay tube direction
     * @param _radius  tube radius
     */
    public Tube(Ray _axisRay, double _radius) {
        axisRay = _axisRay;
        radius = _radius;
    }
/**
     * get function for tube direction
     *
     * @return tube direction
     */
    public Ray getAxisRay() {
        return axisRay;
    }
/**
     * get function for tube radius
     *
     * @return tube radius
     */
    public double getRadius() {
        return radius;
    }
/**
     * function for printing tube info
     */
    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }

    @Override
    public Vector getNormal(Point point)
    {
        Point p0=axisRay.getP0();
        Vector v=axisRay.getDir();

        Vector p0_p= point.subtract(p0);
        double t=alignZero(p0_p.dotProduct(v));

        if (isZero(t)){
            return p0_p.normalize();
        }
        Point O=p0.add(v.scale(t));
        Vector O_P=point.subtract(O);

        return O_P.normalize();
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        return null;
    }
}