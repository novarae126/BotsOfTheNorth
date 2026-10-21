import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.OwenMadeAuton;
@Autonomous
public class Auton2026 extends LinearOpMode {

    private OwenMadeAuton auton = new OwenMadeAuton();

    //private TeleOp teleOp = new TeleOp();
    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        auton.init(this);
        //teleOp.init(this);
        waitForStart();

        auton.forward(36, .3);
        auton.right(12, 1);
        auton.backward(36, .5);
        auton.left(12, 1);
        auton.turnLeft(360, .5);
        auton.turnRight(360, .5);

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();


        while (opModeIsActive()) {
            orientation = imu.getRobotYawPitchRollAngles();
            telemetry.addData("orientation", orientation);
            telemetry.update();
            wait(10);
        }
    }
}
