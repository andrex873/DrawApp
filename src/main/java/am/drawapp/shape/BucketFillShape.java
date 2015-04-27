package am.drawapp.shape;

import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author amendez
 */
public class BucketFillShape implements Shape {

    private final Map<Coordinate, Cell> shapeCoordinates;

    private final Set<Coordinate> boardSet;

    private final Cell colour;

    public BucketFillShape(Map<Coordinate, Cell> boardMap, Coordinate coordinate, Cell colour) {
        this.shapeCoordinates = new HashMap<>();
        this.boardSet = boardMap.keySet();
        this.colour = colour;
        fillCoordinate(coordinate);
    }

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
