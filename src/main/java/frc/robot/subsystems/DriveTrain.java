
/** 
 * DriveTrian's Subsystems \
 * UwU
*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Const;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {}

  public void init(){
    // Defines Motors Uwu
    WPI_VictorSPX frontRVictorSPX = new WPI_VictorSPX(Const.FrontR);
    WPI_VictorSPX frontLVictorSPX = new WPI_VictorSPX(Const.FrontL);
    WPI_VictorSPX backRVictorSPX = new WPI_VictorSPX(Const.BackR);
    WPI_VictorSPX backLVictorSPX = new WPI_VictorSPX(Const.BackL);

    SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(backLVictorSPX,frontLVictorSPX);
    SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(backRVictorSPX,frontRVictorSPX);

    DifferentialDrive drive = new DifferentialDrive(leftDriveGroup, rightDriveGroup);

    
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
