package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

class GivenFiguresToGroup extends Stage<GivenFiguresToGroup> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenFiguresToGroup someSelectedBezierFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
        return this;
    }

    GivenFiguresToGroup someUnselectedBezierFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        return this;
    }

    GivenFiguresToGroup aSelectedGroupFigure() {
        CompositeFigure group1 = new SVGGroupFigure();
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        group1.add(f1);
        group1.add(f2);
        editor.getActiveView().getDrawing().add(group1);
        editor.getActiveView().addToSelection(group1);
        return this;
    }

    GivenFiguresToGroup anUnselectedGroupFigure() {
        CompositeFigure group1 = new SVGGroupFigure();
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        group1.add(f1);
        group1.add(f2);
        editor.getActiveView().getDrawing().add(group1);
        return this;
    }

    GivenFiguresToGroup aSelectedEmptyGroupFigure() {
        CompositeFigure group1 = new SVGGroupFigure();
        editor.getActiveView().getDrawing().add(group1);
        editor.getActiveView().addToSelection(group1);
        return this;
    }
}
