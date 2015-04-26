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
public enum StaticCell implements Cell{
    
    HORIZONTAL_CHAR{
        @Override
        public String toString() {
            return "-";
        }
    },
    VERTICAL_CHAR{
        @Override
        public String toString() {
            return "|";
        }
    },
    SHAPE_CHAR{
        @Override
        public String toString() {
            return "x";
        }
    };
    
}
