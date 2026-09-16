package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveTrainAuto {
    LinearOpMode opmode;
    Telemetry telemetry;
    private DcMotor frontRight,frontLeft,backRight,backLeft;
    HardwareMap HardwareMap;
    public void init(LinearOpMode opMode){
    opmode = opMode;
    telemetry = opmode.telemetry;
    HardwareMap = opmode.hardwareMap;

    frontRight=HardwareMap.get(DcMotor.class, "frontRight");
    frontLeft=HardwareMap.get(DcMotor.class,"frontLeft");
    }
}
