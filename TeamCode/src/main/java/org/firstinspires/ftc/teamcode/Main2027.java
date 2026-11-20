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
        robot.intake(gamepad1.left_trigger > 0.5,  gamepad1.left_bumper);
        robot.transfer(gamepad1.right_trigger > 0.5);
        robot.shoot(true);
        //robot.shoot(gamepad1.dpad_up, gamepad1.dpad_down);
        robot.transfer(gamepad1.right_trigger > 0.5);
    }
}
