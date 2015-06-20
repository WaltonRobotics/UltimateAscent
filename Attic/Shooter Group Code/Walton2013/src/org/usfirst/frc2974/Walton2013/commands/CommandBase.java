/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Walton2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Walton2013.OI;
import org.usfirst.frc2974.Walton2013.subsystems.ConveyorSystem;
import org.usfirst.frc2974.Walton2013.subsystems.DriveTrain;
import org.usfirst.frc2974.Walton2013.subsystems.ShooterSystem;

/**
 *
 * @author Michael
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain drive;
    public static ShooterSystem shooter;
    public static ConveyorSystem conveyor;

    public CommandBase() {
        oi = new OI();
        drive = new DriveTrain();
        shooter = new ShooterSystem();
        conveyor = new ConveyorSystem();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
