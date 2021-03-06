package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.SubsystemStorage;
import org.usfirst.frc.team2713.robot.UniversalController;
import org.usfirst.frc.team2713.robot.commands.MoveGrabber;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {

	public UniversalController grab;
	MoveGrabber graberCommand;
	public DigitalInput armClosed;
	public DigitalInput armClosed2;
	SubsystemStorage base;

	public GrabberSubsystem(SubsystemStorage base) {
		this.base = base;
		if (RobotMap.INIT_GRAB) {
			grab = new UniversalController(RobotMap.GRAB_MOTOR, false);
			if (armClosed == null) {
				armClosed = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_NUM);
			}
			if (armClosed2 == null) {
				armClosed2 = new DigitalInput(RobotMap.ARM2_LIMIT_SWITCH_NUM);
			}
		}
	}

	public void startCommand() {
		if (RobotMap.INIT_GRAB) {
			new MoveGrabber(base).start();
		}
	}

	protected void initDefaultCommand() {

	}

	public void setLift(double polarity) {
		grab.getProperController().set(polarity);
	}

	public double getAmps() {
		return ((CANJaguar) grab.getProperController()).getBusVoltage();
	}

	public double getRaw() {
		return ((Talon) grab.getProperController()).getRaw();
	}

}
