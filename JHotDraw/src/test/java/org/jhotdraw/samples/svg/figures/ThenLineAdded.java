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
import org.junit.Assert;

/**
 *
 * @author jakob
 */
public class ThenLineAdded extends Stage<ThenLineAdded> {
    
    @ExpectedScenarioState
    SVGPathFigure figure;
    
    @ExpectedScenarioState
    Point2D.Double point1;
    
    @ExpectedScenarioState
    Point2D.Double point2;
    
    @ProvidedScenarioState
    Point2D.Double endPoint = figure.getEndPoint();
    
    @ProvidedScenarioState
    Point2D.Double startPoint = figure.getStartPoint();

    public ThenLineAdded a_line_is_added () {
        //figure.getBounds();
        assertStartPoint(point1);
        assertEndPoint(point2);
        return this;
    }
    
    private void assertEndPoint(Point2D.Double endPoint) {
        Assert.assertEquals(endPoint, this.endPoint);
    }
    
    private void assertStartPoint(Point2D.Double startPoint) {
        Assert.assertEquals(startPoint, this.startPoint);
    }
    
    
}
