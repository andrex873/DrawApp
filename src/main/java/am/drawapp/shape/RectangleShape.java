package am.drawapp.shape;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import am.drawapp.elements.StaticCell;
import am.drawapp.exception.ShapeException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amendez
 */
public class RectangleShape implements Shape {

    private Map<Coordinate, Cell> shapeCoordinates;

    public RectangleShape(Coordinate startPoint, Coordinate endPoint) {
        if (isInvalid(startPoint, endPoint)) {
            throw new ShapeException(MessageConstants.ERROR_SHAPE_RECTANGLE_CORDINATES);
        }
        shapeCoordinates = new HashMap<>();
        // Fill the horizontal lines
        for (int index = startPoint.getPointX(); index <= endPoint.getPointX(); index++) {
            Coordinate topCoordinate = new Coordinate(index, startPoint.getPointY());
            Coordinate bottomCoordinate = new Coordinate(index, endPoint.getPointY());
            shapeCoordinates.put(topCoordinate, StaticCell.SHAPE_CHAR);
            shapeCoordinates.put(bottomCoordinate, StaticCell.SHAPE_CHAR);
        }
        // Fill the vertical lines
        for (int index = startPoint.getPointY(); index <= endPoint.getPointY(); index++) {
            Coordinate leftCoordinate = new Coordinate(startPoint.getPointX(), index);
            Coordinate rightCoordinate = new Coordinate(endPoint.getPointX(), index);
            shapeCoordinates.put(leftCoordinate, StaticCell.SHAPE_CHAR);
            shapeCoordinates.put(rightCoordinate, StaticCell.SHAPE_CHAR);
        }
    }

    private boolean isInvalid(Coordinate startPoint, Coordinate endPoint) {
        return endPoint.getPointX() <= startPoint.getPointX() || endPoint.getPointY() <= startPoint.getPointY();
    }

    @Override
    public Map<Coordinate, Cell> getShapeCoordinates() {
        return shapeCoordinates;
    }

}
