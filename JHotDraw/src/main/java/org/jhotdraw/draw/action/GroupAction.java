/*
 * @(#)GroupAction.java  2.0.3  2008-06-08
 *
 * Copyright (c) 1996-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.draw.action;

import java.util.Collection;
import java.util.LinkedList;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

/**
 * GroupAction. N
 *
 * @author Werner Randelshofer
 * @version 2.0.3 2008-06-08 Fixed NPE in methods canGroup/canUngroup.
 * <br>2.0.2 2008-05-12 Undoable edit events fired by this action did not work.
 * <br>2.0.1 2008-04-12 Ungrouped figures must be inserted at the z-index of the
 * original group.
 * <br>2.0 2007-12-21 Refactored this class, so that it can be used as a base
 * class for UngroupAction.
 * <br>1.1 2006-07-12 Changed to support any CompositeFigure.
 * <br>1.0.1 2006-07-09 Fixed enabled state.
 * <br>1.0 24. November 2003 Created.
 */
public class GroupAction extends AbstractGroupAction {

    public final static String ID = "edit.groupSelection";

    private UngroupAction ungroupAction;

    GroupAction(DrawingEditor editor, CompositeFigure prototype) {
        super(editor, prototype);
        labels.configureAction(this, ID);
        updateEnabledState();
    }

    public static GroupAction create(DrawingEditor editor) {
        return create(editor, new SVGGroupFigure());
    }

    public static GroupAction create(DrawingEditor editor, CompositeFigure prototype) {
        GroupAction groupAction = new GroupAction(editor, prototype);
        UngroupAction ungroupAction = new UngroupAction(editor, prototype);
        groupAction.setUngroupAction(ungroupAction);
        ungroupAction.setGroupAction(groupAction);

        return groupAction;
    }

    void setUngroupAction(UngroupAction ungroupAction) {
        this.ungroupAction = ungroupAction;
    }

    @Override
    boolean canPerformAction() {
        return getView() != null && getView().getSelectionCount() > 1;
    }

    @Override
    void perform() {
        final DrawingView view = getView();
        final LinkedList<Figure> ungroupedFigures = new LinkedList<>(view.getSelectedFigures());
        final CompositeFigure group = groupFigures(view, ungroupedFigures);

        fireUndoableEditHappened(new UndoableGroupEdit(view, group, ungroupedFigures));
    }

    CompositeFigure groupFigures(DrawingView view, Collection<Figure> figures) {
        CompositeFigure group = (CompositeFigure) prototype.clone();
        Collection<Figure> sorted = view.getDrawing().sort(figures);
        int index = view.getDrawing().indexOf(sorted.iterator().next());
        view.getDrawing().basicRemoveAll(figures);
        view.clearSelection();
        view.getDrawing().add(index, group);
        group.willChange();
        for (Figure f : sorted) {
            group.basicAdd(f);
        }
        group.changed();
        view.addToSelection(group);
        return group;
    }

    private class UndoableGroupEdit extends AbstractUndoableEdit {

        private final DrawingView view;
        private CompositeFigure group;
        private Collection<Figure> ungroupedFigures;

        private UndoableGroupEdit(DrawingView view, CompositeFigure group, Collection<Figure> ungroupedFigures) {
            this.view = view;
            this.group = group;
            this.ungroupedFigures = ungroupedFigures;
        }

        @Override
        public String getPresentationName() {
            return labels.getString("edit.groupSelection.text");
        }

        @Override
        public void redo() throws CannotRedoException {
            super.redo();
            group = groupFigures(view, ungroupedFigures);
        }

        @Override
        public void undo() throws CannotUndoException {
            ungroupedFigures = ungroupAction.ungroupFigures(view, group);
            super.undo();
        }

        @Override
        public boolean addEdit(UndoableEdit anEdit) {
            return super.addEdit(anEdit);
        }
    }
}
