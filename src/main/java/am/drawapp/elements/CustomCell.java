package am.drawapp.elements;

/**
 * Class that represents a custom cell in the board.
 * 
 * @author Andrés Mendez Juanias.
 */
public class CustomCell implements Cell {

    /**
     * Custom char in the cell.
     */
    private final String character;

    /**
     * Initializes a new object of type CustomCell.
     * @param character Custom character.
     */
    public CustomCell(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }

}