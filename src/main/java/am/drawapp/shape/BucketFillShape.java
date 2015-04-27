package am.drawapp.shape;

import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class that represent a bucket fill shape.
 * 
 * @author Andrés Mendez Juanias.
 */
public class BucketFillShape implements Shape {

    /**
     * The shape coordinates.
     */
    private final Map<Coordinate, Cell> shapeCoordinates;

    /**
     * The board set.
     */
    private final Set<Coordinate> boardSet;

    /**
     * The custom colour.
     */
    private final Cell colour;

    /**
     * Initializes a new object of type BucketFillShape.
     * @param boardMap Map from the board.
     * @param coordinate Coordinate for the shape.
     * @param colour Colour for the shape.
     */
    public BucketFillShape(Map<Coordinate, Cell> boardMap, Coordinate coordinate, Cell colour) {
        this.shapeCoordinates = new HashMap<>();
        this.boardSet = boardMap.keySet();
        this.colour = colour;
        fillCoordinate(coordinate);
    }

    /**
     * Fill the coordinates of the chape.
     * @param coordinate Coordinate to fill.
     */
    private void fillCoordinate(Coordinate coordinate) {
        if (boardSet.contains(coordinate)) {
            return;
        }
        shapeCoordinates.put(coordinate, colour);
        for (Coordinate neighborCoordinate : coordinate.neighbors()) {
            if (!shapeCoordinates.keySet().contains(neighborCoordinate)) {
                fillCoordinate(neighborCoordinate);
            }
        }
    }

    @Override
    public Map<Coordinate, Cell> getShapeCoordinates() {
        return shapeCoordinates;
    }

}