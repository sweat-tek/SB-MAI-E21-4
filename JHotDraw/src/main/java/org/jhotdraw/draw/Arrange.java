package org.jhotdraw.draw;


import org.jhotdraw.draw.Figure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public abstract class Arrange {

    public static boolean ToBack(Figure figure, ArrayList<Figure> figures){
        if (figures.remove(figure)) {
            figures.add(0, figure);
            return true;
        }
        return false;

    }

    public static boolean ToFront(Figure figure, ArrayList<Figure> figures){
        if (figures.remove(figure)) {
            figures.add(figure);
            return true;
        }
        return false;

    }

}
