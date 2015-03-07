package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class pauseCommand extends commandBase{

	double time;
	Timer timer;
	
	public pauseCommand(double Time){
		timer = new Timer();
		time = Time;
		timer.reset();
		timer.start();
	}
	
	protected void initialize() {
		timer.reset();
		timer.start();
	}
	
	protected void execute() {

	}
	
	protected boolean isFinished() {
		if (timer.get() > time) {
			return true;
		}
		return false;

	}
	
}
