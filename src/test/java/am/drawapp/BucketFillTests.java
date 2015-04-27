package am.drawapp;

import am.drawapp.elements.Board;
import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import am.drawapp.elements.CustomCell;
import am.drawapp.shape.BorderShape;
import am.drawapp.shape.BucketFillShape;
import am.drawapp.shape.LineShape;
import am.drawapp.shape.RectangleShape;
import am.drawapp.shape.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test class for BucketFill.
 * 
 * @author Andrés Méndez Juanias.
 */
public class BucketFillTests {
    
    @Test
    public void BucketFillTests(){
        List<Coordinate> shapeResult = getShapeResult();
        Coordinate c1 = new Coordinate(10, 3);
        Cell colour = new CustomCell("o");
        Shape shape = new BucketFillShape(createBoardMap(), c1, colour);
        Set<Coordinate> set = shape.getShapeCoordinates().keySet();
        for (Coordinate cResult : shapeResult) {
            assertTrue(set.contains(cResult));
        }
    }

    private Map<Coordinate, Cell> createBoardMap() {
        int width = 20;
        int height = 4;
        Board board = new Board();
        board.init(width, height);
        board.addShape(new BorderShape(width, height));
        board.addShape(new LineShape(new Coordinate(1, 2), new Coordinate(6, 2)));
        board.addShape(new LineShape(new Coordinate(1, 2), new Coordinate(6, 4)));
        board.addShape(new RectangleShape(new Coordinate(16, 1), new Coordinate(20, 3)));
        return board.getBoardMap();
    }

    private List<Coordinate> getShapeResult() {
        List<Coordinate> result = new ArrayList<>();
        result.add(new Coordinate(1, 1));
        result.add(new Coordinate(2, 1));
        result.add(new Coordinate(3, 1));
        result.add(new Coordinate(4, 1));
        result.add(new Coordinate(5, 1));
        result.add(new Coordinate(6, 1));
        result.add(new Coordinate(7, 1));
        result.add(new Coordinate(8, 1));
        result.add(new Coordinate(9, 1));
        result.add(new Coordinate(10, 1));
        result.add(new Coordinate(11, 1));
        result.add(new Coordinate(12, 1));
        result.add(new Coordinate(13, 1));
        result.add(new Coordinate(14, 1));
        result.add(new Coordinate(15, 1));
        
        result.add(new Coordinate(7, 2));
        result.add(new Coordinate(8, 2));
        result.add(new Coordinate(9, 2));
        result.add(new Coordinate(10, 2));
        result.add(new Coordinate(11, 2));
        result.add(new Coordinate(12, 2));
        result.add(new Coordinate(13, 2));
        result.add(new Coordinate(14, 2));
        result.add(new Coordinate(15, 2));
        
        result.add(new Coordinate(7, 3));
        result.add(new Coordinate(8, 3));
        result.add(new Coordinate(9, 3));
        result.add(new Coordinate(10, 3));
        result.add(new Coordinate(11, 3));
        result.add(new Coordinate(12, 3));
        result.add(new Coordinate(13, 3));
        result.add(new Coordinate(14, 3));
        result.add(new Coordinate(15, 3));
        
        result.add(new Coordinate(7, 4));
        result.add(new Coordinate(8, 4));
        result.add(new Coordinate(9, 4));
        result.add(new Coordinate(10, 4));
        result.add(new Coordinate(11, 4));
        result.add(new Coordinate(12, 4));
        result.add(new Coordinate(13, 4));
        result.add(new Coordinate(14, 4));
        result.add(new Coordinate(15, 4));
        result.add(new Coordinate(16, 4));
        result.add(new Coordinate(17, 4));
        result.add(new Coordinate(18, 4));
        result.add(new Coordinate(19, 4));
        result.add(new Coordinate(20, 4));
        return result;
    }
    
}
