package org.usfirst.frc.team1635.autonomous;

import org.usfirst.frc.team1635.robot.RobotMap;
import org.usfirst.frc.team1635.robot.commands.TurnToSetPointLi;
import org.usfirst.frc.team1635.robot.commands.WiggleForward;
import org.usfirst.frc.team1635.robot.commands.TimeoutDriveWithCorrection;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousRight extends CommandGroup {

    public AutonomousRight() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new TimeoutDriveWithCorrection(RobotMap.autoRightDriveToTurn));
    	addSequential(new  TurnToSetPointLi(RobotMap.autoRightTurnLeft, false));
    	addSequential(new TimeoutDriveWithCorrection(RobotMap.autoRightDriveToGearHolder));
		addSequential(new WiggleForward());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
