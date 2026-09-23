package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp
public class TankDrive extends OpMode {
    private DcMotor frontRight, frontLeft, backRight, backLeft;
private double Left, Right;
    @Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
       frontLeft= hardwareMap.get(DcMotor.class, "frontLeft");
       backRight= hardwareMap.get(DcMotor.class,"backRight");
       backLeft= hardwareMap.get(DcMotor.class, "backLeft");
       frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
       backRight.setDirection(DcMotorSimple.Direction.REVERSE);
       
    }

    @Override
    public void loop() {
    Right = -gamepad1.right_stick_y;
    Left = -gamepad1.left_stick_y;
    frontRight.setPower(Right);
        frontLeft.setPower(Left);
backLeft.setPower(Left);
backRight.setPower(Right);   }
}
