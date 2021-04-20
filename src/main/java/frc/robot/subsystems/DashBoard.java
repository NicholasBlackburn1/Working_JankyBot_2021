package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Const;
import frc.robot.Robot;

public class DashBoard extends SubsystemBase{
    
    /**
     * Defines The local Defs of Vars 
    */
    private DriveTrain driveTrain;  
    private PowerMonitor powerMonitor;

    // network Table entry for Grabbing daat from robot
    private NetworkTableEntry accEntry;
    private NetworkTableEntry robotEnabledEntry;
    private NetworkTableEntry robotvoltageEntry;
    private NetworkTableEntry tempEntry;
    private NetworkTableEntry wattentry;
    

    

    // Public Constructor to Allow Class access The active driveTrain Instances
    public DashBoard(DriveTrain driveTrainn, PowerMonitor mon){
        this.driveTrain = driveTrain;
        this.powerMonitor = mon;
        initTeleopDashboardTab();
    }


    /**
     * This Defines Whole Shuffleboard Dashboard Teleop tab and Holds all the Wigets added to Dash
     */
    public void initTeleopDashboardTab(){
        // Reports to Driver Station that Dashboard is Enabled!
        DriverStation.reportWarning("[Nicholas's DashBoard]" + "Dashboard Initing",false);
        
        final ShuffleboardTab Teleop_Dashboard = Shuffleboard.getTab(Const.kDashboardTab);
        
        // This is the Boolean for Displaying if robot is active
        this.robotEnabledEntry = Teleop_Dashboard.add(Const.robotactiveWidget, 0).withPosition(0, 0).withSize(Const.kRect_Width, Const.kRect_Hight).withWidget(BuiltInWidgets.kBooleanBox).getEntry();
        
        this.robotvoltageEntry = Teleop_Dashboard.add(Const.pdpPowerWidget, 0).withPosition(0, 1).withSize(Const.kDial_Widht, Const.kDial_Hight).withWidget(BuiltInWidgets.kDial).getEntry();

        this.wattentry = Teleop_Dashboard.add(Const.wattMonWidget, 0).withPosition(0, 2).withSize(Const.kDial_Widht, Const.kDial_Hight).withWidget(BuiltInWidgets.kDial).getEntry();

        this.tempEntry = Teleop_Dashboard.add(Const.temMonWidget, 0).withPosition(4, 2).withSize(Const.kDial_Widht, Const.kDial_Hight).withWidget(BuiltInWidgets.kDial).getEntry();
    }


    public void refreshDashData(){
        
        
        this.robotEnabledEntry.setBoolean(Robot.inRobot);

        this.robotvoltageEntry.setDouble(powerMonitor.getBatteryVoltage());

        this.wattentry.setDouble(powerMonitor.getTotalDrawnEnergyInWatts());

        this.tempEntry.setDouble(powerMonitor.getTemp());
    }


}