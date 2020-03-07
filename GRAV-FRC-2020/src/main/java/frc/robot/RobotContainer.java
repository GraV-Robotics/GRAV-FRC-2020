/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BasicArcadeDrive;
import frc.robot.commands.ClimberHookDownCommand;
import frc.robot.commands.ClimberHookUpCommand;
import frc.robot.commands.ClimberWinchCommand;
import frc.robot.commands.FeederSpinUpCommand;
import frc.robot.commands.IntakeCommandGroup;
import frc.robot.commands.ShifterToggleCommand;
import frc.robot.commands.ShifterToggleExecuteCommand;
import frc.robot.commands.ThrottleShiftingCommand;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Joystick driverController = new Joystick(0);
  public JoystickButton hookUp = new JoystickButton(driverController, 0);
  public JoystickButton hookDown = new JoystickButton(driverController, 1);
  public JoystickButton winchUp = new JoystickButton(driverController, 2);
  public JoystickButton feederSpinUp = new JoystickButton(driverController, 3);
  public JoystickButton shifterToggle = new JoystickButton(driverController, 4);
  public JoystickButton intakeSpinUpPivot = new JoystickButton(driverController, 5);
  Pneumatics pneumatics = new Pneumatics();
  Drivetrain drivetrain = new Drivetrain();
  Intake intake = new Intake();
  Climber climber = new Climber();
  Feeder feeder = new Feeder();
  BasicArcadeDrive basicArcadeDrive = new BasicArcadeDrive(driverController.getRawAxis(1), driverController.getRawAxis(5), drivetrain);
 
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  // hello
  private void configureButtonBindings() {
    hookUp.whileHeld(new ClimberHookUpCommand(climber));
    hookDown.whileHeld(new ClimberHookDownCommand(climber));
    winchUp.toggleWhenPressed(new ClimberWinchCommand(climber));
    feederSpinUp.whileHeld(new FeederSpinUpCommand(feeder));
    shifterToggle.toggleWhenPressed(new ShifterToggleCommand(new ThrottleShiftingCommand(drivetrain, pneumatics, driverController.getRawAxis(1), driverController.getRawAxis(5), 0.8)));
    intakeSpinUpPivot.whileHeld(new IntakeCommandGroup(intake));

  }

}
