package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
Class PointTest{
  @Test
    void testAdd() {
        Point p1 = new Point(1, 2, 3);
        assertEquals(p1.add(new Vector(-1, -2, -3)),Point.ZERO,"ERROR: Point + Vector does not work correctly");
    }
  @Test
    void testSubtract() {
        Point p1 = new Point(1, 2, 3);
        assertEquals(new Vector(1, 1, 1),new Point(2, 3, 4).subtract(p1),"ERROR: Point - Point does not work correctly");
    }
  
  
  
  
}
