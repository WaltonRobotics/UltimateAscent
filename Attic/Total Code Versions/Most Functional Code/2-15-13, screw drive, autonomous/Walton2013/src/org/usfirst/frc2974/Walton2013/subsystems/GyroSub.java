/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Walton2013.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.Walton2013.RobotMap;

/**
 *
 * @author Alex
 */
public class GyroSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private static Gyro gyro = new Gyro(RobotMap.gyroChannel);

    public GyroSub() {
        gyro.reset();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public double getAngle() {
        // System.out.println("Angle:" + gyro.getAngle());
        return gyro.getAngle();
    }

    public void reset() {
        gyro.reset();
    }
}
