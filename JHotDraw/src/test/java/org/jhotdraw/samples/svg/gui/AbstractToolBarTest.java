/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import java.beans.PropertyChangeListener;
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
public class AbstractToolBarTest {
    
    public AbstractToolBarTest() {
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
     * Test of getID method, of class AbstractToolBar.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        AbstractToolBar instance = new AbstractToolBar();
        String expResult = "";
        String result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of init method, of class AbstractToolBar.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        AbstractToolBar instance = new AbstractToolBar();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEventHandler method, of class AbstractToolBar.
     */
    @Test
    public void testGetEventHandler() {
        System.out.println("getEventHandler");
        AbstractToolBar instance = new AbstractToolBar();
        PropertyChangeListener expResult = null;
        PropertyChangeListener result = instance.getEventHandler();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEditor method, of class AbstractToolBar.
     */
    @Test
    public void testSetEditor() {
        System.out.println("setEditor");
        DrawingEditor editor = null;
        AbstractToolBar instance = new AbstractToolBar();
        instance.setEditor(editor);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEditor method, of class AbstractToolBar.
     */
    @Test
    public void testGetEditor() {
        System.out.println("getEditor");
        AbstractToolBar instance = new AbstractToolBar();
        DrawingEditor expResult = null;
        DrawingEditor result = instance.getEditor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDisclosedComponent method, of class AbstractToolBar.
     */
    @Test
    public void testGetDisclosedComponent() {
        System.out.println("getDisclosedComponent");
        int state = 0;
        AbstractToolBar instance = new AbstractToolBar();
        JComponent expResult = null;
        JComponent result = instance.getDisclosedComponent(state);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createDisclosedComponent method, of class AbstractToolBar.
     */
    @Test
    public void testCreateDisclosedComponent() {
        System.out.println("createDisclosedComponent");
        int state = 0;
        AbstractToolBar instance = new AbstractToolBar();
        JComponent expResult = null;
        JComponent result = instance.createDisclosedComponent(state);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDefaultDisclosureState method, of class AbstractToolBar.
     */
    @Test
    public void testGetDefaultDisclosureState() {
        System.out.println("getDefaultDisclosureState");
        AbstractToolBar instance = new AbstractToolBar();
        int expResult = 0;
        int result = instance.getDefaultDisclosureState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
