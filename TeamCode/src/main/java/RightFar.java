import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.OwenMadeAuton;

@Autonomous
public class RightFar extends LinearOpMode {

    private OwenMadeAuton auton = new OwenMadeAuton();

    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        auton.init(this);
        waitForStart();
        auton.Shoot();
        auton.backward(2, 0.5);
        auton.transfer();
        Thread.sleep(1000);
        auton.intake();
        Thread.sleep(10000);
        auton.transferStop();
        auton.intakeStop();
        auton.backward(6, 0.3);
        auton.right(80, 0.25);
        auton.left(22, 0.3);
        auton.backward(114, 0.3);
        auton.right(24, 0.25);
        auton.forward(6, 0.25);
        auton.left(10, 0.3);

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();


        while (opModeIsActive()) {
            orientation = imu.getRobotYawPitchRollAngles();
            telemetry.addData("orientation", orientation);
            telemetry.update();
            Thread.sleep(10);
        }
    }

}
