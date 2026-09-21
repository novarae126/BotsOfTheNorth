package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp
public class Marcus_Mecanum_Drive extends OpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private double x,y,z,max,frontRightCommand,frontLeftCommand, backRightCommand, backLeftCommand;
    @Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        x=gamepad1.left_stick_x;
        y=gamepad1.left_stick_y;
        z=gamepad1.right_stick_x;

        frontLeftCommand = y+x+z;
        backLeftCommand = y-x+z;
        frontRightCommand = y-x-z;
        backRightCommand = y+x-z;
    max=Math.max(1,frontRightCommand);
    max=Math.max(max, frontLeftCommand);
    max=Math.max(max,backRightCommand);
    max=Math.max(max,backLeftCommand);

    frontRightCommand = frontRightCommand/max;
    frontLeftCommand = frontLeftCommand/max;
    backRightCommand = backRightCommand/max;
    backLeftCommand = backLeftCommand/max;
    frontRight.setPower(frontRightCommand);
    backRight.setPower(backRightCommand);
    frontLeft.setPower(frontLeftCommand);
    backLeft.setPower(backLeftCommand);
    }
}
