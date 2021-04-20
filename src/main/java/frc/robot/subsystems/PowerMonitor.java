package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Const;

public class PowerMonitor extends SubsystemBase{

    private PowerDistributionPanel mainPDP = new PowerDistributionPanel(Const.powerDistPanalID);

    public PowerMonitor(){

    }

    // returns total Energy Being drawn by in watts Motors and etc
    public Double getTotalDrawnEnergyInWatts(){
       return mainPDP.getTotalEnergy() / Timer.getFPGATimestamp();
    }

    // returns Current Battery Voltage
    public Double getBatteryVoltage(){
        return mainPDP.getVoltage();
    }

    public Double getTotalCurrent(){
        return mainPDP.getTotalCurrent();
    }

    // returns pdp Temp in F
    public Double getTemp(){
        return mainPDP.getTemperature() * 1.8 + 32;
    }
}
