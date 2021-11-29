/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import java.awt.Container;
import javax.swing.JComponent;
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
public class JDisclosureToolBarTest {

    public JDisclosureToolBarTest() {
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
     * Test of setDisclosureStateCount method, of class JDisclosureToolBar.
     */
    @Test
    public void testSetDisclosureStateCount() {
        System.out.println("setDisclosureStateCount");
        int newValue = 0;
        JDisclosureToolBar instance = new JDisclosureToolBar();
        instance.setDisclosureStateCount(newValue);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDisclosureState method, of class JDisclosureToolBar.
     */
    @Test
    public void testSetDisclosureState() {
        System.out.println("setDisclosureState");
        int newValue = 1;
        JDisclosureToolBar instance = new JDisclosureToolBar();
        Container parent = instance.getParent();
        System.out.println(parent);
        instance.validate();
        //assertFalse(parent.isValid());
        
        //instance.setDisclosureState(newValue);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDisclosureStateCount method, of class JDisclosureToolBar.
     */
    @Test
    public void testGetDisclosureStateCount() {
        System.out.println("getDisclosureStateCount");
        JDisclosureToolBar instance = new JDisclosureToolBar();
        int expResult = 2;
        int result = instance.getDisclosureStateCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDisclosureState method, of class JDisclosureToolBar.
     */
    @Test
    public void testGetDisclosureState() {
        System.out.println("getDisclosureState");
        JDisclosureToolBar instance = new JDisclosureToolBar();
        int expResult = 1;
        int result = instance.getDisclosureState();
        if (instance.getParent() != null) {
            assertEquals(expResult, result);

        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDisclosedComponent method, of class JDisclosureToolBar.
     */
    @Test
    public void testGetDisclosedComponent() {
        System.out.println("getDisclosedComponent");
        int state = 0;
        JDisclosureToolBar instance = new JDisclosureToolBar();
        JComponent expResult = null;
        JComponent result = instance.getDisclosedComponent(state);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
