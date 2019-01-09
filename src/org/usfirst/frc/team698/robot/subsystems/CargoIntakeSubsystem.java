package org.usfirst.frc.team698.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CargoIntakeSubsystem extends Subsystem {

    VictorSP leftmotor = new VictorSP(9);
    VictorSP rightmotor = new VictorSP(8);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake()
    {
    	leftmotor.set(-1.0);
    	rightmotor.set(1.0);
    }
    
    public void shoot()
    {
    	leftmotor.set(1.0);
    	rightmotor.set(-1.0);
    }
}

