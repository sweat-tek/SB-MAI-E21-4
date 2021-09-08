/*
 * @(#)SVGApplicationModel.java  2.0  2009-04-10
 *
 * Copyright (c) 1996-2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.DefaultApplicationModel;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.*;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.GridConstrainer;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.samples.svg.action.CombineAction;
import org.jhotdraw.samples.svg.action.SplitAction;
import org.jhotdraw.samples.svg.action.ViewSourceAction;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * SVGApplicationModel.
 *
 * @author Werner Randelshofer.
 * @version 2.0 2009-04-10 Moved all drawing related toolbars into SVGDrawingPanel.
 * <br>1.0 June 10, 2006 Created.
 */
public class SVGApplicationModel extends DefaultApplicationModel {

    private final static double[] scaleFactors = {5, 4, 3, 2, 1.5, 1.25, 1, 0.75, 0.5, 0.25, 0.10};
    private GridConstrainer gridConstrainer;
    /**
     * This editor is shared by all views.
     */
    private DefaultDrawingEditor sharedEditor;

    /** Creates a new instance. */
    @FeatureEntryPoint(JHotDrawFeatures.APPLICATION_STARTUP)
    public SVGApplicationModel() {
    }

    public DefaultDrawingEditor getSharedEditor() {
        if (sharedEditor == null) {
            sharedEditor = new DefaultDrawingEditor();
        }
        return sharedEditor;
    }

    @Override
    public void initView(Application a, View p) {
        SVGView v = (SVGView) p;
        if (a.isSharingToolsAmongViews()) {
            v.setEditor(getSharedEditor());
        }

        p.putAction(SelectSameAction.ID, new SelectSameAction(v.getEditor()));
    }

    @Override
    public void initApplication(Application a) {
        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        AbstractAction aa;

        gridConstrainer = new GridConstrainer(12, 12);

        putAction(ClearSelectionAction.ID, new ClearSelectionAction());
        putAction(ViewSourceAction.ID, new ViewSourceAction(a));
        putAction(ExportAction.ID, new ExportAction(a));
    }

    public Collection<Action> createDrawingActions(Application app, DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new CutAction());
        a.add(new CopyAction());
        a.add(new PasteAction());
        a.add(new SelectAllAction());
        a.add(new ClearSelectionAction());
        a.add(new SelectSameAction(editor));
        return a;
    }

    public static Collection<Action> createSelectionActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new DuplicateAction());

        a.add(null); // separator
        a.add(GroupAction.create(editor, new SVGGroupFigure()));
        a.add(UngroupAction.create(editor, new SVGGroupFigure()));
        a.add(new CombineAction(editor));
        a.add(new SplitAction(editor));

        a.add(null); // separator
        a.add(new BringToFrontAction(editor));
        a.add(new SendToBackAction(editor));

        return a;
    }

    @Override
    public java.util.List<JMenu> createMenus(Application a, View pr) {
        LinkedList<JMenu> mb = new LinkedList<JMenu>();
        mb.add(createEditMenu(a, pr));
        mb.add(createViewMenu(a, pr));
        return mb;
    }

    protected JMenu createViewMenu(Application a, View p) {
        JMenu m, m2;
        JMenuItem mi;
        JRadioButtonMenuItem rbmi;
        JCheckBoxMenuItem cbmi;
        ButtonGroup group;
        Action action;

        ResourceBundleUtil appLabels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        ResourceBundleUtil svgLabels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

        m = new JMenu();
        appLabels.configureMenu(m, "view");
        m.add(getAction(ViewSourceAction.ID));

        return m;
    }

    @Override
    protected JMenu createEditMenu(Application a, View p) {
        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JMenu m = super.createEditMenu(a, p);
        JMenuItem mi;

        mi = m.add(getAction(ClearSelectionAction.ID));
        mi.setIcon(null);

        if (p != null) {
            mi = m.add(p.getAction(SelectSameAction.ID));
        } else {
            mi = new JMenuItem();
            drawLabels.configureMenu(mi, SelectSameAction.ID);
            mi.setEnabled(false);
            m.add(mi);
        }
        mi.setIcon(null);
        return m;
    }

    /**
     * Overriden to create no toolbars.
     * 
     * @param app
     * @param p
     * @return An empty list.
     */
    @Override
    public List<JToolBar> createToolBars(Application app, View p) {
        LinkedList<JToolBar> list = new LinkedList<JToolBar>();
        return list;
    }
}
