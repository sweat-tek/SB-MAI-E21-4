package org.jhotdraw.draw;

import org.jhotdraw.draw.Figure;


public interface ArrangeService {

    void sendToBack(Figure figure);
    void sendToFront(Figure figure);


}
