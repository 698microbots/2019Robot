package org.usfirst.frc.team698.robot.subsystems;

import org.usfirst.frc.team698.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HatchIntakeSubsystem extends Subsystem {

	Solenoid HatchSolenoid = new Solenoid(RobotMap.HatchSolenoidPort);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extendPiston()
    {
    	HatchSolenoid.set(true);
    }
    
    public void retractPiston()
    {
    	HatchSolenoid.set(false);
    }
}

