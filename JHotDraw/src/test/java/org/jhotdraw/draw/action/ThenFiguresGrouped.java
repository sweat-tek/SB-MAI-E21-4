package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ThenFiguresGrouped extends Stage<ThenFiguresGrouped> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;

    @ExpectedScenarioState
    private Set<Figure> nonselectedFigures;

    @ExpectedScenarioState
    private Set<Figure> childrenFigures;

    ThenFiguresGrouped onlyTheSelectedFiguresAreGrouped() {
        //Only one figure (the resulting group) can be selected
        assertEquals(editor.getActiveView().getSelectionCount(), 1);

        Figure selected = editor.getActiveView().getSelectedFigures().iterator().next();
        assertFigureContains(selected, selectedFigures);

        //The originally nonselected figures as well as the new group are the only figures in the view
        Set<Figure> expectedSelection = new HashSet<>(nonselectedFigures);
        expectedSelection.add(selected);

        assertFigureContains(editor.getActiveView().getDrawing(), expectedSelection);

        return this;
    }

    ThenFiguresGrouped onlyTheSelectedGroupFigureIsUngrouped() {
        //Only the children of the original group are selected
        assertSelected(childrenFigures);

        //The originally nonselected figures as well as the children of the original group are the only figures in the
        //view
        Set<Figure> expectedChildren = new HashSet<>(childrenFigures);
        expectedChildren.addAll(nonselectedFigures);

        assertFigureContains(editor.getActiveView().getDrawing(), expectedChildren);

        return this;
    }

    private void assertFigureContains(Figure group, Set<Figure> children) {
        assertTrue(group instanceof CompositeFigure);
        CompositeFigure composite = (CompositeFigure) group;
        assertEquals(children.size(), composite.getChildCount());

        for (Figure child : children) {
            assertTrue(composite.contains(child));
        }
    }

    private void assertSelected(Set<Figure> figures) {
        assertEquals(figures.size(), editor.getActiveView().getSelectionCount());
        for (Figure figure : figures) {
            assertTrue(editor.getActiveView().getSelectedFigures().contains(figure));
        }
    }
}
