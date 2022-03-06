package primitives;
/**
 * Class for representing a ray
 */
public class Ray {
    /**
     * Starting point of the ray
     */
    Point p0;
    /**
     * Vector that determines the ray's direction
     */
    Vector dir;
 /**
     * Constructor that normalizes the given vector and sets the starting point to @param _p0
     *
     * @param p0  point of the ray beginning
     * @param dir direction vector
     */
    public Ray(Point _p0, Vector _dir) {
        p0 = _p0;
        dir = _dir.normalize();
    }

    public Point getP0() {
        return p0;
    }

    public Vector getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ray ray = (Ray) o;

        if (!p0.equals(ray.p0)) return false;
        return dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        int result = p0.hashCode();
        result = 31 * result + dir.hashCode();
        return result;
    }
}
