package org.usfirst.frc.team1635.autonomous;

import org.usfirst.frc.team1635.robot.RobotMap;
import org.usfirst.frc.team1635.robot.commands.TurnToSetPointLi;
import org.usfirst.frc.team1635.robot.commands.WiggleForward;
import org.usfirst.frc.team1635.robot.commands.DriveWithVision;
import org.usfirst.frc.team1635.robot.commands.TimeoutDriveWithCorrection;
import org.usfirst.frc.team1635.robot.commands.TimeoutDriveWithCorrectionSlow;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousVisionRight extends CommandGroup {

    public AutonomousVisionRight() {
    	addSequential(new TimeoutDriveWithCorrection(RobotMap.autoRightDriveToTurn));
    	addSequential(new  TurnToSetPointLi(RobotMap.autoRightTurnLeft, false));
    	addSequential(new DriveWithVision());
		addSequential(new TimeoutDriveWithCorrectionSlow(
				RobotMap.autoVisionStraightTime
				, RobotMap.autoVisionStraightSpeed));
		addSequential(new WiggleForward());
    }
}
