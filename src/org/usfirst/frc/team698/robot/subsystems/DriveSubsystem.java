package org.usfirst.frc.team698.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team698.robot.RobotMap;
import org.usfirst.frc.team698.robot.commands.DriveForward;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode; 
/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final TalonSRX driveRightRearMotor = new TalonSRX(RobotMap.driveRightRearMotor);
	private static final TalonSRX driveRightFrontMotor = new TalonSRX(RobotMap.driveRightFrontMotor);
	private static final TalonSRX driveLeftRearMotor = new TalonSRX(RobotMap.driveLeftRearMotor);
	private static final TalonSRX driveLeftFrontMotor = new TalonSRX(RobotMap.driveLeftFrontMotor);
	
	private final static boolean rightEncoderInverted = false;
	private final static boolean leftEncoderInverted = false;
	private static final Encoder driveRightEncoder = new Encoder(RobotMap.driveRightEncoderChannelA, RobotMap.driveRightEncoderChannelB, rightEncoderInverted);
	private static final Encoder driveLeftEncoder = new Encoder(RobotMap.driveLeftEncoderChannelA, RobotMap.driveLeftEncoderChannelB, leftEncoderInverted);

    public void initDefaultCommand() {
        setDefaultCommand(new DriveForward());
    }
    /**
	 * Set the speed of the two right motors
	 * @param speed between -1 and 1
	 */
	public void setRightSpeed(double speed) {
		if(speed<-1) speed =-1;
		if(speed>1) speed=1;
		driveRightRearMotor.set(ControlMode.PercentOutput,speed);
		driveRightFrontMotor.set(ControlMode.PercentOutput,speed);
	}
	
	/**
	 * Set the speed of the two left motors
	 * @param speed between -1 and 1
	 */
	public void setLeftSpeed(double speed) {
		if(speed<-1) speed =-1;
		if(speed>1) speed=1;
		driveLeftRearMotor.set(ControlMode.PercentOutput,speed);
		driveLeftFrontMotor.set(ControlMode.PercentOutput,speed);
	}
}
