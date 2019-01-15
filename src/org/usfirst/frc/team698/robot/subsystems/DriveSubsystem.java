package org.usfirst.frc.team698.robot.subsystems;

import org.usfirst.frc.team698.robot.RobotMap;
import org.usfirst.frc.team698.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem; 
/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final Spark driveRightRearMotor = new Spark(RobotMap.driveRightRearMotor);
	private static final Spark driveRightFrontMotor = new Spark(RobotMap.driveRightFrontMotor);
	private static final Spark driveLeftRearMotor = new Spark(RobotMap.driveLeftRearMotor);
	private static final Spark driveLeftFrontMotor = new Spark(RobotMap.driveLeftFrontMotor);
	
	private final static boolean rightEncoderInverted = false;
	private final static boolean leftEncoderInverted = false;
	private static final Encoder driveRightEncoder = new Encoder(RobotMap.driveRightEncoderChannelA, RobotMap.driveRightEncoderChannelB, rightEncoderInverted);
	private static final Encoder driveLeftEncoder = new Encoder(RobotMap.driveLeftEncoderChannelA, RobotMap.driveLeftEncoderChannelB, leftEncoderInverted);

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    /**
	 * Set the speed of the two right motors
	 * @param speed between -1 and 1
	 */
	public void setRightSpeed(double speed) {
		if(speed<-1) speed =-1;
		if(speed>1) speed=1;
		driveRightRearMotor.set(speed);
		driveRightFrontMotor.set(speed);
	}
	
	/**
	 * Set the speed of the two left motors
	 * @param speed between -1 and 1
	 */
	public void setLeftSpeed(double speed) {
		if(speed<-1) speed =-1;
		if(speed>1) speed=1;
		driveLeftRearMotor.set(speed);
		driveLeftFrontMotor.set(speed);
	}
}

