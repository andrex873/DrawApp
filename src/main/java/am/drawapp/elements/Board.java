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

    /**
     * Represent the initialization of the Board.
     */
    private boolean initialized;

    /**
     * The map of the board.
     */
    private Map<Coordinate, Cell> boardMap;

    /**
     * The width of the board.
     */
    private int width;

    /**
     * The height of the board.
     */
    private int height;

    /**
     * Initializes a new Board.
     */
    public Board() {
        initialized = false;
    }

    /**
     * Set the initial values for the board.
     * @param width Width of the board.
     * @param height Height of the board.
     */
    public void init(int width, int height) {
        this.width = width;
        this.height = height;
        boardMap = new HashMap<>();
        this.initialized = true;
    }

    /**
     * Add a new shape in the board.
     * @param shape Shape to add.
     */
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

    /**
     * Print the board.
     */
    public void display() {
        for (int verticalIndex = 0; verticalIndex < height + 2; verticalIndex++) {
            for (int horizontalIndex = 0; horizontalIndex < width + 2; horizontalIndex++) {
                Coordinate coordinate = new Coordinate(horizontalIndex, verticalIndex);
                if (boardMap.keySet().contains(coordinate)) {
                    Cell square = boardMap.get(coordinate);
                    System.out.print(square);
                } else {
                    System.out.print(StaticCell.EMPTY_CHAR);
                }
            }
            System.out.println();
        }
    }

    /**
     * Return the initialized param.
     * @return The initialized param.
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Return the BoardMap of the board.
     * @return The boardMap.
     */
    public Map<Coordinate, Cell> getBoardMap() {
        return boardMap;
    }
    
}