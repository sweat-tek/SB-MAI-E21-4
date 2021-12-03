/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;

/**
 *
 * @author jakob
 */
public class GivenLine extends Stage<GivenLine> {
    
    @ProvidedScenarioState
    int x1;
    
    @ProvidedScenarioState
    int x2;
    
    @ProvidedScenarioState
    int y1;
    
    @ProvidedScenarioState
    int y2;
    
    public GivenLine x1() {
        x1 = 2;
        return this;
    }
    
    public GivenLine x2() {
        x2 = 6;
        return this;
    }
    
    public GivenLine y1() {
        y1 = 4;
        return this;
    }
    
    public GivenLine y2() {
        y2 = 10;
        return this;
    }
    
//    public GivenLine a_line_parameters() {
//        LineFigure figure = new LineFigure();
//        figure.setStartPoint(new Point2D.Double(x1, y1));
//        figure.setEndPoint(new Point2D.Double(x2, y2));
//        System.out.println(figure);
//        return this;
//    }
    
}
