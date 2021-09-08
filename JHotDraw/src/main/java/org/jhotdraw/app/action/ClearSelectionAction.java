/*
 * @(#)ClearSelectionAction.java  1.0  2008-05-17
 *
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.beans.*;
import java.util.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.app.JHotDrawFeatures;

/**
 * ClearSelectionAction.
 *
 * @author Werner Randelshofer.
 * @version 1.0 2008-05-17 Created.
 */
public class ClearSelectionAction extends AbstractAction {
    public final static String ID = "edit.clearSelection";
    
    /** Creates a new instance. */
    public ClearSelectionAction() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @FeatureEntryPoint(JHotDrawFeatures.AUTOMATIC_SELECTION)
    public void actionPerformed(ActionEvent evt) {
        Component focusOwner = KeyboardFocusManager.
                getCurrentKeyboardFocusManager().
                getPermanentFocusOwner();
        if (focusOwner != null) {
            if (focusOwner instanceof EditableComponent) {
                ((EditableComponent) focusOwner).clearSelection();
            } else if (focusOwner instanceof JTextComponent) {
               JTextComponent tc = ((JTextComponent) focusOwner);
               tc.select(tc.getSelectionStart(), tc.getSelectionStart());
            } else {
                focusOwner.getToolkit().beep();
            }
        }
    }
}
