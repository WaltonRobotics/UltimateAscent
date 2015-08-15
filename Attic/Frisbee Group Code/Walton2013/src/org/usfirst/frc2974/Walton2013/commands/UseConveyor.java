/*
 *Uses spatula sensor to turn on the conveyor
 * if frisbee is present
 */
package org.usfirst.frc2974.Walton2013.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc2974.Walton2013.FrisbeeSensors;

/**
 *
 * @author Alex
 */
public class UseConveyor extends CommandBase {

    private static FrisbeeSensors fBee = new FrisbeeSensors();

    public UseConveyor() { //, double flipperGoing) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(conveyor);
        //conveyorSpeed = speed;
    }
    Timer tickTockClock = new Timer();
    // Called just before this Command runs the first time

    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (oi.rightJoystick.getRawButton(5) || oi.rightJoystick.getRawButton(4)
                || oi.rightJoystick.getRawButton(2) || oi.rightJoystick.getRawButton(3)) { //DRIVER OVERRIDE
//Conveyor           
            if (oi.rightJoystick.getRawButton(5)) { //conveyor up
                conveyor.rollFrisbee(1);
            } else if (oi.leftJoystick.getRawButton(4)) { //conveyor down
                conveyor.rollFrisbee(-1);
            } else {
                //EXPLODE
            }

//Spatula
            if (oi.leftJoystick.getRawButton(2)) { //if left button 2 pressed
                conveyor.goGoGadgetSpatula(-1); //spatula down
            } else if (oi.leftJoystick.getRawButton(3)) { //if right button 3 pressed
                conveyor.goGoGadgetSpatula(1); //spatula up
            } else {
                //EXPLODE
            }
        } else { //AUTO CONVEYOR
           // if(fBee.frisbeeCount<4){
            conveyor.rollFrisbee(1); //ensure conveyor is running up

            if (oi.frisbeeOnSpatulaSensor.get()) { //if frisbee is on the spatula
                conveyor.goGoGadgetSpatula(1); //throw spatula into conveyor
            } else if (fBee.isOffSpatula()) { //if frisbee just came off spatula
                conveyor.goGoGadgetSpatula(-1); //reset spatula to ground level
                Timer.delay(1); //Let spatual actually get to ground level
                conveyor.goGoGadgetSpatula(0); //stop the spatula
            } else {
                //EXPLODE
            }
//        }
//            else{
//                conveyor.rollFrisbee(0);
//                conveyor.goGoGadgetSpatula(0);
//            }
        }
    }

// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
