package org.usfirst.frc.team2713.robot;

import org.usfirst.frc.team2713.robot.inputs.XBoxController;




import org.usfirst.frc.team2713.robot.commands.ChangeDriveSpeed;
import org.usfirst.frc.team2713.robot.commands.ChangeLevel;
import org.usfirst.frc.team2713.robot.commands.MakeDriveCoast;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	public static XBoxController xbox;
	private JoystickButton liftUp;
	private JoystickButton liftDown;
	private JoystickButton changeDriveSpeed;
	private JoystickButton changeDriveCoast;

	public OI() {
		xbox = new XBoxController(RobotMap.XBOX_PORT);
		if (RobotMap.INIT_LIFT) {
			
			liftUp = new JoystickButton(xbox, 4);
			liftUp.whileHeld(new ChangeLevel(true));
			liftUp.whenReleased(new ChangeLevel(null));
			liftDown = new JoystickButton(xbox, 1);
			liftDown.whileHeld(new ChangeLevel(false));
			liftDown.whenReleased(new ChangeLevel(null));
			
		}
		
		changeDriveSpeed = new JoystickButton(xbox, 3);
		changeDriveSpeed.whenPressed(new ChangeDriveSpeed());
		changeDriveSpeed = new JoystickButton(xbox, 2);
		changeDriveSpeed.whenPressed(new MakeDriveCoast());
	}

	public XBoxController getXbox() {
		// TODO Auto-generated method stub
		return xbox;
	}
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
