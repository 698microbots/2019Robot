/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team698.robot;

import org.usfirst.frc.team698.robot.commands.PlaceHatch;
import org.usfirst.frc.team698.robot.commands.PlaceCargo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick left = new Joystick(0);
	public Joystick right = new Joystick(1);
	
	public Button trig = new JoystickButton(left, 1);
	public Button leftButton = new JoystickButton(left, 4); //intake cargo
	public Button rightButton = new JoystickButton(left, 5); //shoot cargo
	
	public OI()
	{
		trig.whenPressed(new PlaceHatch());
		leftButton.whenPressed(new PlaceCargo(false));
		rightButton.whenPressed(new PlaceCargo(true));
	}
}
