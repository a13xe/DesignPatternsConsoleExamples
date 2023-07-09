package creational;

// Shape interface
interface Shape {
    void draw();
}

// Circle class implementing Shape
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Square class implementing Shape
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// ShapeFactory class
class ShapeFactory {
    public static Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }
        return null;
    }
}

// Main program
public class FactoryMethodExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw();

        Shape square = ShapeFactory.createShape("square");
        square.draw();
    }
}
