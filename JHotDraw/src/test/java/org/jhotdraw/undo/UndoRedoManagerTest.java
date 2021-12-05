/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import java.beans.PropertyChangeListener;
import java.util.Locale;
import javax.swing.Action;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class UndoRedoManagerTest {
    
    public UndoRedoManagerTest() {
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
//     * Test of discardAllEdits method, of class UndoRedoManager.
//     */
    @Test
    public void testDiscardAllEdits() {
        System.out.println("discardAllEdits");

   UndoableEdit anEdit = new AbstractUndoableEdit();
        anEdit.isSignificant();
        UndoRedoManager instance = new UndoRedoManager();
        assertFalse(instance.hasSignificantEdits());
        
        boolean result = instance.addEdit(anEdit);
        assertTrue(instance.hasSignificantEdits());
        //test discardAllEdits
        instance.discardAllEdits();
        assertFalse(instance.hasSignificantEdits());
    }

    /**
     * Test of hasSignificantEdits method, of class UndoRedoManager.
     */
    @Test
    public void testHasSignificantEdits() {
        System.out.println("hasSignificantEdits");
   UndoableEdit anEdit = new AbstractUndoableEdit();
        anEdit.isSignificant();
        UndoRedoManager instance = new UndoRedoManager();
        assertFalse(instance.hasSignificantEdits());
        
        boolean result = instance.addEdit(anEdit);
        assertTrue(instance.hasSignificantEdits());
////tester has signigicant edits, og discardalledits
    }

}
