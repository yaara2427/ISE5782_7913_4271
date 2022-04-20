package renderer;

import primitives.*;

import static primitives.Util.isZero;

public class Camera {

    // camera location
    private Point p0;

    // front vector of the camera
    private Vector vTo;

    // upward vector of the camera
    private Vector vUp;

    // right vector of the camera
     private Vector vRight;

    // view plane hight
    private double hight;

    // view plane width
    private double width;

    //distance between the view plane and the Camera
    private double distance;

    /**
     * constructor that gets the camera location -point, front vector and upward vector- and calculated right vector
     * @param p0 camera location
     * @param vTo front vector of the camera
     * @param vUp upward vector of the camera
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vUp.dotProduct(vTo))) {
            throw new IllegalArgumentException("vTo is not orthogonal to vUp");
        }
        this.p0 = p0;

        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();

        vRight = vTo.crossProduct(vUp);
    }

    /**
     * getter of p0
     * @return po
     */
    public Point getP0() {
        return p0;
    }

    /**
     * getter of vTo
     * @return vTo
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * getter of vUp
     * @return vUp
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * getter of vRight
     * @return vRight
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * getter of hight
     * @return hight
     */
    public double getHight() {
        return hight;
    }

    /**
     * getter of width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * getter of distance
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * sets the size of the view plane
     * @param width view plane width
     * @param hight view plane hight
     * @return "this": camera current instance
     */
    public Camera setVPSize(double width, double hight){
        this.width = width;
        this.hight = hight;
        return  this;
    }

    /**
     * setter of distance
     * @param distance distance
     * @return distance between the view plane and athe camera
     */
    public Camera setVPDistance(double distance) {
        this.distance= distance;
        return this;
    }

    /**
     * creats a ray  from the camera throgh a specific pixel center
     * @param nX - number of pixels in view plane width
     * @param nY - number of pixels in view plane hight
     * @param j - distance of tje intercept from tje midpoint on the y-axis
     * @param i - distance of tje intercept from tje midpoint on the x-axis
     * @return ray from the camera through a specific pixel center
     */
    public Ray constructRay(int nX, int nY, int j, int i){
        Point Pc = p0.add(vTo.scale(distance));
        double Ry = hight / nY;
        double Rx = width / nX;

        Point Pij = Pc;
        double Xj = (j - (nX - 1) / 2d) * Rx;
        double Yi = (i - (nY - 1) / 2d) * Ry;
        if (!isZero(Xj)) {
            Pij = Pij.add(vRight.scale(Xj));
        }
        if (!isZero(Yi)) {
            Pij = Pij.add(vUp.scale(-Yi));
        }
        return new Ray(p0, Pij.subtract(p0));
    }
}
