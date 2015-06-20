// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Walton2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Walton2013.CamNetworkTable;

/**
 *
 */
public class AimAndShoot extends CommandBase {

    private static double shooterSpeed = 1; //FULL POWER

    public AimAndShoot() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//Control the wheel
        if (CommandBase.oi.leftJoystick.getRawButton(1)) {
            //shooter.spinUpWheel(getSpeed());
        } else if (!CommandBase.oi.rightJoystick.getRawButton(3)) {
            shooter.spinUpWheel(oi.getDesiredWheelSpeed());
        } else if (CommandBase.oi.rightJoystick.getRawButton(3)) {
//            if (CommandBase.oi.rightJoystick.getRawButton(4)) {
//                shooter.E_REVERSE_WHEEL();
//            } else {
            shooter.E_STOP_WHEEL();
            // }
        } else {
        }
        if (oi.leftJoystick.getRawButton(3)) {
            shooter.setElevate(1);
        } else if (oi.leftJoystick.getRawButton(2)) {
            shooter.setElevate(-1);
        } else {
            shooter.setElevate(0);
        }

//Shoot the frisbees        
        shooter.shoot();

//Aim
        //verticallyAim();
        if (CommandBase.oi.leftJoystick.getRawButton(4)) {
            System.out.println("Voltage: " + shooter.getShooterAngle());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return CommandBase.oi.ds.isAutonomous();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    public static double getSpeed() {
        double dist = CamNetworkTable.distance;
        if (dist < 25) {
            return .743;
        } else if (dist < 35) {
            return .8;
        } else {
            return 0;
        }
    }

    public static void verticallyAim() {
//center = 240
        double yCoor = CamNetworkTable.y;
        if (yCoor > 260) { //target's above shooter
            System.out.println("Vertical Going Down...");
            if (yCoor < 300) {
                shooter.setElevate(-.2);
            } else {
                shooter.setElevate(-.4);
            }
        } else if (yCoor < 220) { //target's below shooter
            System.out.println("Vertical Going Up...");
            if (yCoor > 180) {
                shooter.setElevate(.2);
            } else {
                shooter.setElevate(.4);
            }
        } else {
            System.out.println("Vertical Target Locked");
            shooter.setElevate(0);
        }

    }
}
//
//if (!CommandBase.oi.rightJoystick.getRawButton(3)) {
//            shooter.spinUpWheel(oi.getDesiredWheelSpeed());
//        } else if (CommandBase.oi.rightJoystick.getRawButton(3)) {
//            if (CommandBase.oi.rightJoystick.getRawButton(4)) {
//                shooter.E_REVERSE_WHEEL();
//            } else {
//                shooter.E_STOP_WHEEL();
//            }
//        } else {
//        }
////        if (!oi.rightJoystick.getRawButton(4)) { //ONLY TELEOP CODE
//////Spin up the wheels
////           // if (oi.leftJoystick.getRawButton(1)) {
////                shooter.spinUpWheel(oi.getDesiredWheelSpeed());
//////            } else {
//////                shooter.spinUpWheel(.5);
//////            }
//////Change the shooter angle
//////            if (oi.rightJoystick.getRawButton(3)) {
//////                shooter.putAngleUp();
//////            } else if (oi.rightJoystick.getRawButton(2)) {
//////                shooter.putAngleDown();
//////            } else {
//////                shooter.stopChangingAngle();
//////            }
////
////        } else {
////            shooter.spinUpWheel(1);
////            //DO DA AUTOMONOUS
////        }
//
////Shoot the frisbees        
//        //if (oi.rightJoystick.getRawButton(1)) {
//        shooter.SHOOT();
//        //}
