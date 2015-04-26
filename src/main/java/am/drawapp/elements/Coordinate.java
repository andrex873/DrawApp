
package am.drawapp.elements;

/**
 * Class that represents a cell in the board.
 * @author Andrés Mendez Juanias.
 */
public class Coordinate {
    
    private int xPoint;
    
    private int yPoint;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.xPoint;
        hash = 53 * hash + this.yPoint;
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
        if (this.xPoint != other.xPoint) {
            return false;
        }
        if (this.yPoint != other.yPoint) {
            return false;
        }
        return true;
    }
    
    
}
