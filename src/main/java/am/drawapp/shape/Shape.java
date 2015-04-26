/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package am.drawapp.shape;

import am.drawapp.elements.Coordinate;
import am.drawapp.elements.Cell;
import java.util.Map;

/**
 *
 * @author amendez
 */
public interface Shape {
    
    public Map<Coordinate, Cell> getShapeCoordinates();
}
