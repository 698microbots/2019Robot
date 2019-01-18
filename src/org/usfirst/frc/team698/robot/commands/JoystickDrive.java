package org.usfirst.frc.team698.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team698.robot.Robot;
import org.usfirst.frc.team698.robot.subsystems.DriveSubsystem;

/**
 *
 */
public class JoystickDrive extends Command {

	double kp = 0.01;
    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.right.getY() != 0)
    	{
    		Robot.drive.setRightSpeed(Robot.m_oi.right.getY());
        	Robot.drive.setLeftSpeed(-Robot.m_oi.right.getY());
        	//Robot.gyro.reset();
    	}
		//double angle = Robot.gyro.getAngle();
    	
    	/*if(Robot.m_oi.left.getX() >= 0)
    	{
    		Robot.drive.setRightSpeed(Robot.m_oi.left.getX() );
        	Robot.drive.setLeftSpeed(Robot.m_oi.left.getX() );
    	}*/
    	else
    	{
    		Robot.drive.setRightSpeed(Robot.m_oi.left.getX() );
        	Robot.drive.setLeftSpeed(Robot.m_oi.left.getX() );
    	}
    	double angle = 0;
    	SmartDashboard.putNumber("right drive", -Robot.drive.getRightSpeed());
    	SmartDashboard.putNumber("left drive speed", Robot.drive.getLeftSpeed());
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
    }
}
