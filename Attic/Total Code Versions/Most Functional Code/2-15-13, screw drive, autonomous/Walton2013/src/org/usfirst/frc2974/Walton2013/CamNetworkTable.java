/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Walton2013;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import org.usfirst.frc2974.Walton2013.commands.CommandBase;

/**
 *
 * @author waltonrobotics
 */
public class CamNetworkTable {

    static NetworkTable netTable = NetworkTable.getTable("SmartDashboard");
    public static double x = 310; // half of 320
    public static double y = 240; // half of 240
    public static double distance = 0;

    public static void update() {
        try {
            x = netTable.getNumber("COG_X");
            y = netTable.getNumber("COG_Y");
            distance = netTable.getNumber("Distance");
            //netTable.putBoolean("ReadyToFire", isReady());
        } catch (TableKeyNotDefinedException e) {
        }
        //print();
    }

    static public void print() {
        //System.out.println("X: " + x);
        //System.out.println("Y: " + y);
    }
//    public static double getX() {
//        return x;
//    }
//    public static boolean isReady() {
//        if (Math.abs(CommandBase.oi.ds.getBatteryVoltage() - oldVolts) < .2) {
//            oldVolts = CommandBase.oi.ds.getBatteryVoltage();
//            return true;
//        } else {
//            oldVolts = CommandBase.oi.ds.getBatteryVoltage();
//            return false;
//        }
//
//    }
//    public static double getY() {
//        return y;
//    }
}
