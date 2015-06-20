// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Walton2013.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.Walton2013.OI;
import org.usfirst.frc2974.Walton2013.RobotMap;
import org.usfirst.frc2974.Walton2013.commands.UseDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    CANJaguar rearRightTalon = RobotMap.driveTrainrearRightTalon;
    CANJaguar frontRightTalon = RobotMap.driveTrainfrontRightTalon;
    CANJaguar frontLeftTalon = RobotMap.driveTrainfrontLeftTalon;
    CANJaguar rearLeftTalon = RobotMap.driveTrainrearLeftTalon;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new UseDrive(true));
    }

    public void setSpeeds(double forward, double turn, double sideways) {
        double frontL = forward + turn + sideways;
        double frontR = forward - turn - sideways;
        double backL = forward + turn - sideways;
        double backR = forward - turn + sideways;
        try {
            rearRightTalon.setX(backR);
            rearLeftTalon.setX(backL);
            frontLeftTalon.setX(frontL);
            frontRightTalon.setX(frontR);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    //PUT OTHER FUNCTIONS HERE!!!!!
}