package org.usfirst.frc.team698.robot.commands;

import org.usfirst.frc.team698.robot.Robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AlignToTarget extends Command {

	NetworkTableEntry tx,ty,ta,tv;
	double x,y,a;
	double kp = SmartDashboard.getNumber("kp", .025);
	double thresh = 1.8;
	double sp_max = .5;
	double sp = 0.3;
	NetworkTableEntry light_state = Robot.limelight.getEntry("ledMode");
    public AlignToTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	tx = Robot.limelight.getEntry("tx");
    	ty = Robot.limelight.getEntry("ty");
    	ta = Robot.limelight.getEntry("ta");
    	tv = Robot.limelight.getEntry("tv");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	light_state.setNumber(3);
    	
    	Timer.delay(.5);
    	x = tx.getDouble(0.0);
    	y = ty.getDouble(0.0);
    	a = ta.getDouble(0.0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	x = tx.getDouble(0.0);
    	a = ta.getDouble(0.0);
    	
    	if(x > 0)
    	{
    		//x = Math.abs(x);
    		Robot.drive.setRightSpeed(Math.max(((sp - x*kp)<sp_max?(sp - x*kp):sp_max)/(a),0));
        	Robot.drive.setLeftSpeed(Math.min((sp + x*kp)/(a), sp_max));
        	
        	SmartDashboard.putNumber("right speed",Math.max(((sp - x*kp)<sp_max?(sp - x*kp):sp_max)/(a),0));
        	SmartDashboard.putNumber("left speed",Math.min((sp + x*kp)/(a), sp_max));
    	}
    	else
    	{
    		x=Math.abs(x);
    		Robot.drive.setRightSpeed(Math.min((sp + x*kp)/(a), sp_max));
    		Robot.drive.setLeftSpeed(Math.max(((sp - x*kp)<sp_max?(sp - x*kp):sp_max)/(a),0));
        	
    		SmartDashboard.putNumber("right speed",Math.min((sp + x*kp)/(a), sp_max));
        	SmartDashboard.putNumber("left speed",Math.max(((sp - x*kp)<sp_max?(sp - x*kp):sp_max)/(a),0));
    	}
    	SmartDashboard.putNumber("ta",a);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	a = ta.getDouble(0.0);
    	if(a >= thresh)
    	{
    		Robot.drive.setLeftSpeed(0);
    		Robot.drive.setRightSpeed(0);
    		return true;
    	}
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//light_state.setNumber(1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
