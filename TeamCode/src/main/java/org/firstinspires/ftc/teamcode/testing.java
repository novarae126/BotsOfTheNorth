package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//@TeleOp
public class testing extends OpMode {

    private DcMotor frontleft,frontright,backleft,backright;

    @Override
    public void init() {
        frontleft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontright = hardwareMap.get(DcMotor.class, "frontRight");
        backright = hardwareMap.get(DcMotor.class, "backRight");
        backleft = hardwareMap.get(DcMotor.class, "backLeft");
    }

    @Override
    public void loop() {
        telemetry.addData("frontLeft", frontleft.getCurrentPosition());
        telemetry.addData("backLeft",backleft.getCurrentPosition());
        telemetry.addData("backRight",backright.getCurrentPosition());
        telemetry.addData("frontright", frontright.getCurrentPosition());
    }// backleft - back right- front left+ frontright+
}
