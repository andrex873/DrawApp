/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.drawapp.elements;

/**
 *
 * @author amendez
 */
public class CustomCell implements Cell {

    private final String character;

    public CustomCell(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }

}
