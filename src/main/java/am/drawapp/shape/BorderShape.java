package am.drawapp.shape;

import am.drawapp.elements.Coordinate;
import am.drawapp.elements.Cell;
import am.drawapp.elements.StaticCell;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that represent a Board shape.
 *
 * @author Andrés Mendez Juanias.
 */
public class BorderShape implements Shape {

    /**
     * The shape map for the border.
     */
    private final Map<Coordinate, Cell> shapeMap;

    /**
     * Initializes a new object of type BorderShape.
     * @param width Width of the border shape.
     * @param height Height of the border shape.
     */
    public BorderShape(int width, int height) {
        shapeMap = new HashMap<>();
        // Fill the vertical lines
        for (int index = 0; index < height + 2; index++) {
            Coordinate leftCoordinate = new Coordinate(0, index);
            Coordinate rightCoordinate = new Coordinate(width + 1, index);
            shapeMap.put(leftCoordinate, StaticCell.VERTICAL_CHAR);
            shapeMap.put(rightCoordinate, StaticCell.VERTICAL_CHAR);
        }
        // Fill the horizontal lines
        for (int index = 0; index < width + 2; index++) {
            Coordinate topCoordinate = new Coordinate(index, 0);
            Coordinate bottomCoordinate = new Coordinate(index, height + 1);
            shapeMap.put(topCoordinate, StaticCell.HORIZONTAL_CHAR);
            shapeMap.put(bottomCoordinate, StaticCell.HORIZONTAL_CHAR);
        }
    }

    @Override
    public Map<Coordinate, Cell> getShapeCoordinates() {
        return shapeMap;
    }

}