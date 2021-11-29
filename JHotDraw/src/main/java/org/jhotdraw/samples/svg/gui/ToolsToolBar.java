/*
 * @(#)DrawToolsPane.java  2.0  2008-04-06
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
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

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jhotdraw.app.action.DuplicateAction;
import org.jhotdraw.draw.*;
import static org.jhotdraw.draw.AttributeKeys.CLOSED;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.samples.svg.PathTool;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;
import org.jhotdraw.samples.svg.action.CombineAction;
import org.jhotdraw.samples.svg.action.SplitAction;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * DrawToolsPane.
 *
 * @author Werner Randelshofer
 * @version 2.0 2008-04-06 Reworked.
 * <br>1.0 May 1, 2007 Created.
 */
public class ToolsToolBar extends AbstractToolBar {

    /**
     * Creates new instance.
     */
    public ToolsToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString("tools.toolbar"));
    }

    private GridBagConstraints setupGridBagConstraints(int gridx, int gridy, int[] insets) {
        GridBagConstraints gbc = setupGridBagConstraints(gridx, gridy);
        gbc.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);

        return gbc;
    }

    private GridBagConstraints setupGridBagConstraints(int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        return gbc;
    }

    @Override
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        switch (state) {
            case 1: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);
                GridBagConstraints gbc;
                AbstractButton btn;
                //CreationTool creationTool;
                //PathTool pathTool;
                //TextCreationTool textTool;
                //TextAreaCreationTool textAreaTool;
                //SVGCreateFromFileTool imageTool;

                HashMap<AttributeKey, Object> attributes;
                btn = ButtonFactory.addSelectionToolTo(this, editor,
                        ButtonFactory.createDrawingActions(editor),
                        createSelectionActions(editor));
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
//                gbc = new GridBagConstraints();
//                gbc.gridx = 0;
//                gbc.gridy = 0;
                gbc = setupGridBagConstraints(0, 0);
                p.add(btn, gbc);
                //createSelectionTool(p, btn, gbc);
                labels.configureToolBarButton(btn, "selectionTool");

                attributes = new HashMap<>();
//                btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGRectFigure(), attributes), "createRectangle", labels);
//                creationTool.setToolDoneAfterCreation(false);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 0;
////                gbc.gridy = 1;
////                gbc.insets = new Insets(3, 0, 0, 0);
//                gbc = setupGridBagConstraints(0, 1, new int[]{3, 0, 0, 0});
////                p.add(btn, gbc);
                createRectangleTool(p, btn, gbc, labels, attributes);

//                btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGEllipseFigure(), attributes), "createEllipse", labels);
//                creationTool.setToolDoneAfterCreation(false);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 1;
////                gbc.gridy = 1;
////                gbc.insets = new Insets(3, 3, 0, 0);
//                gbc = setupGridBagConstraints(1, 1, new int[]{3, 3, 0, 0});
////                p.add(btn, gbc);
                createEllipseTool(p, btn, gbc, labels, attributes);

//                btn = ButtonFactory.addToolTo(this, editor, pathTool = new PathTool(new SVGPathFigure(), new SVGBezierFigure(true), attributes), "createPolygon", labels);
//                pathTool.setToolDoneAfterCreation(false);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 2;
////                gbc.gridy = 1;
////                gbc.insets = new Insets(3, 3, 0, 0);
//                gbc = setupGridBagConstraints(2, 1, new int[]{3, 3, 0, 0});
////                p.add(btn, gbc);
                createPolygonTool(p, btn, gbc, labels, attributes);

                attributes = new HashMap<>();
//                attributes.put(AttributeKeys.FILL_COLOR, null);
//                attributes.put(CLOSED, false);
//                btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGPathFigure(), attributes), "createLine", labels);
//                creationTool.setToolDoneAfterCreation(false);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 1;
////                gbc.gridy = 0;
////                gbc.insets = new Insets(0, 3, 0, 0);
//                gbc = setupGridBagConstraints(1, 0, new int[]{0, 3, 0, 0});
////                p.add(btn, gbc);
                createLineTool(p, btn, gbc, labels, attributes);

//                btn = ButtonFactory.addToolTo(this, editor, pathTool = new PathTool(new SVGPathFigure(), new SVGBezierFigure(false), attributes), "createScribble", labels);
//                pathTool.setToolDoneAfterCreation(false);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 2;
////                gbc.gridy = 0;
////                gbc.insets = new Insets(0, 3, 0, 0);
//                gbc = setupGridBagConstraints(2, 0, new int[]{0, 3, 0, 0});
////                p.add(btn, gbc);
                createScribbleTool(p, btn, gbc, labels, attributes);

                attributes = new HashMap<>();
//                attributes.put(AttributeKeys.FILL_COLOR, Color.black);
//                attributes.put(AttributeKeys.STROKE_COLOR, null);
//                btn = ButtonFactory.addToolTo(this, editor, textTool = new TextCreationTool(new SVGTextFigure(), attributes), "createText", labels);
//                textTool.setToolDoneAfterCreation(true);
//                btn.setName("createText");
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 0;
////                gbc.gridy = 2;
////                gbc.insets = new Insets(3, 0, 0, 0);
//                gbc = setupGridBagConstraints(0, 2, new int[]{3, 0, 0, 0});
////                p.add(btn, gbc);
                createTextCreationTool(p, btn, gbc, labels, attributes);

//                textAreaTool = new TextAreaCreationTool(new SVGTextAreaFigure(), attributes);
//                textAreaTool.setRubberbandColor(Color.BLACK);
//                textAreaTool.setToolDoneAfterCreation(true);
//                btn = ButtonFactory.addToolTo(this, editor, textAreaTool, "createTextArea", labels);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 1;
////                gbc.gridy = 2;
////                gbc.insets = new Insets(3, 3, 0, 0);
//                gbc = setupGridBagConstraints(1, 2, new int[]{3, 3, 0, 0});
////                p.add(btn, gbc);
                createTextAreaTool(p, btn, gbc, labels, attributes);

//                attributes = new HashMap<AttributeKey, Object>();
//                attributes.put(AttributeKeys.FILL_COLOR, null);
//                attributes.put(AttributeKeys.STROKE_COLOR, null);
//                btn = ButtonFactory.addToolTo(this, editor, imageTool = new SVGCreateFromFileTool(new SVGImageFigure(), new SVGGroupFigure(), attributes), "createImage", labels);
//                imageTool.setToolDoneAfterCreation(true);
//                imageTool.setUseFileDialog(true);
//                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
////                gbc = new GridBagConstraints();
////                gbc.gridx = 2;
////                gbc.gridy = 2;
////                gbc.insets = new Insets(3, 3, 0, 0);
//                gbc = setupGridBagConstraints(2, 2, new int[]{3,3,0,0});
////                p.add(btn, gbc);
                attributes = new HashMap<>();
                createImageTool(p, btn, gbc, labels, attributes);
            }
            break;
        }
        return p;
    }

    private void createSelectionTool(JPanel p, AbstractButton btn, GridBagConstraints gbc) {
        btn = ButtonFactory.addSelectionToolTo(this, editor,
                ButtonFactory.createDrawingActions(editor),
                createSelectionActions(editor));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(0, 0);
        p.add(btn, gbc);
    }

    private void createRectangleTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        CreationTool creationTool;
        btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGRectFigure(), attributes), "createRectangle", labels);
        creationTool.setToolDoneAfterCreation(false);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(0, 1, new int[]{3, 0, 0, 0});
        p.add(btn, gbc);
    }

    private void createEllipseTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        CreationTool creationTool;
        btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGEllipseFigure(), attributes), "createEllipse", labels);
        creationTool.setToolDoneAfterCreation(false);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(1, 1, new int[]{3, 3, 0, 0});
        p.add(btn, gbc);
    }

    private void createPolygonTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        PathTool pathTool;
        btn = ButtonFactory.addToolTo(this, editor, pathTool = new PathTool(new SVGPathFigure(), new SVGBezierFigure(true), attributes), "createPolygon", labels);
        pathTool.setToolDoneAfterCreation(false);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(2, 1, new int[]{3, 3, 0, 0});
        p.add(btn, gbc);
    }

    private void createLineTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        CreationTool creationTool;
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(CLOSED, false);
        btn = ButtonFactory.addToolTo(this, editor, creationTool = new CreationTool(new SVGPathFigure(), attributes), "createLine", labels);
        creationTool.setToolDoneAfterCreation(false);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(1, 0, new int[]{0, 3, 0, 0});
        p.add(btn, gbc);
    }

    private void createScribbleTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        PathTool pathTool;
        btn = ButtonFactory.addToolTo(this, editor, pathTool = new PathTool(new SVGPathFigure(), new SVGBezierFigure(false), attributes), "createScribble", labels);
        pathTool.setToolDoneAfterCreation(false);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(2, 0, new int[]{0, 3, 0, 0});
        p.add(btn, gbc);
    }

    private void createTextCreationTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        TextCreationTool textTool;
        attributes.put(AttributeKeys.FILL_COLOR, Color.black);
        attributes.put(AttributeKeys.STROKE_COLOR, null);
        btn = ButtonFactory.addToolTo(this, editor, textTool = new TextCreationTool(new SVGTextFigure(), attributes), "createText", labels);
        textTool.setToolDoneAfterCreation(true);
        btn.setName("createText");
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(0, 2, new int[]{3, 0, 0, 0});
        p.add(btn, gbc);
    }

    private void createTextAreaTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels,
            HashMap<AttributeKey, Object> attributes) {
        TextAreaCreationTool textAreaTool;
        textAreaTool = new TextAreaCreationTool(new SVGTextAreaFigure(), attributes);
        textAreaTool.setRubberbandColor(Color.BLACK);
        textAreaTool.setToolDoneAfterCreation(true);
        btn = ButtonFactory.addToolTo(this, editor, textAreaTool, "createTextArea", labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(1, 2, new int[]{3, 3, 0, 0});
        p.add(btn, gbc);
    }

    private void createImageTool(JPanel p, AbstractButton btn,
            GridBagConstraints gbc, ResourceBundleUtil labels, HashMap<AttributeKey, Object> attributes) {
        SVGCreateFromFileTool imageTool;
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(AttributeKeys.STROKE_COLOR, null);
        btn = ButtonFactory.addToolTo(this, editor, imageTool = new SVGCreateFromFileTool(new SVGImageFigure(), new SVGGroupFigure(), attributes), "createImage", labels);
        imageTool.setToolDoneAfterCreation(true);
        imageTool.setUseFileDialog(true);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = setupGridBagConstraints(2, 2, new int[]{3, 3, 0, 0});
        p.add(btn, gbc);
    }

    public static Collection<Action> createSelectionActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<>();
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
    protected String getID() {
        return "tools";
    }

    protected int getDefaultDisclosureState() {
        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
