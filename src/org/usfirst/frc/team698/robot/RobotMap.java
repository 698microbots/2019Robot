/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team698.robot;

import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static int 	driveRightRearMotor		= 1;
	public static int 	driveLeftRearMotor 		= 2;
	public static int 	driveRightFrontMotor	= 3;
	public static int 	driveLeftFrontMotor 	= 4;
	public static int 	cargoIntakeLeftMotor	= 9;
	public static int 	cargoIntakeRightMotor 	= 8;
	public static int 	PCMNodeID				= 0;
	public static Port	gyroPort;
	
	public static final int driveRightEncoderChannelA = 3; // TODO: CHANGE!
	public static final int driveRightEncoderChannelB = 2; // TODO: CHANGE!
	public static final int driveLeftEncoderChannelA = 1; // TODO: CHANGE!
	public static final int driveLeftEncoderChannelB = 0; // TODO: CHANGE!
	public static final int HatchSolenoidForwardPort = 0;
	public static final int HatchSolenoidReturnPort = 1;
}
