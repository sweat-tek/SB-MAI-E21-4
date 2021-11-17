/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import org.jhotdraw.draw.TextScenarioTest.GivenCanvas;
import org.jhotdraw.draw.TextScenarioTest.ThenTextShows;
import org.jhotdraw.draw.TextScenarioTest.WhenText;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kjalris
 */
public class AttributeKeysTest extends ScenarioTest<GivenCanvas, WhenText, ThenTextShows> {
    
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
    // Acceptance test
    
    // Given i have a blank canvas (or with figures)
    // When the user writes down something in the textbox
    // Then the text is shown
    
    @Test
     public void user_can_add_text_to_figures() {
        given().an_empty_sheet_or_sheet_with_figures();
        when().the_user_adds_text_to_the_canvas();
        then().the_text_is_shown_on_the_canvas_without_any_null_objects();
    }
    
}
