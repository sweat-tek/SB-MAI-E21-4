/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author jakob
 */
public class LineDrawnTest extends ScenarioTest<GivenLine, WhenLineDrawn, ThenLineAdded> {
    
    @Test
    public void drawLineTest() {
        given().point1(2,4).and().point2(6,10);
        when().line_drawn();
        then().a_line_is_added();
    }
    
}
