package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

/**
 * * common interface for all graphic objects
 * * that intersect with a ray {@link primitives.Ray}
 */
public interface Intersectable {
    /**
     * find all intersection points {@link Point} that intersect with
     * a specific Ray {@Link Ray}
     * @param ray pointing towards the graphic object
     * @return immutable List of intersection points {@Link Point}
     */
    List<Point> findIntersections(Ray ray);
}
