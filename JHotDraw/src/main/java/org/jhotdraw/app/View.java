/*
 * @(#)View.java  4.1  2008-03-23
 *
 * Copyright (c) 1996-2008 by the original authors of JHotDraw
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

import java.io.*;
import java.beans.*;
import javax.swing.*;
/**
 * A view on a document or a set of related documents within an Application.
 * <p>
 * After a view has been initialized using init(),
 * either method clear() must be called
 * or method read(), in order to fully initialize the View.
 *
 * @author Werner Randelshofer
 * @version 4.1 2008-03-23 Added method canSaveTo(). 
 * <br>4.0 2008-03-20 Renamed from Project to View.
 * <br>3.0 2007-12-25 Added start, stop, activate and deactivate methods.
 * Added constants for property names. 
 * <br>2.0 2007-11-29 Method clear is now always invoked on a worker 
 * thread.
 * <br>1.0 October 4, 2005 Created.
 */
public interface View {
    /**
     * The name of the application property.
     */
    String APPLICATION_PROPERTY = "application";
    /**
     * The name of the file property.
     */
    String FILE_PROPERTY = "file";
    /**
     * The name of the title property.
     */
    String TITLE_PROPERTY = "title";
    /**
     * The name of the enabled property.
     */
    String ENABLED_PROPERTY = "enabled";
    /**
     * The name of the hasUnsavedChanges property.
     */
    String HAS_UNSAVED_CHANGES_PROPERTY = "hasUnsavedChanges";
    /**
     * The name of the multipleOpenId property.
     */
    String MULTIPLE_OPEN_ID_PROPERTY = "multipleOpenId";
    /**
     * The name of the showing property.
     */
    String SHOWING_PROPERTY = "showing";
    /**
     * Gets the application to which this view belongs.
     */
    Application getApplication();
    
    /**
     * Sets the application of the view.
     * By convention, this is only invoked by Application.add() and
     * Application.remove().
     * This is a bound property.
     */
    void setApplication(Application newValue);
    
    /**
     * Returns the visual component of the view.
     */
    JComponent getComponent();
    
    /**
     * Returns the file which holds the document of the view.
     */
    File getFile();
    
    /**
     * Sets the file of the view.
     * This is a bound property.
     */
    void setFile(File newValue);
    
    /**
     * Returns the enabled state of the view.
     */
    boolean isEnabled();
    
    /**
     * Sets the enabled state of the view.
     *
     * The enabled state is used to prevent parallel invocation of actions
     * on the view. If an action consists of a sequential part and a
     * concurrent part, it must disable the view only for the sequential
     * part.
     *
     * Actions that act on the view must check in their actionPerformed
     * method whether the view is enabled.
     * If the view is disabled, they must do nothing.
     * If the view is enabled, they must disable the view,
     * perform the action and then enable the view again.
     *
     * This is a bound property.
     */
    void setEnabled(boolean newValue);
    
    /**
     * Writes the view to the specified file.
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     */
    void write(File f) throws IOException;
    
    /**
     * Reads the view from the specified file.
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     */
    void read(File f) throws IOException;
    
    /**
     * Clears the view, for example by emptying the contents of
     * the view, or by reading a template contents from a file.
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     */
    void clear();
    
    
    /**
     * Gets the open file chooser for the view.
     */
    JFileChooser getOpenChooser();
    /**
     * Gets the save file chooser for the view.
     */
    JFileChooser getSaveChooser();
    /**
     * Returns true, if the view has unsaved changes.
     * This is a bound property.
     */
    boolean hasUnsavedChanges();
    /**
     * Marks all changes as saved.
     * This changes the state of hasUnsavedChanges to false.
     */
    void markChangesAsSaved();
    
    /**
     * Returns true, if this view can be saved to the specified file.
     * A reason why the view can't be saved to a file, is that the
     * view is unable to write to a file with the given filename
     * extension without losing data. 
     * <p>
     * The SaveAction uses this method to decide, whether to display
     * a file dialog before saving the file.
     * 
     * @param file A file. If this parameter is null, a NullPointerException
     * is thrown.
     */
    boolean canSaveTo(File file);
    
    /**
     * Executes the specified runnable on the worker thread of the view.
     * Execution is perfomred sequentially in the same sequence as the
     * runnables have been passed to this method.
     */
    void execute(Runnable worker);
    
    /**
     * Initializes the view.
     * This is invoked right before the application shows the view.
     * A view must not consume many resources before method init() is called.
     * This is crucial for the responsivenes of an application.
     * <p>
     * After a view has been initialized using init(),
     * either method clear() must be called
     * or method read, in order to fully initialize a  View.
     */
    void init();
    
    /**
     * Starts the view.
     * Invoked after a view has been made visible to the user.
     * Multiple view can be visible at the same time.
     */
    void start();
    /**
     * Activates the view.
     * This occurs, when the user activated the parent window of the view.
     * Only one view can be active at any given time.
     * This method is only invoked on a started view.
     */
    void activate();
    /**
     * Deactivates the view.
     * This occurs, when the user closes the view, or activated another view.
     * This method is only invoked on a started view.
     */
    void deactivate();
    /**
     * Stops the view.
     * Invoked after a view window has been minimized or made invisible.
     */
    void stop();
    /**
     * Gets rid of all the resources of the view.
     * No other methods should be invoked on the view afterwards.
     * A view must not consume many resources after method dispose() has been called.
     * This is crucial for the responsivenes of an application.
     */
    void dispose();
    
    /**
     * Returns the action with the specified id.
     */
    Action getAction(String id);
    
    /**
     * Puts an action with the specified id.
     */
    void putAction(String id, Action action);
    
    /**
     * Adds a property change listener.
     */
    void addPropertyChangeListener(PropertyChangeListener l);
    
    /**
     * Removes a property change listener.
     */
    void removePropertyChangeListener(PropertyChangeListener l);
    
    /**
     * Sets the multiple open id.
     * The id is used to help distinguish multiply opened views.
     * The id should be displayed in the title of the view.
     */
    void setMultipleOpenId(int newValue);
    
    /**
     * Returns the multiple open id.
     * If a view is open only once this should be 1.
     */
    int getMultipleOpenId();
    
    /**
     * This is used by Application to keep track if a view is showing.
     */
    boolean isShowing();
    /**
     * This is used by Application to keep track if a view is showing.
     */
    void setShowing(boolean newValue);
    
    /**
     * Sets the title of the view. 
     * <p>
     * The title is generated by the application, based on the current
     * file of the view. The application ensures that the title uniquely
     * identifies each open view.
     * <p> 
     * The application displays the title in the title bar of the view 
     * window and in all windows which are associated to the view.
     * <p>
     * This is a bound property.
     */
    void setTitle(String newValue);
    
    /**
     * Gets the title of the view. 
     */
    String getTitle();
    
}
