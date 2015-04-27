package am.drawapp.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a coordinate in the board.
 * 
 * @author Andrés Mendez Juanias.
 */
public class Coordinate {
    
    /**
     * The neighbors array in X point.
     */
    private final int[] neighborsX = {-1, 0, 0, 1};
    
    /**
     * The neighbors array in Y point.
     */
    private final int[] neighborsY = {0, -1, 1, 0};
    
    /**
     * The length of the neighbors.
     */
    private final int totalNeighbors = neighborsX.length;
    
    /**
     * The point X of the coordinate.
     */
    private final int pointX;
    
    /**
     * The point Y of the coordinate.
     */
    private final int pointY;

    /**
     * Initializes a new object of type Coordinate.
     * @param pointX The point X of the coordinate.
     * @param pointY The point Y of the coordinate.
     */
    public Coordinate(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /**
     * Retrieve the point X.
     * @return The pointX of the class.
     */
    public int getPointX() {
        return pointX;
    }

    /**
     * Retrieve the point Y.
     * @return The pointY of the class.
     */
    public int getPointY() {
        return pointY;
    }
    
    /**
     * Retrieve the neighbors of the coordinate.
     * @return The neighbors.
     */
    public List<Coordinate> neighbors(){
        List<Coordinate> neighborsList = new ArrayList<>();
        for (int index = 0; index < totalNeighbors; index++) {
            Coordinate coordinate = new Coordinate(pointX + neighborsX[index], pointY+ neighborsY[index]);
            neighborsList.add(coordinate);
        }
        return neighborsList;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.pointX;
        hash = 53 * hash + this.pointY;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (this.pointX != other.pointX) {
            return false;
        }
        if (this.pointY != other.pointY) {
            return false;
        }
        return true;
    }
    
}