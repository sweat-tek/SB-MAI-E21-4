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
        given().x1().and().y1().and().x2().and().y2();
        when().line_drawn();
        then().a_line_is_added();
    }
    
}
