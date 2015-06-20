package org.usfirst.frc2974.Walton2013;

/**
 *
 * @author Alex
 */
public class FrisbeeSensors {

    public static boolean spatSens;
    public static boolean midSens;
    public static boolean exitSens;
    public static boolean oldSpatSens;
    public static boolean oldMidSens;
    public static boolean oldExitSens;
    public static int frisbeeCount = 0;

    public FrisbeeSensors() {
    }

    public void getFrisbeeCount() {
        //refresh currents
        spatSens = getSpat();
        midSens = getMid();
        exitSens = getExit();

        if (!oldSpatSens && spatSens) {
            frisbeeCount++;
        }

        if (oldExitSens && !exitSens) {
            frisbeeCount--;
        }

        //refresh olds
        oldSpatSens = getSpat();
        oldMidSens = getMid();
        oldExitSens = getExit();
    }

    public boolean hasHitMidSens() {
        return (!oldMidSens && midSens);
    }

    public boolean isOffSpatula() {
        return (oldSpatSens && !spatSens);
    }

    public boolean getSpat() {
        return Robot.oi.frisbeeOnSpatulaSensor.get();
    }

    public boolean getMid() {
        return Robot.oi.midConveyorSensor.get();
    }

    public boolean getExit() {
        return Robot.oi.exitSensor.get();
    }
}
