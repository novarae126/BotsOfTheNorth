package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    OpMode opmode;
    Telemetry telemetry;
    HardwareMap hardwareMap;
    //private final ShooterTest shooterTest = new ShooterTest();
    private final Quades_Stuff_iD  quades_stuff_iD = new Quades_Stuff_iD();
    //private final Intake_Quadestuff2 intake_quadestuff2 = new Intake_Quadestuff2();


    public void init(OpMode opMode) {
    opmode = opMode;
    telemetry=opmode.telemetry;
    hardwareMap = opmode.hardwareMap;
    //shooterTest.init(opMode);
    quades_stuff_iD.init(opMode);
    //intake_quadestuff2.init(opMode);
    }
    public void shoot(boolean pressed){
        //shooterTest.shoot(pressed);
    }
    public void drive(double x, double y, double z){
        quades_stuff_iD.loop(x,y,z);
    }

}
