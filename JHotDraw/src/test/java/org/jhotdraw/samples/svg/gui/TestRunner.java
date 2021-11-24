/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;

/**
 *
 * @author jakob
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ToolsToolBarTest.class);
        
        for (Failure fail : result.getFailures()) {
            System.out.println("Fails: "+fail.toString());
        }
        System.out.println("Success: "+result.wasSuccessful());
    }
}
