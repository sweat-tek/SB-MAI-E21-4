package org.jhotdraw.draw.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class GroupingBehaviorTest extends ScenarioTest<GivenFiguresToGroup, WhenGrouping, ThenFiguresGrouped> {

    @Test
    public void selectingSimpleFiguresAndGroupingThemResultsInJustThoseFiguresBeingGrouped() {
        given().someSelectedBezierFigures()
                .and().someUnselectedBezierFigures();

        when().groupingFigures();

        then().onlyTheSelectedFiguresAreGrouped();
    }

    @Test
    public void selectingGroupFiguresAndGroupingThemResultsInJustThoseFiguresBeingGrouped() {
        given().aSelectedGroupFigure()
                .and().aSelectedGroupFigure();

        when().groupingFigures();

        then().onlyTheSelectedFiguresAreGrouped();
    }

    @Test
    public void selectingAGroupFigureAndUngroupingItResultsInItsChildrenBeingAddedAndItselfRemovedFromTheDrawing() {
        given().aSelectedGroupFigure()
                .and().someUnselectedBezierFigures();

        when().ungroupingFigures();

        then().onlyTheSelectedGroupFigureIsUngrouped();
    }

    @Test
    public void selectingAnEmptyGroupFigureAndUngroupingItResultsInItBeingRemovedFromTheDrawing() {
        given().aSelectedEmptyGroupFigure()
                .and().someUnselectedBezierFigures();

        when().ungroupingFigures();

        then().onlyTheSelectedGroupFigureIsUngrouped();
    }

}
