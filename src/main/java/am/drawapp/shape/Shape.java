package am.drawapp.shape;

import am.drawapp.elements.Coordinate;
import am.drawapp.elements.Cell;
import java.util.Map;

/**
 * Represent a shape.
 * 
 * @author Andrés Mendez Juanias.
 */
public interface Shape {
    
    /**
     * Get the shape coordinates.
     * @return Map of shape coordinates.
     */
    public Map<Coordinate, Cell> getShapeCoordinates();
}
