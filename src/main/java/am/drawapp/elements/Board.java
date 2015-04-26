package am.drawapp.elements;

import am.drawapp.shape.Shape;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class that represente the board in de draw application.
 *
 * @author Andrés Mendez Juanias.
 */
public class Board {

    private boolean initialized;

    private Map<Coordinate, Cell> boardMap;

    private int width;

    private int height;

    public Board() {
        initialized = false;
    }

    public void init(int width, int height) {
        this.width = width;
        this.height = height;
        boardMap = new HashMap<>();
        this.initialized = true;
    }

    public void addShape(Shape shape) {
        Map<Coordinate, Cell> shapeCoordinates = shape.getShapeCoordinates();
        if (shapeCoordinates.isEmpty()) {
            return;
        }
        Iterator<Coordinate> iterator = shapeCoordinates.keySet().iterator();
        while (iterator.hasNext()) {
            Coordinate coordinate = iterator.next();
            if (!boardMap.keySet().contains(coordinate)) {
                boardMap.put(coordinate, shapeCoordinates.get(coordinate));
            }
        }

    }

    public void display() {
        for (int verticalIndex = 0; verticalIndex < height + 2; verticalIndex++) {
            for (int horizontalIndex = 0; horizontalIndex < width + 2; horizontalIndex++) {
                Coordinate coordinate = new Coordinate(horizontalIndex, verticalIndex);
                if (boardMap.keySet().contains(coordinate)) {
                    Cell square = boardMap.get(coordinate);
                    System.out.print(square);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
