package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_Quadestuff2 {
    OpMode opmode;
    Telemetry telemetry;
    private DcMotor intake;
    HardwareMap hardwareMap;
    public void init(OpMode opMode){
        opmode=opMode;
telemetry=opmode.telemetry;
hardwareMap=opmode.hardwareMap;
 intake = hardwareMap.get(DcMotor.class, "Intake");
}
public void runIntake(boolean pressed){
        if (pressed){
            intake.setPower(1);
        }
        else{
            intake.setPower(0);
        }
}
}
