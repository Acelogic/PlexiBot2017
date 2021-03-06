package org.usfirst.frc.team1635.robot.commands;

import org.usfirst.frc.team1635.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimeoutTankDriveParams extends Command {
	private double executionTime; 
    public TimeoutTankDriveParams(double executionTime) {
    	 this.executionTime = executionTime;
         setTimeout(executionTime);
    	requires(Robot.chassisSystem);
    }
    
   
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSystem.resetYaw();
    	Robot.pneumaticsSystem.setLowGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Robot.chassisSystem.driveWithParams(0.7, 0.7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
