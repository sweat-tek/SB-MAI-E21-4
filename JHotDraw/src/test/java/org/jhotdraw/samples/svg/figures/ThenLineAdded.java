/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.LineFigure;
import org.junit.Assert;

/**
 *
 * @author jakob
 */
public class ThenLineAdded extends Stage<ThenLineAdded> {
    
    @ExpectedScenarioState
    LineFigure figure = new LineFigure();
    
    @ExpectedScenarioState
    Point2D.Double point1;
    
    @ExpectedScenarioState
    Point2D.Double point2;
    
    @ProvidedScenarioState
    Point2D.Double endPoint;
    
    @ProvidedScenarioState
    Point2D.Double startPoint;

    public ThenLineAdded a_line_is_added () {
        
        //figure.getBounds();
        System.out.println("Point 1: "+point1+"\n Point 2: "+point2);
        assertStartPoint(point1);
        assertEndPoint(point2);
        return self();
    }
    
    private void assertEndPoint(Point2D.Double endPoint) {
        Assert.assertEquals(endPoint, figure.getEndPoint());
    }
    
    private void assertStartPoint(Point2D.Double startPoint) {
        Assert.assertEquals(startPoint, figure.getStartPoint());
    }
    
    
}
