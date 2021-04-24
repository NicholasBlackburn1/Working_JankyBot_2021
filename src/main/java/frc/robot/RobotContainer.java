// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DashBoard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PowerMonitor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final PowerMonitor m_PowerMonitor = new PowerMonitor();
  private final DashBoard m_DashBoard = new DashBoard(m_driveTrain,m_PowerMonitor);

  // Creates JoyStick Obj
  public static Joystick m_driverController = new Joystick(Const.DriverJoystick);
  public static JoystickButton m_Strafe_right,m_Strafe_left;

  
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    /**
     * This makes drive train Runnable at default  UwU
     * @author A Software dev Uwu
     */
    m_driveTrain.setDefaultCommand(new RunCommand(() -> m_driveTrain.deadbandedArcadeDrive(), m_driveTrain));
    m_DashBoard.setDefaultCommand(new RunCommand(() -> m_DashBoard.refreshDashData(), m_DashBoard));

    m_Strafe_right.whileActiveContinuous(new RunCommand(() -> m_driveTrain.Straferight(Const.strafePower, Const.strafePower), m_driveTrain));
    m_Strafe_left.whileActiveContinuous(new RunCommand(() -> m_driveTrain.Strafeleft(Const.strafePower, Const.strafePower), m_driveTrain));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    m_Strafe_left = new JoystickButton(m_driverController, Const.kLB);
    m_Strafe_right = new JoystickButton(m_driverController,Const.kRB);
  }


}
