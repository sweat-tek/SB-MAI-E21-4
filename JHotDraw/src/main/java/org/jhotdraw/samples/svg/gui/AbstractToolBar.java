/**
 * @(#)AbstractToolBar.java  2.0  2008-05-24
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
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.beans.*;
import java.util.prefs.*;
import javax.swing.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.gui.*;
import org.jhotdraw.draw.*;

/**
 * AbstractToolBar.
 *
 * @author Werner Randelshofer
 * @version 2.0 2008-05-24 Reworked to create panels lazily.
 * <br>1.0 2008-04-13 Created.
 */
public /*abstract*/ class AbstractToolBar extends JDisclosureToolBar {

    protected DrawingEditor editor;
    private JComponent[] panels;
    protected Preferences prefs;
    protected PropertyChangeListener eventHandler;

    /** Creates new form. */
    @FeatureEntryPoint(JHotDrawFeatures.TOOL_PALETTE)
    public AbstractToolBar() {
        initComponents();
        try {
            prefs = Preferences.userNodeForPackage(getClass());
        } catch (SecurityException e) {
            // prefs is null, because we are not permitted to read preferences
        }
    }

    /** This should be an abstract method, but the NetBeans GUI builder
     * doesn't support abstract beans.
     * @return The ID used to retrieve labels and store user preferences.
     */
    protected String getID() {
        return "";
    }

    /** This should be an abstract method, but the NetBeans GUI builder
     * doesn't support abstract beans.
     */
    protected void init() {
    }

    protected PropertyChangeListener getEventHandler() {
        if (eventHandler == null) {
            eventHandler = new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt) {
                    String name = evt.getPropertyName();
                    if (name == DISCLOSURE_STATE_PROPERTY) {
                        try {
                            prefs.putInt(getID() + ".disclosureState", (Integer) evt.getNewValue());
                        } catch (IllegalStateException e) {
                            // This happens, due to a bug in Apple's implementation
                            // of the Preferences class.
                            System.err.println("Warning AbstractToolBar caught IllegalStateException of Preferences class");
                            e.printStackTrace();
                        }
                    }
                }
            };
        }
        return eventHandler;
    }

    public void setEditor(DrawingEditor editor) {
        if (this.editor != null) {
            this.removePropertyChangeListener(getEventHandler());
        }
        this.editor = editor;
        if (editor != null) {
            init();
            setDisclosureState(Math.max(0, Math.min(getDisclosureStateCount(), prefs.getInt(getID() + ".disclosureState", getDefaultDisclosureState()))));
            this.addPropertyChangeListener(getEventHandler());
        }
    }

    public DrawingEditor getEditor() {
        return editor;
    }

    @Override
    final protected JComponent getDisclosedComponent(int state) {
        if (panels == null) {
            panels = new JPanel[getDisclosureStateCount()];
            for (int i = 0; i < panels.length; i++) {
                panels[i] = new ProxyPanel();
            }
        }
        return panels[state];
    }

    /*abstract*/ protected JComponent createDisclosedComponent(int state) {
        return null;
    }

    protected int getDefaultDisclosureState() {
        return 0;
    }

    private class ProxyPanel extends JPanel {

        private Runnable runner;

        public ProxyPanel() {
            setOpaque(false);
            setBackground(Color.GREEN);
            // The paint method is only called, if the proxy panel is at least
            // one pixel wide and high.
            setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        }

        @Override
        @FeatureEntryPoint(JHotDrawFeatures.TOOL_PALETTE)
        public void paint(Graphics g) {
            super.paint(g);
            final int state = getDisclosureState();
            if (runner == null) {
                runner = new Runnable() {

                    public void run() {
                        try {
                        // long start = System.currentTimeMillis();
                        panels[state] = createDisclosedComponent(state);
                        } catch (Throwable t) {
                            t.printStackTrace();
                            panels[state]=null;
                        }
                        // long end = System.currentTimeMillis();
                        // System.out.println(AbstractToolBar.this.getClass()+" state:"+state+" elapsed:"+(end-start));
                        JComponent parent = (JComponent) getParent();
                        if (parent != null) {
                            GridBagLayout layout = (GridBagLayout) parent.getLayout();
                            GridBagConstraints gbc = layout.getConstraints(ProxyPanel.this);

                            parent.remove(ProxyPanel.this);
                            if (getDisclosureState() == state) {
                            if (panels[state] != null) {
                                parent.add(panels[state], gbc);
                            } else {
                                JPanel empty = new JPanel(new BorderLayout());
                                empty.setOpaque(false);
                                parent.add(empty, gbc);
                            }
                            }
                            parent.revalidate();
                            ((JComponent) parent.getRootPane().getContentPane()).revalidate();

                        }
                    }
                };
                SwingUtilities.invokeLater(runner);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
