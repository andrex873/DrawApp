package am.drawapp.shape;

import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import am.drawapp.elements.StaticCell;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amendez
 */
public class LineShape implements Shape {

    private final Map<Coordinate, Cell> shapeCoordinates;

    public LineShape(Coordinate startPoint, Coordinate endPoint) {
        shapeCoordinates = new HashMap<>();
        int minX = getMinX(startPoint, endPoint);
        int maxX = getMaxX(startPoint, endPoint);
        int minY = getMinY(startPoint, endPoint);
        int maxY = getMaxY(startPoint, endPoint);
        // Fill the horizontal line
        for (int index = minX; index <= maxX; index++) {
            Coordinate coordinate = new Coordinate(index, minY);
            shapeCoordinates.put(coordinate, StaticCell.SHAPE_CHAR);
        }
        int staticX = getHorizontalX(startPoint, endPoint);
        // Fill the vertical line
        for (int index = minY; index <= maxY; index++) {
            Coordinate coordinate = new Coordinate(staticX, index);
            shapeCoordinates.put(coordinate, StaticCell.SHAPE_CHAR);
        }
    }

    @Override
    public Map<Coordinate, Cell> getShapeCoordinates() {
        return shapeCoordinates;
    }

    
    private int getMinX(Coordinate startPoint, Coordinate endPoint) {
        return startPoint.getPointX() < endPoint.getPointX() ? startPoint.getPointX() : endPoint.getPointX();
    }

    private int getMaxX(Coordinate startPoint, Coordinate endPoint) {
        return startPoint.getPointX() > endPoint.getPointX() ? startPoint.getPointX() : endPoint.getPointX();
    }

    private int getMinY(Coordinate startPoint, Coordinate endPoint) {
        return startPoint.getPointY() < endPoint.getPointY() ? startPoint.getPointY() : endPoint.getPointY();
    }

    private int getMaxY(Coordinate startPoint, Coordinate endPoint) {
        return startPoint.getPointY() > endPoint.getPointY() ? startPoint.getPointY() : endPoint.getPointY();
    }

    private int getHorizontalX(Coordinate start, Coordinate end) {
        if(shapeCoordinates.keySet().contains(start)){
            return end.getPointX();
        } else {
            return start.getPointX();
        }
        
    }

}
