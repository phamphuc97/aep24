package edu.berkeley.aep;

public class Rectangle {
    private int length;
    private int width;

    private Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle createRectangle(int length, int width) {
        return new Rectangle(length, width);
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }
}

