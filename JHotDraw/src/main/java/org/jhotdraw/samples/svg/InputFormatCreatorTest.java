/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import java.util.LinkedList;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.InputFormat;
import org.jhotdraw.draw.QuadTreeDrawing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author asbjo
 */
public class InputFormatCreatorTest {
    @Test
    public void testReturnsList() {
        // Assert that the method contains LinkedList<InputFormat>
        LinkedList<InputFormat> inputFormats = new LinkedList<InputFormat>();
        assertEquals(inputFormats, InputFormatCreator.loadInputFormats());
    }
    
    @Test
    public void testNonEmptyList() {
        // Assert that the returned list is not empty
        assertFalse(InputFormatCreator.loadInputFormats().isEmpty());
    }
    
    @Test
    public void testContainsInputFormat() {
        // Assert that the LinkedList contains InputFormat type
        assertTrue(InputFormatCreator.loadInputFormats().stream()
                .anyMatch(e -> e instanceof InputFormat));
    }
}
