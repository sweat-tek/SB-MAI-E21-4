package org.jhotdraw.draw.arrange;

import org.jhotdraw.draw.Figure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;


public interface ArrangeService {

    void sendToBack(Figure figure);
    void sendToFront(Figure figure);


}
