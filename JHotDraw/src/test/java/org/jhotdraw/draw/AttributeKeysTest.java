/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Color;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author kjalris
 */
public class AttributeKeysTest {
    
    private static ResourceBundleUtil labels;
    
    public AttributeKeysTest() {
    }
    
    @Test
    public void testForNoNullAttributesTextObject() {
        System.out.println("Testing for Default values in the TEXT, TEXT_COLOR and TEXT_SHADOW_COLOR. These values should not be null and "
                + " test should fail if any null values are present");
        
        // Creating the default values from the source code 
        AttributeKey<String> expResult = new AttributeKey<>("text", String.class, "Text", false, labels);
        
        AttributeKey<Color> expResult2 = new AttributeKey<>("textColor", Color.class, Color.BLACK, false, labels);
        
        AttributeKey<Color> expResult3 = new AttributeKey<>("textShadowColor", Color.class, Color.BLACK, false, labels);
        
        // Test for the objects default values, which may not be null
        assertNotNull(expResult.getDefaultValue());
        assertNotNull(expResult2.getDefaultValue());
        assertNotNull(expResult3.getDefaultValue());

    }
    
    @Test (expected=AssertionError.class)
    public void testForNullTextObject() throws Exception {
        
        // Test for fail, we introduce null values
        System.out.println("Making sure that if any default values are null, it fails");
        
        AttributeKey<String> expResult = new AttributeKey<>(null, null, null, false, null);
        AttributeKey<Color> expResult2 = new AttributeKey<>(null, null, null, false, null);
        AttributeKey<Color> expResult3 = new AttributeKey<>(null, null, null, false, null);
        
        assertNotNull(expResult.getDefaultValue());
        assertNotNull(expResult2.getDefaultValue());
        assertNotNull(expResult3.getDefaultValue());
        
        /* 
        Since the default values are null, we expect it to fail
        hence why i use expected=AssertionError for the test
        */

    }
    
}
