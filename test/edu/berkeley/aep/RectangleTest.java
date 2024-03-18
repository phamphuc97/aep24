package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void rectangleWithLength5AndWidth4ShouldHaveArea20() {
        var rectangle = Rectangle.createRectangle(5, 4);
        int area = rectangle.area();
        assertEquals(20, area);
    }

    @Test
    public void rectangleWithLength6AndArea4ShouldHavePerimeter20() {
        var rectangle = Rectangle.createRectangle(6, 4);
        int perimeter = rectangle.perimeter();
        assertEquals(20, perimeter);
    }

    @Test
    public void squareWithSide5ShouldHaveArea25() {
        var square = Rectangle.createSquare(5);
        assertEquals(25, square.area());
    }

    @Test
    public void squareWithSide5ShouldHavePerimeterOf20() {
        var square = Rectangle.createSquare(5);
        assertEquals(20, square.perimeter());
    }
}
