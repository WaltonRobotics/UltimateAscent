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
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc2974.Walton2013.RobotMap;
import org.usfirst.frc2974.Walton2013.commands.AimAndShoot;

/**
 *
 */
public class ShooterSystem extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    CANJaguar shooterJag = RobotMap.shooterJaguar;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Timer time = new Timer();
    private Talon elevate = RobotMap.elevate;
    private Talon pusher = RobotMap.fireTalon;
    private AnalogChannel potentiometer = RobotMap.potentiometer;
    private double currentAngle = 0;
    private final double MAX_DEGREES = 30.0;
    private final double MIN_DEGREES = 1.0;
    private final double MAX_VOLTAGE = 0.0;
    private final double MIN_VOLTAGE = 1.0;
    private final double ANGLE_CHANGE_RATE = .33;
    private final long PUSHER_DELAY = 1;
    //degreeFromVoltage is the calculated value of one degree when given the
    //above final values.  This is convienient because it allows us to not
    //calculate the same variable every time the current angle of the shooter
    //is calculated.
    private final double DEGREE_FROM_VOLTAGE =
            (MAX_VOLTAGE - MIN_VOLTAGE) / (MAX_DEGREES - MIN_DEGREES);
    private double pOut;
    private double pGain = 0;
    private double iGain = 0;
    private double kErr;
    private double iOut;
    private double prevIErr;
    /*private PIDController pid = 
            new PIDController(pGain, iGain, 0.0, potentiometer, elevate);*/
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new AimAndShoot()); //driver cont, 0 angle, half wheel, don't shoot
    }

    /**
     * The method name says it all
     *
     * @param speed The double to be inputted to the shooter's Jaguar
     */
    public void spinUpWheel(double speed) {
        try {
            //turn on wheel
            shooterJag.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Checks if the shooter wheel is to max speed
     *
     * @return True if the wheel is at max speed, false if it isn't
     */
    public boolean isWheelToSpeed() {
        try {
            //check if the shooter wheel is up to full speed
            if (Math.abs(shooterJag.getSpeed() - 1) < 0.0001) {
                return true;
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    /*public double getPID(){//If better way to display, please, be my guest and
        //make it work.
        return pid.get();
    }*/
    public void setPID(double current, double target) {
        //<P>
        kErr = target - current;
        pOut = pGain * kErr;
        //</P>

        //<I>
        prevIErr = prevIErr + kErr;
        iOut = iGain * prevIErr;;
        //</I>
        try {
            shooterJag.setPID(pOut, iOut, 0.0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }

    public void shoot() /*throws InterruptedException*/ { //shoot a frisbee
        if (isWheelToSpeed()) {
            try {
                /* @Rishi
                 add code using the "pusher" Talon
                 ex.*/
                pusher.set(1.0);
                time.wait(PUSHER_DELAY);
                pusher.set(-1.0);
                time.wait(PUSHER_DELAY);
                pusher.set(0);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void setIGain(double gain) {
        iGain = gain;
    }
    
    /**
     * Implemented to calculate the proportional gain for PID. Many difficulties
     * occurred, so this will temporarily be ignored
     * @param gain 
     */
    public void setPGain(double gain) {
        pGain = gain;
    }

    /**
     * Raises the angle of the shooter mechanism
     */
    public void angleUp() { //put shooter angle up
        if (getCurrentAngle() < MAX_DEGREES) {
            elevate.set(ANGLE_CHANGE_RATE);//Lower rate of change to give more reaction time
        }        //To stop the motor at a desired level;
        /*
         * @Rishi alternate method with double parameter to adjust sensitivity
         * putAngleUp(double change)
         *elevate.set(getCurrentAngle()+change);
         */
    }

    /**
     * Lowers the angle of the shooter mechanism
     */
    public void angleDown() { //put shooter angle down
        if (getCurrentAngle() > MIN_DEGREES) {
            elevate.set(-ANGLE_CHANGE_RATE);//Lower rate of change to give more reaction time
        }        //To stop the motor at a desired level;

        /*
         * @Rishi alternate method with double parameter to adjust sensitivity
         *putAngleDown(double change)
         *elevate.set(getCurrentAngle()-change);
         */
    }

    /**
     * Stops the jaguar associated with the shooter mechanism so the angle stops
     * changing, hence the method name
     */
    public void stopChangingAngle() { //stop changing angle of shooter
        elevate.stopMotor();
    }

    /**
     * @return The current angle of the shooter mechanism
     */
    public double getCurrentAngle() {
        double inVoltage = potentiometer.getVoltage();
        double currentDegrees = inVoltage / DEGREE_FROM_VOLTAGE;
        return currentDegrees;
    }
    
    /**
     * Method is actually dependant upon to-be-determined variables, and
     * therefore, is not entirely known if it'll work.
     *
     * @param angle The desired shooter angle
     */
    public void setAngle(double angle) {
        //Calculations
        boolean isSet = false;
        while (currentAngle < angle && !isSet) {
            angleUp();
            currentAngle = getCurrentAngle();
            if (currentAngle > angle) {
                stopChangingAngle();
                isSet = true;
            }
        }
        while ((currentAngle > angle && !(angle < 0)) && !isSet) {
            angleDown();
            currentAngle = getCurrentAngle();
            if (currentAngle < angle) {
            }
        }
        //Dashboard message confirming angle has been
    }
}
