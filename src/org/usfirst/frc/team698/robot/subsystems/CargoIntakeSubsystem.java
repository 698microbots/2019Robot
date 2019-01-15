package org.usfirst.frc.team698.robot.subsystems;

import org.usfirst.frc.team698.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CargoIntakeSubsystem extends Subsystem {

    VictorSP leftmotor = new VictorSP(RobotMap.cargoIntakeLeftMotor);
    VictorSP rightmotor = new VictorSP(RobotMap.cargoIntakeRightMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake()
    {
    	leftmotor.set(-0.3);
    	rightmotor.set(0.3);
    }
    
    public void shoot()
    {
    	leftmotor.set(0.3);
    	rightmotor.set(-0.3);
    }
    
    public void off()
    {
    	leftmotor.set(0.0);
    	rightmotor.set(0.0);
    }
}

