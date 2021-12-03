/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jakob
 */
public class SVGPathFigureTest {
    
    
    LineFigure figure;
    Point2D.Double anchor;
    Point2D.Double lead;
    double x = 3;
    double y = 8;
    double width = 5;
    double height = 4;
    
    public SVGPathFigureTest() {
        figure = new LineFigure();
        anchor = new Point2D.Double(x, width);
        lead = new Point2D.Double(y, height);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        figure.setBounds(anchor, lead);
        figure.setStartPoint(anchor);
        figure.setEndPoint(lead);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAnchor() {
        Point2D.Double expAnchor = new Point2D.Double(3, 5);
        
        Point2D.Double resultAnchor = new Point2D.Double(figure.getBounds().x, figure.getBounds().width);
        assertEquals(expAnchor, resultAnchor);
        System.out.println("bounds: "+figure.getBounds());
        //assertEquals(expLead., result);
        
    }
    
    @Test
    public void testStartPoint() {
        System.out.println("Test Start Point");
        Point2D.Double expResult = new Point2D.Double(3, 5);
        Point2D.Double result = figure.getStartPoint();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEndPoint() {
        System.out.println("Test End Point");
        Point2D.Double expResult = new Point2D.Double(8, 4);
        Point2D.Double result = figure.getEndPoint();
        
        assertEquals(expResult, result);
    }

    

    
}
