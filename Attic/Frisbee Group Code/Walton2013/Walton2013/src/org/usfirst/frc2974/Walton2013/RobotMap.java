// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Walton2013;

import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static Talon frisbeeRollerFrisbeeRoller;
    public static Talon conveyorMotor;
    public static Talon elevateTalon;
    //
    public static Relay spatulaSpike;
    public static Relay loadSpike;
    //
    public static CANJaguar driveTrainrearRightTalon;
    public static CANJaguar driveTrainfrontRightTalon;
    public static CANJaguar driveTrainfrontLeftTalon;
    public static CANJaguar driveTrainrearLeftTalon;
    public static CANJaguar shootershooterJag;
    //*****************************
    // Talons
    public static final int FRISBEE_ROLLER_CHANNEL = 1;
    public static final int CONV_MOTOR_CHANNEL = 2;
    public static final int ELEVATE_TALON = 3;
    // Spikes
    public static final int SPATULA_SPIKE_CHANNEL = 1;
    public static final int LOADER_SPIKE = 2;
    // CAN Jags
    public static final int REAR_RIGHT_JAG_CHANNEL = 11;
    public static final int FRONT_RIGHT_JAG_CHANNEL = 12;
    public static final int REAR_LEFT_JAG_CHANNEL = 13;
    public static final int FRONT_LEFT_JAG_CHANNEL = 14;
    public static final int SHOOTER_JAG_CHANNEL = 15;
    public static final int SPATULA_SENSOR = 3;
    public static final int STOP_SENSOR = 4;
    public static final int CONVEYOR_SENSOR = 5;
    public static final int HOPPER_SENSOR = 6;
    public static final int potentiometer = 1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        frisbeeRollerFrisbeeRoller = new Talon(FRISBEE_ROLLER_CHANNEL);

        conveyorMotor = new Talon(CONV_MOTOR_CHANNEL);

        elevateTalon = new Talon(ELEVATE_TALON);

        spatulaSpike = new Relay(SPATULA_SPIKE_CHANNEL);

        loadSpike = new Relay(LOADER_SPIKE);

        try {
            driveTrainrearRightTalon = new CANJaguar(REAR_RIGHT_JAG_CHANNEL);

            driveTrainfrontRightTalon = new CANJaguar(FRONT_RIGHT_JAG_CHANNEL);

            driveTrainfrontLeftTalon = new CANJaguar(FRONT_LEFT_JAG_CHANNEL);

            driveTrainrearLeftTalon = new CANJaguar(REAR_LEFT_JAG_CHANNEL);

            shootershooterJag = new CANJaguar(SHOOTER_JAG_CHANNEL);

        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
