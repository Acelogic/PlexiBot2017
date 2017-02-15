package org.usfirst.frc.team1635.robot.subsystems;

import org.usfirst.frc.team1635.robot.Robot;
import org.usfirst.frc.team1635.robot.RobotMap;
import org.usfirst.frc.team1635.robot.commands.*;
import org.usfirst.frc.team1635.util.XboxControllerButton;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

//------------------------------------------------------------

//.---.  ,--.    .-----. .------.  
///_   | /  .'   /  -.   \|   ___|  
//|   |.  / -.  '-' _'  ||  '--.   
//|   || .-.  '    |_  < `---.  '. 
//|   |' \  |  |.-.  |  |.-   |  | 
//|   |\  `'  / \ `-'   /| `-'   / 
//`---' `----'   `----''  `----''  

/**
 * 
 * @author Bogdan Bradu & Miguel Cruz ( @Acelogic_)
 *
 */
public class ElevatorSubsystem extends Subsystem {

	CANTalon elevatorActuator ,elevatorRoller; 
	//DigitalInput limitSwitchOne, limitSwitchTwo;

	public ElevatorSubsystem() {
		super();
		elevatorActuator = new CANTalon(RobotMap.elevatorMotorCANPort);
		elevatorRoller = new CANTalon(RobotMap.elevatorRollerMotorCANPort);
		//limitSwitchOne = new DigitalInput(RobotMap.topLimitSwitchDioPort);
		//limitSwitchTwo = new DigitalInput(RobotMap.bottomLimitSwitchDioPort);
		
	}

	public void controlElevator() {
	boolean xbutton = Robot.oi.StartController().getXButton();
	boolean bButton = Robot.oi.StartController().getBButton();

		if (xbutton == true) {
			elevatorActuator.set(-0.4);
		} else if (bButton == true) {
			elevatorActuator.set(0.5);
		} else {
			elevatorStop();
		}
	}

	public void operateElevatorParams(double speed) {
		elevatorActuator.set(speed);

	}
	
	public void elevatorUpParams(double speedValue){ 
		elevatorActuator.set(speedValue);
	}
	
	public void elevatorDownParams(double speedValue){ 
		elevatorActuator.set(speedValue);
	}

	public void elevatorStop() {
		elevatorActuator.set(0);
	}
	

	public void elevatorRollerControl(){ 
		boolean RB = Robot.oi.StartController().getBumper(Hand.kRight);
		if(RB == true){ 
			elevatorRoller.set(1);
		}
		else{ 
			elevatorRoller.set(0);
		}
	}
	
	
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ControlElevator());
		

	}
}