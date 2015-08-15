/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Walton2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Walton2013.OI;
import org.usfirst.frc2974.Walton2013.subsystems.DriveTrain;
import org.usfirst.frc2974.Walton2013.subsystems.GyroSub;
import org.usfirst.frc2974.Walton2013.subsystems.ShooterSystem;

/**
 *
 * @author Michael
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain drive;
    public static ShooterSystem shooter= new ShooterSystem();
    public static GyroSub daGyro;

    public static void init() {
        oi = new OI();
        drive = new DriveTrain();
        //shooter = new ShooterSystem();
        daGyro = new GyroSub();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
