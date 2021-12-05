/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import org.jhotdraw.draw.ImageInputFormat;
import org.jhotdraw.draw.InputFormat;
import org.jhotdraw.draw.PictImageInputFormat;
import org.jhotdraw.draw.TextInputFormat;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.jhotdraw.samples.svg.io.SVGZInputFormat;

/**
 *
 * @author asbjo
 */
public class InputFormatCreator {
    public static LinkedList<InputFormat> loadInputFormats() {
        LinkedList<InputFormat> inputFormats = new LinkedList<InputFormat>();
        inputFormats.add(new SVGZInputFormat());
        inputFormats.add(new ImageInputFormat(new SVGImageFigure()));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "GIF", "Graphics Interchange Format (GIF)", "gif", BufferedImage.TYPE_INT_ARGB));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "PNG", "Portable Network Graphics (PNG)", "png", BufferedImage.TYPE_INT_ARGB));
        inputFormats.add(new PictImageInputFormat(new SVGImageFigure()));
        inputFormats.add(new TextInputFormat(new SVGTextFigure()));
        
        return inputFormats;
    }
}
