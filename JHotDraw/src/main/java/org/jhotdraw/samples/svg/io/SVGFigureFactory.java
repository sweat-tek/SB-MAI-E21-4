/*
 * @(#)SVGFigureFactory.java  1.0  December 7, 2006
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

package org.jhotdraw.samples.svg.io;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.text.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.samples.svg.*;

/**
 * Creates Figures for SVG elements.
 * <p>
 * Design pattern:<br>
 * Name: Abstract Factory.<br>
 * Role: Abstract Factory.<br>
 * Partners: {@link SVGInputFormat} as Client. 
 *
 * @author Werner Randelshofer
 * @version 1.0 December 7, 2006 Created.
 */
public interface SVGFigureFactory {
    Figure createRect(
            double x, double y, double width, double height, double rx, double ry,
            Map<AttributeKey, Object> attributes);
    
    Figure createCircle(
            double cx, double cy, double r,
            Map<AttributeKey, Object> attributes);
    
    Figure createEllipse(
            double cx, double cy, double rx, double ry,
            Map<AttributeKey, Object> attributes);

    Figure createLine(
            double x1, double y1, double x2, double y2,
            Map<AttributeKey, Object> attributes);

    Figure createPolyline(
            Point2D.Double[] points,
            Map<AttributeKey, Object> attributes);
    
    Figure createPolygon(
            Point2D.Double[] points,
            Map<AttributeKey, Object> attributes);

    Figure createPath(
            BezierPath[] beziers,
            Map<AttributeKey, Object> attributes);

    CompositeFigure createG(Map<AttributeKey, Object> attributes);
    
    Figure createText(
            Point2D.Double[] coordinates, double[] rotate,
            StyledDocument text,
            Map<AttributeKey, Object> attributes);
    
    Figure createTextArea(double x, double y, double w, double h,
                          StyledDocument doc, Map<AttributeKey, Object> attributes);

    /**
     * Creates a Figure from an image element.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param width The width.
     * @param height The height.
     * @param imageData Holds the image data. Can be null, if the buffered image
     * has not been created from a file.
     * @param bufferedImage Holds the buffered image. Can be null, if the 
     * image data has not been interpreted.
     * @param attributes Figure attributes.
     */
    Figure createImage(double x, double y, double width, double height,
                       byte[] imageData, BufferedImage bufferedImage, Map<AttributeKey, Object> attributes);


    Gradient createLinearGradient(
            double x1, double y1, double x2, double y2,
            double[] stopOffsets, Color[] stopColors, double[] stopOpacities,
            boolean isRelativeToFigureBounds, AffineTransform tx);
    
    Gradient createRadialGradient(
            double cx, double cy, double fx, double fy, double r,
            double[] stopOffsets, Color[] stopColors, double[] stopOpacities,
            boolean isRelativeToFigureBounds, AffineTransform tx);

}
