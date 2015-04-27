package am.drawapp;

import am.drawapp.elements.Coordinate;
import am.drawapp.shape.LineShape;
import am.drawapp.shape.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test class for LineShape.
 * 
 * @author Andrés Méndez Juanias.
 */
public class LineShapeTest {

    @Test
    public void lineShape() {
        List<Coordinate> shapeResult = new ArrayList<>();
        shapeResult.add(new Coordinate(1, 2));
        shapeResult.add(new Coordinate(2, 2));
        shapeResult.add(new Coordinate(3, 2));
        shapeResult.add(new Coordinate(4, 2));
        shapeResult.add(new Coordinate(5, 2));
        shapeResult.add(new Coordinate(6, 2));

        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(6, 2);
        Shape line = new LineShape(c1, c2);
        Set<Coordinate> set = line.getShapeCoordinates().keySet();
        for (Coordinate cResult : shapeResult) {
            assertTrue(set.contains(cResult));
        }
    }
    
    @Test
    public void multiLineShape() {
        List<Coordinate> lineResult = new ArrayList<>();
        lineResult.add(new Coordinate(1, 2));
        lineResult.add(new Coordinate(2, 2));
        lineResult.add(new Coordinate(3, 2));
        lineResult.add(new Coordinate(4, 2));
        lineResult.add(new Coordinate(5, 2));
        lineResult.add(new Coordinate(6, 2));
        lineResult.add(new Coordinate(6, 3));
        lineResult.add(new Coordinate(6, 4));
        
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(6, 4);
        Shape shape = new LineShape(c1, c2);
        Set<Coordinate> set = shape.getShapeCoordinates().keySet();
        for (Coordinate cResult : lineResult) {
            assertTrue(set.contains(cResult));
        }
    }

}
