package primitives;

import java.util.Objects;

public class Point {
    final Double3 xyz;

    public Point(double x, double y, double z) {
        xyz = new Double3(x,y,z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xyz.equals(point.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xyz);
    }

    @Override
    public String toString() {
        return "Point{" +
                "xyz=" + xyz +
                '}';
    }

    public Point add(Vector vector) {
        return new Point(xyz.d1+ vector.xyz.d1,xyz.d2+ vector.xyz.d2,xyz.d3+ vector.xyz.d3);
    }
    public Vector subtract(Point point) {
        Double3 newXyz = xyz.subtract(point.xyz);
        if(Double3.ZERO.equals(newXyz)) {
            throw  new IllegalArgumentException("subtract resulting ZERO vector - not allowed");
        }
        return new Vector(newXyz.d1, newXyz.d2, newXyz.d3);
    }

    public double distanceSquared(Point other) {
        final double x1 = xyz.d1;
        final double y1 = xyz.d2;
        final double z1 = xyz.d3;

        final double x2 = other.xyz.d1;
        final double y2 = other.xyz.d2;
        final double z2 = other.xyz.d3;

        return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1));
    }

    public double distance(Point other) {
        return Math.sqrt(distanceSquared(other));
    }
}