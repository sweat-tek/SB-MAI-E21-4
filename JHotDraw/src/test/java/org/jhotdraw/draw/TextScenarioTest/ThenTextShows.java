/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.TextScenarioTest;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.util.ResourceBundleUtil;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author kjalris
 */
public class ThenTextShows {
    @ExpectedScenarioState
    protected AttributeKey<String> text = new AttributeKey<>("text", String.class, "Text", false, labels);
    private static ResourceBundleUtil labels;
    
     public ThenTextShows the_text_is_shown_on_the_canvas_without_any_null_objects() {
        assertNotNull(text.getDefaultValue());;
        return this;
    }
    
}
