package shapes.impl;

import shapes.Shape;

import java.lang.Math;

public class Square implements Shape {

    private int width;

    public Square(int width) {
        this.width = Math.abs(width);
    }

    public int getSize() {
        return width;
    }

    public int getArea() {
        return width * width;
    }
}
