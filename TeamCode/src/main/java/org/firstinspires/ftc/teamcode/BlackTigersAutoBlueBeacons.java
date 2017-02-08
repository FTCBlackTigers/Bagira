package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.lasarobotics.vision.opmode.LinearVisionOpMode;
import org.lasarobotics.vision.opmode.VisionOpMode;
/*
 * Created by user on 01/02/2017.
 */


@Autonomous(name = "BlackTigersAutoBlueBeacons", group = "BlackTigers Auto")
    public class BlackTigersAutoBlueBeacons extends LinearVisionOpMode {

    BlackTigersHardware robot = new BlackTigersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.shootingMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RobotUtilities.calibrategyro(telemetry , robot ,this);
        enableExtension(VisionOpMode.Extensions.BEACON);
        enableExtension(VisionOpMode.Extensions.ROTATION);
        enableExtension(VisionOpMode.Extensions.CAMERA_CONTROL);
        RobotUtilities.cameraSetup(this);

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.shootingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForVisionStart();

        telemetry.addData("Path0", "Starting at %7d :%7d",
                robot.leftMotor.getCurrentPosition(),
                robot.rightMotor.getCurrentPosition());
        telemetry.update();

        waitForStart();

        RobotUtilities.moveForward(RobotUtilities.normalSpeed, -52,10, this, robot, telemetry);
        RobotUtilities.gyroRotate(40, robot, telemetry, this);
        RobotUtilities.moveForward(RobotUtilities.normalSpeed, -90,10, this, robot, telemetry);
        sleep(200);
        RobotUtilities.gyroRotate(-40, robot, telemetry, this);

        boolean isBlueRight = false;
        sleep(500);
        RobotUtilities.gyroRotate(85, robot, telemetry, this);
        sleep(200);
        RobotUtilities.moveForward(RobotUtilities.normalSpeed, -60 ,10, this, robot, telemetry);
        if(!isBlueRight) {
            RobotUtilities.moveForward(RobotUtilities.normalSpeed, 20 ,10, this, robot, telemetry);
            sleep(700);
            RobotUtilities.moveForward(RobotUtilities.normalSpeed, -23 ,10, this, robot, telemetry);
        }
        RobotUtilities.moveForward(RobotUtilities.normalSpeed, 60 ,10, this, robot, telemetry);
//        shooting 2 balls

        robot.shootingMotor.setPower(0.75);

        sleep(1500);
        robot.reloadingMotor.setPower(-0.75);

        sleep(2500);
        robot.shootingMotor.setPower(0);
        robot.reloadingMotor.setPower(0);

        sleep(0500);
        RobotUtilities.gyroRotate(-82, robot, telemetry, this);
        RobotUtilities.moveForward(RobotUtilities.normalSpeed, -120 ,10, this, robot, telemetry);

        sleep(500);
        RobotUtilities.gyroRotate(85, robot, telemetry, this);
        sleep(200);
        RobotUtilities.moveForward(RobotUtilities.normalSpeed, -60 ,10, this, robot, telemetry);
        if(!isBlueRight) {
            RobotUtilities.moveForward(RobotUtilities.normalSpeed, 20 ,10, this, robot, telemetry);
            sleep(700);
            RobotUtilities.moveForward(RobotUtilities.normalSpeed, -23 ,10, this, robot, telemetry);
        }

        while (opModeIsActive()) {
            telemetry.addData("Beacon Color", beacon.getAnalysis().getColorString());
            telemetry.addData("Beacon Confidence", beacon.getAnalysis().getConfidenceString());
            telemetry.addData("Status", "Resetting Encoders");
            telemetry.update();
            waitOneFullHardwareCycle();
        }
    }
}