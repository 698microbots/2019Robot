package org.usfirst.frc.team698.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team698.robot.Robot;
import org.usfirst.frc.team698.robot.subsystems.HatchIntakeSubsystem;
/**
 *
 */
public class PlaceHatch extends Command {

    public PlaceHatch()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hatchIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.hatchIntake.retractPiston();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
