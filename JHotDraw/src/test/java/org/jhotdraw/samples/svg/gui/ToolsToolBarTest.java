/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import java.util.Collection;
import javax.swing.Action;
import javax.swing.JComponent;
import org.jhotdraw.draw.DrawingEditor;
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
public class ToolsToolBarTest {
   
    
    public ToolsToolBarTest() {
        
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
     * Test of createDisclosedComponent method, of class ToolsToolBar.
     */
    @Test
    public void testCreateDisclosedComponent() {
        System.out.println("createDisclosedComponent");
        int state = 0;
        ToolsToolBar instance = new ToolsToolBar();
        JComponent expResult = null;
        JComponent result = instance.createDisclosedComponent(state);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createSelectionActions method, of class ToolsToolBar.
     */
    @Test
    public void testCreateSelectionActions() {
        System.out.println("createSelectionActions");
        DrawingEditor editor = null;
        Collection<Action> expResult = null;
        Collection<Action> result = ToolsToolBar.createSelectionActions(editor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getID method, of class ToolsToolBar.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        ToolsToolBar instance = new ToolsToolBar();
        String expResult = "tools";
        String result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDefaultDisclosureState method, of class ToolsToolBar.
     */
    @Test
    public void testGetDefaultDisclosureState() {
        System.out.println("getDefaultDisclosureState");
        ToolsToolBar instance = new ToolsToolBar();
        int expResult = 1;
        int result = instance.getDefaultDisclosureState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
