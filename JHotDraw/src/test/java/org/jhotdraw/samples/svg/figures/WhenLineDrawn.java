/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Map;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;

/**
 *
 * @author jakob
 */
public class WhenLineDrawn extends Stage<WhenLineDrawn> {
    
    @ExpectedScenarioState
    int x1;
    
    @ExpectedScenarioState
    int y1;
    
    @ExpectedScenarioState
    int x2;
    
    @ExpectedScenarioState
    int y2;
    
    @ProvidedScenarioState
    LineFigure figure;
    
//    @ProvidedScenarioState
//    Graphics2D g = new Graphics2D();
    
    @ProvidedScenarioState
    Point2D.Double point1 = new Point2D.Double(x1, y1);
    
    @ProvidedScenarioState
    Point2D.Double point2 = new Point2D.Double(x2, y2);
    
    public WhenLineDrawn line_drawn() {
        figure.setStartPoint(point1);
        figure.setEndPoint(point2);
        //figure = new SVGPathFigure();
        figure.setBounds(point1, point2);
        
        //g.drawLine(x1, y1, x2, y2);
        //figure.draw(g);
        //figure.setStartPoint(point1);
        //figure.setEndPoint(point2);
        return self();
    }
    
}
