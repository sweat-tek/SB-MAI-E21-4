package org.jhotdraw.draw.arrange;

import junit.framework.TestCase;
import org.jhotdraw.draw.Arrange;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

import java.util.ArrayList;

public class ArrangeTest extends TestCase {
    private ArrayList<Figure> figures;

    public void setUp() throws Exception {
        super.setUp();
        figures=new ArrayList<>();
        figures.add(new SVGImageFigure());
        figures.add(new SVGImageFigure());
        figures.add(new SVGImageFigure());

    }

    public void tearDown() throws Exception {
    }

    public void testToBack() {
        Figure a = new SVGImageFigure();
        assertNotNull("Figure object not Null", a);
        figures.add(a);
        assertSame("Figure Add to figures", a, figures.get(figures.size()-1));
        Arrange.ToBack(a,figures);
        assertSame("Figure is send to back ", a, figures.get(0));


    }

    public void testToFront() {
        Figure a = new SVGImageFigure();
        assertNotNull("Figure object not Null", a);
        figures.add(a);
        assertSame("Figure Add to figures", a, figures.get(figures.size()-1));
        Arrange.ToBack(a,figures);
        assertSame("Figure is send to back ", a, figures.get(0));
        Arrange.ToFront(a,figures);
        assertSame("Figure is send to Front ", a, figures.get(figures.size()-1));
    }
}