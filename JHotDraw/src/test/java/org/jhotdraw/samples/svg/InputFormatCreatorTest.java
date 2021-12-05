/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import java.util.LinkedList;
import org.jhotdraw.draw.InputFormat;
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
public class InputFormatCreatorTest {
    
    public InputFormatCreatorTest() {
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
     * Test of loadInputFormats method, of class InputFormatCreator.
     */
    @Test
    public void testLoadObject() {
        // Assert that the return is not null
        LinkedList<InputFormat> expResult = null;
        LinkedList<InputFormat> result = InputFormatCreator.loadInputFormats();
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void testNonEmptyList() {
        // Assert that the returned list is not empty
        assertFalse(InputFormatCreator.loadInputFormats().isEmpty());
    }
    
    @Test
    public void testContainsInputFormat() {
        // Assert that the returned list contains InputFormat type
        assertTrue(InputFormatCreator.loadInputFormats().stream()
                .anyMatch(e -> e instanceof InputFormat));
    }
}
