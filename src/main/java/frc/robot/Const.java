
/**
 * This class is for Robot consts
 */
package frc.robot;



public class Const {
    
    /**
     * Power Distrobution Panel Canbus id
     */
    public static int powerDistPanalID = 0; 
    /**
     * THese are Victor SPX canBus ids
     */
    public static int FrontR = 1;
    public static int FrontL = 2;
    public static int BackR = 3;
    public static int BackL = 4;

    /**
     * JoyStick PortNum
     */
    public static int DriverJoystick = 0;


   
    // left stick axis's
    public static int kLeftStickX =  0;
    public static int kLeftStickY = 1;

    // Right Stick Axis's
    public static int kRightStickX = 4;
    public static int kRightStickY = 5;

    // Triggers 
    public static int kRightTrigger = 3;
    public static int kLeftTrigger = 2;

    // Buttons Bindings    
    public static int kA = 1;
    public static int kB = 2;
    public static int kX = 3;
    public static int kY = 4;

    public static int kLB = 5;
    public static int kRB = 6;

    public static int kSelect = 7;
    public static int kStart = 8;

    public static int kLeftStickPress = 9;
    public static int kRightStickPress = 10;


    //Dashboard Wigit Sizes
    public static int kRect_Width = 2;
    public static int kRect_Hight = 1;

    public static int kDial_Widht = 2;
    public static int kDial_Hight = 2;

    // Dashboard Tab Names
    public static String kDashboardTab = "TeleopDash";

    //Dashboard Widget names
    public static String accelerWidget = "3 axis Acc";
    public static String robotactiveWidget  ="Is Robot Active";
    public static String pdpPowerWidget = "PowerGraph";
    public static String temMonWidget = "Temp Widgt";
    public static String wattMonWidget = "wattEntry";
}
