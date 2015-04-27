/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.drawapp;

import am.drawapp.elements.Coordinate;
import am.drawapp.shape.LineShape;
import am.drawapp.shape.RectangleShape;
import am.drawapp.shape.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test class for RectangleShape.
 * 
 * @author Andrés Méndez Juanias.
 */
public class RectangleShapeTests {

    @Test
    public void rectangleTest() {
        List<Coordinate> shapeResult = new ArrayList<>();
        shapeResult.add(new Coordinate(16, 1));
        shapeResult.add(new Coordinate(17, 1));
        shapeResult.add(new Coordinate(18, 1));
        shapeResult.add(new Coordinate(19, 1));
        shapeResult.add(new Coordinate(20, 1));
        shapeResult.add(new Coordinate(16, 2));
        shapeResult.add(new Coordinate(20, 2));
        shapeResult.add(new Coordinate(16, 3));
        shapeResult.add(new Coordinate(17, 3));
        shapeResult.add(new Coordinate(18, 3));
        shapeResult.add(new Coordinate(19, 3));
        shapeResult.add(new Coordinate(20, 3));
        
        Coordinate c1 = new Coordinate(16, 1);
        Coordinate c2 = new Coordinate(20, 3);
        Shape shape = new RectangleShape(c1, c2);
        Set<Coordinate> set = shape.getShapeCoordinates().keySet();
        for (Coordinate cResult : shapeResult) {
            assertTrue(set.contains(cResult));
        }
        
    }
}
