package org.usfirst.frc.team698.robot.commands;

import org.usfirst.frc.team698.robot.Robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignToTarget extends Command {

	NetworkTableEntry tx,ty;
	double x,y;
	double kp = 0.03;
	double thresh = 5.0;
	double sp = .1;
    public AlignToTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	tx = Robot.limelight.getEntry("tx");
    	ty = Robot.limelight.getEntry("ty");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	x = tx.getDouble(0.0);
    	y = ty.getDouble(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	x = tx.getDouble(0.0);
    	if(x >= 0)
    	{
    		Robot.drive.setRightSpeed(sp - x*kp);
        	Robot.drive.setLeftSpeed(sp + x*kp);
    	}
    	else
    	{
    		Robot.drive.setRightSpeed(sp + x*kp);
        	Robot.drive.setLeftSpeed(sp - x*kp);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	x = tx.getDouble(0.0);
    	if(Math.abs(x) <= thresh) return true;
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
