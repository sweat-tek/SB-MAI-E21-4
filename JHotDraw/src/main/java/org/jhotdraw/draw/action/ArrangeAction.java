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
import java.util.ArrayList;
import java.util.Iterator;


public class ArrangeAction extends AbstractSelectedAction {
    public static String ID;
    public ArrangeAction(DrawingEditor editor, String ID) {
        super(editor);
        ArrangeAction.ID =ID;
        labels.configureAction(this, ID);

    }

    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public void actionPerformed(java.awt.event.ActionEvent e) {
        final DrawingView view = getView();
        final ArrayList<Figure> figures = new ArrayList<Figure>(view.getSelectedFigures());
        Iterator i = figures.iterator();
        Drawing drawing = view.getDrawing();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            if (ID.equalsIgnoreCase("edit.sendToBack")){
                drawing.sendToBack(figure);
            }else{
                drawing.sendToFront(figure);
            }
        }
        fireUndoableEditHappened(new AbstractUndoableEdit() {
             @Override
             public String getPresentationName() {
                                         return labels.getTextProperty(ID);
                                     }
             @Override
             public void redo() throws CannotRedoException {
                 super.redo();
                 SendToBackAction.sendToBack(view, figures);
             }
             @Override
             public void undo() throws CannotUndoException {
                 super.undo();
                 BringToFrontAction.bringToFront(view, figures);
                }
             }
        );
    }



}
