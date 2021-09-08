package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

public class WhenGrouping extends Stage<WhenGrouping> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;

    @ProvidedScenarioState
    private Set<Figure> nonselectedFigures;

    @ProvidedScenarioState
    private Set<Figure> childrenFigures;

    private GroupAction groupAction;
    private UngroupAction ungroupAction;

    @BeforeStage
    public void before() {
        groupAction = GroupAction.create(editor, new SVGGroupFigure());
        ungroupAction = UngroupAction.create(editor, new SVGGroupFigure());

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());

        nonselectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());
        nonselectedFigures.removeAll(selectedFigures);
    }

    WhenGrouping groupingFigures() {
        groupAction.actionPerformed(null);
        return this;
    }

    WhenGrouping ungroupingFigures() {
        childrenFigures = new HashSet<>(((CompositeFigure) selectedFigures.iterator().next()).getChildren());
        ungroupAction.actionPerformed(null);
        return this;
    }
}
