/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Walton2013.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Chris
 */
public class DelayMaker extends CommandBase {

    private static double delaySeconds;

    /**
     *
     * @param secs the amount of time in seconds to delay
     */
    public DelayMaker(double secs) {
        delaySeconds = secs;
    }

    protected void initialize() {
    }

    protected void execute() {
        //RobotLogger.getInstance().logMessage("Delaying for "+delaySeconds+" seconds");
        Timer.delay(delaySeconds);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }

    public static void setDelaySeconds(double secs) {
        delaySeconds = secs;
    }

    public static void delayMe() {
        Timer.delay(delaySeconds);
    }
}
