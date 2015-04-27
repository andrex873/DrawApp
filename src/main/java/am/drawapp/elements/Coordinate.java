
package am.drawapp.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a cell in the board.
 * @author Andrés Mendez Juanias.
 */
public class Coordinate {
    
    private final int[] neighborsX = {-1, 0, 0, 1};
    private final int[] neighborsY = {0, -1, 1, 0};
    private final int totalNeighbors = neighborsX.length;
    
    private final int pointX;
    
    private final int pointY;

    public Coordinate(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }
    
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
