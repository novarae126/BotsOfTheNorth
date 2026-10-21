package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Main2027 extends OpMode {
    private Robot robot;
    double x, y, z;
    @Override
    public void init() {
        robot = new Robot();
        robot.init(this);
    }

    @Override
    public void loop() {
        x = - gamepad1.left_stick_x;
        y = - gamepad1.left_stick_y;
        z = gamepad1.right_stick_x;
        robot.drive(x,y,z);
    }
}
