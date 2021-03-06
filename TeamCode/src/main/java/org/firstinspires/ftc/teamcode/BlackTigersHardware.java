package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class BlackTigersHardware {
    //    Here we define our motors and our sensors we will use
    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;
    public DcMotor collectionMotor = null;
    public DcMotor reloadingMotor = null;
    public DcMotor shootingMotor = null;
    public DcMotor ballMotorLeft = null;
    public DcMotor ballMotorRight = null;
    public GyroSensor gyro = null;

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // we set their names
        leftMotor = hwMap.dcMotor.get("left_drive");
        rightMotor = hwMap.dcMotor.get("right_drive");
        collectionMotor = hwMap.dcMotor.get("collection_motor");
        reloadingMotor = hwMap.dcMotor.get("reloading_motor");
        shootingMotor = hwMap.dcMotor.get("shooting_motor");
        ballMotorRight = hwMap.dcMotor.get("ball_motor_right");
        ballMotorLeft = hwMap.dcMotor.get("ball_motor_left");
        gyro = hwMap.gyroSensor.get("gyro");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        collectionMotor.setDirection(DcMotor.Direction.REVERSE);
        reloadingMotor.setDirection(DcMotor.Direction.REVERSE);
        shootingMotor.setDirection(DcMotor.Direction.FORWARD);
        ballMotorRight.setDirection(DcMotor.Direction.REVERSE);
        ballMotorLeft.setDirection(DcMotor.Direction.REVERSE);

        //we use the ZeroPowerBehavior.FLOAT so that the motor will decelerate slowly and wont break
        // because of the high speed.
        shootingMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        collectionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        reloadingMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ballMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ballMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // we set the basic power to 0
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        collectionMotor.setPower(0);
        reloadingMotor.setPower(0);
        shootingMotor.setPower(0);
        ballMotorRight.setPower(0);
        ballMotorLeft.setPower(0);

        // we pich witch of our motors will run with encoders and wich wont.
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shootingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        reloadingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        collectionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        collectionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ballMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ballMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}

