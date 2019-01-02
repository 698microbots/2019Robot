package org.usfirst.frc.team698.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team698.robot.Robot;
import org.usfirst.frc.team698.robot.subsystems.DriveSubsystem;

/**
 *
 */
public class DriveForward extends Command {

	double kp = 0.03;
    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.gyro.getAngle();
    	Robot.drive.setRightSpeed(Robot.m_oi.left.getY() - angle*kp);
    	Robot.drive.setLeftSpeed(Robot.m_oi.left.getY() + angle*kp);
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
