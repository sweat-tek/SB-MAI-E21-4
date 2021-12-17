/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;

/**
 *
 * @author jakob
 */
public class GivenLine extends Stage<GivenLine> {
    
    
    @ProvidedScenarioState
    Point2D.Double point1, point2;
    
    @BeforeStage
    private void init() {
        point1 = new Point2D.Double();
        point2 = new Point2D.Double();
    }
    
    
    public GivenLine point1(int x1, int y1) {
        point1.setLocation(x1, y1);
        return self();
    }
    
    public GivenLine point2(int x2, int y2) {
        point2.setLocation(x2, y2);
        return self();
    }

    
}
