
package org.usfirst.frc.team698.robot.commands;

import org.usfirst.frc.team698.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {

	
	double kp = SmartDashboard.getNumber("kp", .025);
	double max_thresh = .12;
	double min_thresh = .08;
    public JoystickDrive() {
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
 
    	if(Math.abs(Robot.m_oi.right.getX()) > max_thresh)
    	{
    		Robot.drive.setRightSpeed(-Robot.m_oi.right.getX());
        	Robot.drive.setLeftSpeed(Robot.m_oi.right.getX());
        	Robot.gyro.reset();
    	}
    	else if(Math.abs(Robot.m_oi.right.getX()) > min_thresh)
    	{
    		Robot.drive.setRightSpeed(0);
        	Robot.drive.setLeftSpeed(0);
    	}
    	
		double angle = Robot.gyro.getAngle();
    	//double angle = 0;
		
		Robot.drive.setRightSpeed((-Robot.m_oi.left.getY() + angle*kp)/2.5);
    	Robot.drive.setLeftSpeed((-Robot.m_oi.left.getY() - angle*kp)/2.5);

    	SmartDashboard.putNumber("Left Speed", (Robot.m_oi.left.getY() + angle*kp)/2.5);
    	SmartDashboard.putNumber("Right Speed", (Robot.m_oi.left.getY() - angle*kp)/2.5);
    	SmartDashboard.putNumber("Angle", Robot.gyro.getAngle());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.setRightSpeed(0);
    	Robot.drive.setLeftSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}