package primitives;

public class Vector extends Point {

    /*
    constructor for Vector class
    x value for X Coordinate of the head Point
    y value for Y Coordinate of the head Point
    z value for Z Coordinate of the head Point
    */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (Double3.ZERO.equals(xyz)) {
            throw new IllegalArgumentException("ZERO vector not allowed");
        }
    }

    @Override
    public String toString() {
        return "Vector: " + xyz;
    }


    /*
    * @param another Object to compare
    * @return true or false accordingly
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /*
     * add method
     * @param other the vector to add
     * @return algebraic added vector
     */
    public Vector add(Vector other) {

        Double3 result = new Double3(
                xyz.d1 + other.xyz.d1,
                xyz.d2 + other.xyz.d2,
                xyz.d3 + other.xyz.d3);

        if (Double3.ZERO.equals(result)) {
            throw new IllegalArgumentException("add vector resulting in ZERO vector not allowed");
        }
        return new Vector(result.d1,result.d2, result.d3);
    }

    /*
     * subtract method
     * @param other the vector to subtract
     * @return algebraic subtracted vector
     */
    public Vector subtract(Vector other) {
        Double3 result = new Double3(
                xyz.d1 - other.xyz.d1,
                xyz.d2 - other.xyz.d2,
                xyz.d3 - other.xyz.d3);

        if (Double3.ZERO.equals(result)) {
            throw new IllegalArgumentException("subtract vector resulting in ZERO vector not allowed");
        }
        return new Vector(result.d1,result.d2, result.d3);
    }
    /*
     * @param scalar scaling factot
     * * @return new Vector corresponding to the actual one
     */

    public Vector scale(double scalar) {
        if (scalar==0) {
            throw new IllegalArgumentException("scaling factor == 0");
        }
        Double3 result = new Double3(
                scalar * xyz.d1,
                scalar * xyz.d2,
                scalar * xyz.d3);

        return new Vector(result.d1,result.d2, result.d3);
    }

    /*
     dot product between two vectors (scalar product)
     * @param v the right vector of U.V
     * @return scalre value of dot product
     */
    public double dotProduct(Vector other) {
        double u1 = xyz.d1;
        double u2 = xyz.d2;
        double u3 = xyz.d3;

        double v1 = other.xyz.d1;
        double v2 = other.xyz.d2;
        double v3 = other.xyz.d3;

        return (u1 * v1 + u2 * v2 + u3 * v3);
    }

    /*
     * Cross product
     * @param v second vector
     * @return new Vector resulting from cross product
     */
    public Vector crossProduct(Vector other) {
        double u1 = xyz.d1;
        double u2 = xyz.d2;
        double u3 = xyz.d3;

        double v1 = other.xyz.d1;
        double v2 = other.xyz.d2;
        double v3 = other.xyz.d3;


        Double3 result = new Double3(
                u2 * v3 - u3 * v2,
                u3 * v1 - u1 * v3,
                u1 * v2 - u2 * v1);

        return new Vector(result.d1,result.d2,result.d3);
    }


    /*
     * @return euclidean length squared of the vector
     */
    public double lengthSquared() {
        double u1 = xyz.d1;
        double u2 = xyz.d2;
        double u3 = xyz.d3;

        return u1 * u1 + u2 * u2 + u3 * u3;
    }

    /*
     * @return length using Pythagoras
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /*
     * normalizing the current Vector
     * @return this Vector normalized
     */
    public Vector normalize() {
        Double3 result = new Double3(
                xyz.d1/this.length(),
                xyz.d2/this.length(),
                xyz.d3/this.length());
        return new Vector(result.d1,result.d2,result.d3);
    }
}