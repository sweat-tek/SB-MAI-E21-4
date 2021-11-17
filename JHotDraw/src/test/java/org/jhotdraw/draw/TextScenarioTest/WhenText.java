/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.TextScenarioTest;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author kjalris
 */
public class WhenText {
    @ExpectedScenarioState
    protected AttributeKey text;
    
    private static ResourceBundleUtil labels;

    public WhenText the_user_adds_text_to_the_canvas() {
        addText();
        return this;
    }
    
    private void addText() {
        text = new AttributeKey<>("text", String.class, "Text", false, labels);
    }

}
