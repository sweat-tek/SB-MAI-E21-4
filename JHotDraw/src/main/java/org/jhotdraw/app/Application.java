/*
 * @(#)Application.java  2.0  2007-12-24
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

package org.jhotdraw.app;

import java.awt.*;
import java.beans.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
/**
 * An Application handles the lifecycle of {@link View}s and provides windows
 * to present them on screen. Depending on the document interface style 
 * used by the Application, the Application can handle multiple Views 
 * at the same time, or only one.
 * <p>
 * Typical document interface styles are the Single Document Interface (SDI),
 * the Multiple Document Interface (MDI) and the Mac OS X Application Document
 * Interface (OSX).
 * <p>
 * Typical usage of this class:
 * <pre>
 * public class MyMainClass {
 *     public static void main(String[] args) {
 *         Application app = new DefaultADIApplication();
 *         DefaultApplicationModel model = new DefaultApplicationModel();
 *         model.setName("MyAppliciation");
 *         model.setVersion("1.0");
 *         model.setCopyright("Copyright 2006 (c) Werner Randelshofer. All Rights Reserved.");
 *         model.setViewClassName("org.jhotdraw.myapplication.MyView");
 *         app.setModel(model);
 *         app.launch(args);
 *     } 
 * </pre>
 *
 * @author Werner Randelshofer
 * @version 2.0 2007-12-24 Renamed method getCurrentView to getActiveView. 
 * <br>1.0 October 4, 2005 Created.
 */
public interface Application {
    /**
     * The property name of the activeView property.
     */
    String ACTIVE_VIEW_PROPERTY = "activeView";
    
    /**
     * Launches the application from the main method.
     * This method is typically invoked on the main Thread.
     * This will invoke configure() on the current thread and then 
     * init() and start() on the AWT Event Dispatcher Thread.
     */
    void launch(String[] args);
    /**
     * Configures the application using the provided arguments array.
     */
    void configure(String[] args);
    
    /**
     * Initializes the application.
     * <code>configure()</code> should have been invoked before the application
     * is inited. Alternatively an application can be configured using setter
     * methods.
     */
    void init();
    
    /**
     * Starts the application.
     * This usually creates a new view, and adds it to the application.
     * <code>init()</code> must have been invoked before the application is started.
     */
    void start();
    /**
     * Stops the application without saving any unsaved views.
     * <code>init()</code> must have been invoked before the application is stopped.
     */
    void stop();
    
    /**
     * Creates a new view for this application.
     */
    View createView();
    
    /**
     * Adds a view to this application.
     * Fires a "documentCount" property change event.
     * Invokes method setApplication(this) on the view object.
     */
    void add(View p);
    
    /**
     * Removes a view from this application and removes it from the users
     * view.
     * Fires a "documentCount" property change event.
     * Invokes method setApplication(null) on the view object.
     */
    void remove(View p);
    
    /**
     * Shows a view.
     */
    void show(View p);
    /**
     * Hides a view.
     */
    void hide(View p);
    
    /**
     * This is a convenience method for removing a view and disposing it.
     */
    void dispose(View p);
    
    /**
     * Returns a read only collection view of the views of this application.
     */
    Collection<View> views();
    
    /**
     * Returns the active view. This is used for OSXApplication and 
     * MDIApplication which share actions among multiple View instances.
     * Active view may be become null, if the
     * application has no view.
     * <p>
     * This is a bound property. 
     */
    View getActiveView();
    
    /**
     * Returns the enabled state of the application.
     */
    boolean isEnabled();
    
    
    /**
     * Sets the enabled state of the application.
     *
     * The enabled state is used to prevent parallel invocation of actions
     * on the application. If an action consists of a sequential part and a
     * concurrent part, it must disable the application only for the sequential
     * part.
     *
     * Actions that act on the application must check in their actionPerformed
     * method whether the application is enabled.
     * If the application is disabled, they must do nothing. 
     * If the application is enabled, they must disable the application,
     * perform the action and then enable the application again.
     *
     * This is a bound property.
     */
    void setEnabled(boolean newValue);
    /**
     * Adds a property change listener.
     */
    void addPropertyChangeListener(PropertyChangeListener l);

    /**
     * Removes a property change listener.
     */
    void removePropertyChangeListener(PropertyChangeListener l);
    
    /**
     * Returns the name of the application.
     */
    String getName();
    /**
     * Returns the version of the application.
     */
    String getVersion();
    /**
     * Returns the copyright of the application.
     */
    String getCopyright();
    
    /**
     * Sets the application model.
     */
    void setModel(ApplicationModel newValue);

    /**
     * Returns the application model.
     */
    ApplicationModel getModel();
    
    /**
     * Returns true, if this application shares tools among multiple views.
     */
    boolean isSharingToolsAmongViews();
    
    /**
     * Returns the application component. 
     * This may return null, if the application is not represented by a component
     * of its own on the user interface.
     */
    Component getComponent();
    
    /**
     * Returns the recently opened files.
     * By convention, this is an immutable list.
     */
    java.util.List<File> recentFiles();
    /**
     * Appends a file to the list of recent files.
     * This fires a property change event for the property "recentFiles".
     */
    void addRecentFile(File file);
    /**
     * Clears the list of recent files.
     * This fires a property change event for the property "recentFiles".
     */
    void clearRecentFiles();
    
    /**
     * Adds a palette window to the application.
     */
    void addPalette(Window palette);
    /**
     * Removes a palette window from the application.
     */
    void removePalette(Window palette);
    /**
     * Adds a (non-palette) window to the application.
     *
     * @param window The window.
     * @param view The View to which this window is associated, or null,
     * if the window is associated to the application.
     */
    void addWindow(Window window, View view);
    /**
     * Removes a (non-palette) window from the application.
     */
    void removeWindow(Window window);
}
