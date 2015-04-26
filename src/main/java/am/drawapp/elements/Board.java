
package am.drawapp.elements;

import java.util.Map;

/**
 * Class that represente the board in de draw application.
 * @author Andrés Mendez Juanias.
 */
public class Board {
    
    private boolean initialized;
    
    private Map<Coordinate, String> ana;
    
    private int width;
    
    private int height;

    public Board() {
        initialized = false;
    }
    
    public void init(int width, int height) {
        this.width = width;
        this.height = height;
        this.initialized = true;
    }
    
    
}
