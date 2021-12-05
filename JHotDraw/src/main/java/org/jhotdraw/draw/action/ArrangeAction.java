package org.jhotdraw.draw.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrangeAction extends AbstractSelectedAction {

    public final ArrangeType type;
    public final String ID;

    public ArrangeAction(DrawingEditor editor, ArrangeType type) {
        super(editor);
        this.type = type;
        this.ID=type.toString();
        labels.configureAction(this, this.ID);

    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public void actionPerformed(ActionEvent e) {
        final DrawingView view = getView();
        final LinkedList<Figure> figures = new LinkedList<Figure>(view.getSelectedFigures());
        if(this.type==ArrangeType.TOFRONT){
            bringToFront(view, figures);
        }
        if(this.type==ArrangeType.TOBACK){
            sendToBack(view, figures);
        }

        fireUndoableEditHappened(new AbstractUndoableEdit() {
                                     @Override
                                     public String getPresentationName() {
                                         return labels.getTextProperty(ID);
                                     }
                                     @Override
                                     public void redo() throws CannotRedoException {
                                         super.redo();
                                         ArrangeAction.bringToFront(view, figures);
                                     }
                                     @Override
                                     public void undo() throws CannotUndoException {
                                         super.undo();
                                         ArrangeAction.sendToBack(view, figures);
                                     }
                                 }

        );
    }
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public static void bringToFront(DrawingView view, Collection figures) {
        Drawing drawing = view.getDrawing();
        Iterator i = drawing.sort(figures).iterator();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.sendToFront(figure);
        }
    }
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public static void sendToBack(DrawingView view, Collection figures) {
        Iterator i = figures.iterator();
        Drawing drawing = view.getDrawing();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.sendToBack(figure);
        }
    }


}

