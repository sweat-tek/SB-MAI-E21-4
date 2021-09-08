package org.jhotdraw.draw.action;

import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;

import java.awt.event.ActionEvent;

/**
 * @author Kasper
 */
public abstract class AbstractGroupAction extends AbstractSelectedAction {

	protected CompositeFigure prototype;

	AbstractGroupAction(DrawingEditor editor, CompositeFigure prototype) {
		super(editor);
		this.prototype = prototype;
	}

	@Override
	protected void updateEnabledState() {
		if (getView() != null) {
			setEnabled(canPerformAction());
		} else {
			setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (canPerformAction()) {
			perform();
		}
	}

	abstract void perform();

	abstract boolean canPerformAction();
}
