/*
 * @(#)UngroupAction.java  2.0  2007-12-21
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
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

import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * UngroupAction.
 *
 * @author Werner Randelshofer
 * @version 2.0 2007-12-21 Extends GroupAction.
 * <br>1.1.1 2006-12-29 Add ungrouped figures at same index to Drawing where
 * the Group was.
 * <br>1.1 2006-07-12 Changed to support any CompositeFigure.
 * <br>1.0 24. November 2003  Created.
 */
public class UngroupAction extends AbstractGroupAction {

	public final static String ID = "edit.ungroupSelection";

	private GroupAction groupAction;

	UngroupAction(DrawingEditor editor, CompositeFigure prototype) {
		super(editor, prototype);
		labels.configureAction(this, ID);
		updateEnabledState();
	}

	public static UngroupAction create(DrawingEditor editor) {
		return create(editor, new SVGGroupFigure());
	}

	public static UngroupAction create(DrawingEditor editor, CompositeFigure prototype) {
		UngroupAction ungroupAction = new UngroupAction(editor, prototype);
		GroupAction groupAction = new GroupAction(editor, prototype);
		ungroupAction.setGroupAction(groupAction);
		groupAction.setUngroupAction(ungroupAction);

		return ungroupAction;
	}

	void setGroupAction(GroupAction groupAction) {
		this.groupAction = groupAction;
	}

	@Override
	boolean canPerformAction() {
		return getView() != null &&
				getView().getSelectionCount() == 1 &&
				prototype != null &&
				getView().getSelectedFigures().iterator().next().getClass().equals(
						prototype.getClass());
	}

	@Override
	void perform() {
		final DrawingView view = getView();
		final CompositeFigure group = (CompositeFigure) view.getSelectedFigures().iterator().next();
		final Collection<Figure> ungroupedFigures = ungroupFigures(view, group);

		fireUndoableEditHappened(new UndoableUngroupEdit(view, group, ungroupedFigures));
	}

	Collection<Figure> ungroupFigures(DrawingView view, CompositeFigure group) {
		LinkedList<Figure> figures = new LinkedList<>(group.getChildren());
		view.clearSelection();
		group.basicRemoveAllChildren();
		view.getDrawing().basicAddAll(view.getDrawing().indexOf(group), figures);
		view.getDrawing().remove(group);
		view.addToSelection(figures);
		return figures;
	}

	private class UndoableUngroupEdit extends AbstractUndoableEdit {

		private final DrawingView view;
		private CompositeFigure group;
		private Collection<Figure> ungroupedFigures;

		private UndoableUngroupEdit(DrawingView view, CompositeFigure group, Collection<Figure> ungroupedFigures) {
			this.view = view;
			this.group = group;
			this.ungroupedFigures = ungroupedFigures;
		}

		@Override
		public String getPresentationName() {
			return labels.getString("edit.ungroupSelection.text");
		}

		@Override
		public void redo() throws CannotRedoException {
			super.redo();
			ungroupedFigures = ungroupFigures(view, group);
		}

		@Override
		public void undo() throws CannotUndoException {
			group = groupAction.groupFigures(view, ungroupedFigures);
			super.undo();
		}
	}
}
