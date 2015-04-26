
package am.drawapp.elements;

/**
 * Class that represents a cell in the board.
 * @author Andrés Mendez Juanias.
 */
public class Coordinate {
    
    private int pointX;
    
    private int pointY;

    public Coordinate(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
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
