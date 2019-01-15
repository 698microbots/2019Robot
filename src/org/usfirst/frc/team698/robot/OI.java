/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team698.robot;

import org.usfirst.frc.team698.robot.commands.AlignToTarget;
import org.usfirst.frc.team698.robot.commands.IntakeCargo;
import org.usfirst.frc.team698.robot.commands.Off;
import org.usfirst.frc.team698.robot.commands.ShootCargo;
import org.usfirst.frc.team698.robot.commands.PlaceHatch;

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
	
	public Button leftTrig = new JoystickButton(left, 1);
	public Button rightTrig = new JoystickButton(right, 1);
	public Button leftButton = new JoystickButton(left, 4); //intake cargo
	public Button rightButton = new JoystickButton(left, 5); //shoot cargo
	
	public OI()
	{
		leftTrig.whenPressed(new PlaceHatch());
		rightTrig.whenPressed(new AlignToTarget());
		leftButton.whenPressed(new IntakeCargo());
		leftButton.whenReleased(new Off());
		rightButton.whenPressed(new ShootCargo());
		rightButton.whenReleased(new Off());
	}
}
