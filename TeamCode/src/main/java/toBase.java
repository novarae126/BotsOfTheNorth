import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.OwenMadeAuton;
//@Autonomous
public class toBase extends LinearOpMode {

    private OwenMadeAuton auton = new OwenMadeAuton();

    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        auton.init(this);
        waitForStart();

        auton.forward(8,0.5);

        while (opModeIsActive()) {
            telemetry.update();
            Thread.sleep(10);
        }
    }
}
