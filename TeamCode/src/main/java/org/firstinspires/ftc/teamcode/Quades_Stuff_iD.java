package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Quades_Stuff_iD {
  private DcMotor frontleft,frontright,backleft,backright;
    OpMode opmode;
    Telemetry telemetry;
    HardwareMap hardwareMap;
  private double x,y,z,max,frontRightCommand,backRightCommand,frontLeftCommand,backLeftCommand;


    public void init(OpMode opMode) {
        opmode = opMode;
        telemetry = opMode.telemetry;
        hardwareMap = opmode.hardwareMap;
        frontleft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontright = hardwareMap.get(DcMotor.class, "frontRight");
        backright = hardwareMap.get(DcMotor.class, "backRight");
        backleft = hardwareMap.get(DcMotor.class, "backLeft");
        backright.setDirection(DcMotorSimple.Direction.REVERSE);
        frontright.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void loop() {
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;
        z = gamepad1.right_stick_x;

        frontRightCommand=y-x-z;
        backRightCommand=y+x-z;
        frontLeftCommand=y+x+z;
        backLeftCommand=y-x+z;
    max=Math.max (1,frontRightCommand);
    max=Math.max (max, frontLeftCommand);
    max=Math.max (max, backLeftCommand);
    max=Math.max (max, backRightCommand);

    frontRightCommand=frontRightCommand/max;
    frontLeftCommand=frontLeftCommand/max;
    backRightCommand=backRightCommand/max;
    backLeftCommand=backLeftCommand/max;

    frontright.setPower(frontRightCommand);
    frontleft.setPower(frontLeftCommand);
    backright.setPower(backRightCommand);
    backleft.setPower(backLeftCommand);

        }
}
