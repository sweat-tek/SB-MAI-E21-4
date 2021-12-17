/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.LineFigure;

/**
 *
 * @author jakob
 */
public class WhenLineDrawn extends Stage<WhenLineDrawn> {

    
    @ExpectedScenarioState
    @ProvidedScenarioState
    Point2D.Double point1;
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    Point2D.Double point2;
    
    @ProvidedScenarioState
    LineFigure figure;
    
    @BeforeStage
    private void init() {
        figure = new LineFigure();
    }
    

    public WhenLineDrawn line_drawn() {
        addPoints();
        return self();
    }
    
    public void addPoints() {
        figure.setStartPoint(point1);
        figure.setEndPoint(point2);
        figure.setBounds(point1, point2);
    }
    
}
