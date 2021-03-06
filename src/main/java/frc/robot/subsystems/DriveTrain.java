
/** 
 * DriveTrian's Subsystems \
 * UwU
*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Const;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  /** Defines all the Robot DriveTrain Hardware Here to Be interfaced with the code */
  
  // Defines Motor Controllers For drivetrain
  WPI_VictorSPX frontRVictorSPX = new WPI_VictorSPX(Const.FrontR);
  WPI_VictorSPX frontLVictorSPX = new WPI_VictorSPX(Const.FrontL);
  WPI_VictorSPX backRVictorSPX  = new WPI_VictorSPX(Const.BackR);
  WPI_VictorSPX backLVictorSPX = new WPI_VictorSPX(Const.BackL);

  // Allows Motors to be Controlled as a group
  SpeedControllerGroup leftDriveGroup  = new SpeedControllerGroup(backLVictorSPX,frontLVictorSPX);
  SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(backRVictorSPX,frontRVictorSPX);
  
  DifferentialDrive drive = new DifferentialDrive(leftDriveGroup, rightDriveGroup);

  public DriveTrain() {}



	public void arcadeDrive(final double throttle, final double turn) {
		drive.arcadeDrive(throttle, turn);
	}

	public void deadbandedArcadeDrive() {
		double throttle, turn;
		if (RobotContainer.m_driverController.getRawAxis(Const.kRightStickX) > 0.1
				|| RobotContainer.m_driverController.getRawAxis(Const.kRightStickX) < -0.1) {
			if (RobotContainer.m_driverController.getRawAxis(Const.kRightStickX) < 0) {
				throttle = -Math.sqrt(Math.abs(RobotContainer.m_driverController.getRawAxis(Const.kRightStickX)));
			} else {
				throttle = Math.sqrt(RobotContainer.m_driverController.getRawAxis(Const.kRightStickX));
			}
		} else {
			throttle = 0;
		}
		/* check deadband */

		if (RobotContainer.m_driverController.getRawAxis(Const.kLeftStickY) > 0.2
				|| RobotContainer.m_driverController.getRawAxis(Const.kLeftStickY) < -0.2) {
			if (RobotContainer.m_driverController.getRawAxis(Const.kLeftStickY) < 0) {
				turn = -Math.sqrt(Math.abs(RobotContainer.m_driverController.getRawAxis(Const.kLeftStickY)));
			} else {
				turn = Math.sqrt(RobotContainer.m_driverController.getRawAxis(Const.kLeftStickY));
			}
		} else {
			turn = 0;
		}
		arcadeDrive(throttle, -turn);
	}



  /**
	 * 
	 * Sets @param Drivetrain Motor Power in a simple and Organized way
	 * 
	 * @author Luke Crumb
	 */
	public void setMotorPower(final double left, final double right) {
		frontLVictorSPX.set(left);
		backLVictorSPX.set(left);
		frontRVictorSPX.set(right);
		backRVictorSPX.set(right);
	}



	public void Straferight(final double left, final double right) {
		frontLVictorSPX.set(-left);
		backLVictorSPX.set(left);
		frontRVictorSPX.set(right);
		backRVictorSPX.set(-right);
	}



  /**
	 * Sets Motor Power to 0
	 * 
	 * @param Drivetrain
	 * @param VictorSpx
	 * 
	 * @author Nicholas Blackburn
	 */
	public void stop() {
		backLVictorSPX.set(0);
		frontLVictorSPX.set(0);
		backRVictorSPX.set(0);
		frontRVictorSPX.set(0);
	}




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
