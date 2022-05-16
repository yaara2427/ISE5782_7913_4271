package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public abstract  class Geometry  extends Intersectable{

    protected Color emission=Color.BLACK;

    public abstract Vector getNormal(Point point);

    /**
     * get the emission color
     * @return emission
     */

    public Color getEmission() {
        return emission;
    }

    /**
     * set the emission color
     * @param emission
     * @return the object
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

}
