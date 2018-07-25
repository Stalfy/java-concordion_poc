package shapes.impl;

import static org.junit.Assert.*;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import shapes.Shape;
import shapes.impl.Square;

@RunWith(ConcordionRunner.class)
public class SquareTest {

    public class AreaResult {

        public int area;
        public boolean passed;
        public String message;

        public AreaResult(int area, boolean passed) {
            this.area = area;
            this.passed = passed;
        }

        public AreaResult(int area, boolean passed, String message) {
            this.area = area;
            this.passed = passed;
            this.message = message;
        }
    }

    public AreaResult getArea(int width) {
        try {
            Shape square = new Square(width);

            return new AreaResult(square.getArea(), true);
       } catch(AssertionError e) {
           e.printStackTrace();
           return new AreaResult(-1, false, e.getMessage());
       } finally {
           // Stuff.
       }
    }
}
