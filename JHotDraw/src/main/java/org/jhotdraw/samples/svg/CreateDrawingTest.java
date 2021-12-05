package org.jhotdraw.samples.svg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.QuadTreeDrawing;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author asbjo
 */
public class CreateDrawingTest {
    @Test
    public void testCreateDrawing() throws Exception {
        // Assert that method returns Drawing object
        SVGView view = new SVGView();
        Drawing drawing = new QuadTreeDrawing();
        assertEquals(drawing, view.createDrawing());
    }           
}
