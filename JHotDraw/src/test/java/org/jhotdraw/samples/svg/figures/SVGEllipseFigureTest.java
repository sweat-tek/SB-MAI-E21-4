package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.Handle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SVGEllipseFigureTest {
    
    public SVGEllipseFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of drawFill method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testDrawFill() {
//        System.out.println("drawFill");
//        Graphics2D g = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.drawFill(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawStroke method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testDrawStroke() {
//        System.out.println("drawStroke");
//        Graphics2D g = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.drawStroke(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getX method, of class SVGEllipseFigure.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        SVGEllipseFigure instance = new SVGEllipseFigure(50, 75, 100, 125);
        double expResult = 50;
        double result = instance.getX();
        assertEquals(expResult, result, 0.1);
    }
//
//    /**
//     * Test of getY method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetY() {
//        System.out.println("getY");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        double expResult = 0.0;
//        double result = instance.getY();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getWidth method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetWidth() {
//        System.out.println("getWidth");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        double expResult = 0.0;
//        double result = instance.getWidth();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHeight method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetHeight() {
//        System.out.println("getHeight");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        double expResult = 0.0;
//        double result = instance.getHeight();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBounds method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetBounds() {
//        System.out.println("getBounds");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        Rectangle2D.Double expResult = null;
//        Rectangle2D.Double result = instance.getBounds();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDrawingArea method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetDrawingArea() {
//        System.out.println("getDrawingArea");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        Rectangle2D.Double expResult = null;
//        Rectangle2D.Double result = instance.getDrawingArea();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of contains method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testContains() {
//        System.out.println("contains");
//        Point2D.Double p = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        boolean expResult = false;
//        boolean result = instance.contains(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBounds method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testSetBounds() {
//        System.out.println("setBounds");
//        Point2D.Double anchor = null;
//        Point2D.Double lead = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.setBounds(anchor, lead);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of transform method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testTransform() {
//        System.out.println("transform");
//        AffineTransform tx = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.transform(tx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of restoreTransformTo method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testRestoreTransformTo() {
//        System.out.println("restoreTransformTo");
//        Object geometry = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.restoreTransformTo(geometry);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTransformRestoreData method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testGetTransformRestoreData() {
//        System.out.println("getTransformRestoreData");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        Object expResult = null;
//        Object result = instance.getTransformRestoreData();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createHandles method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testCreateHandles() {
//        System.out.println("createHandles");
//        int detailLevel = 0;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        Collection<Handle> expResult = null;
//        Collection<Handle> result = instance.createHandles(detailLevel);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clone method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testClone() {
//        System.out.println("clone");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        SVGEllipseFigure expResult = null;
//        SVGEllipseFigure result = instance.clone();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEmpty method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testIsEmpty() {
//        System.out.println("isEmpty");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        boolean expResult = false;
//        boolean result = instance.isEmpty();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of invalidate method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testInvalidate() {
//        System.out.println("invalidate");
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.invalidate();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
