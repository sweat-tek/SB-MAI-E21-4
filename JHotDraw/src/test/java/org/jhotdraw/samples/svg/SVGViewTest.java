/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import java.awt.Component;
import java.awt.print.Pageable;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asbjo
 */
public class SVGViewTest {
    
    public SVGViewTest() {
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

    /**
     * Test of init method, of class SVGView.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        SVGView instance = new SVGView();
        instance.init();
    }

    /**
     * Test of createDrawing method, of class SVGView.
     */
    @Test
    public void testCreateDrawing() {
        System.out.println("createDrawing");
        SVGView instance = new SVGView();
        Drawing expResult = null;
        Drawing result = instance.createDrawing();
        assertNotEquals(expResult, result);
    }
}
