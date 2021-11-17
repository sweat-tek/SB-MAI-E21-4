/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.TextScenarioTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author kjalris
 */
public class GivenCanvas extends Stage< GivenCanvas> {
    @ProvidedScenarioState
    protected AttributeKey<String> text;
    private static ResourceBundleUtil labels;

    public GivenCanvas an_empty_sheet_or_sheet_with_figures() {
        text = new AttributeKey<>("text", String.class, "Text", false, labels);
        return self();
    }
}
