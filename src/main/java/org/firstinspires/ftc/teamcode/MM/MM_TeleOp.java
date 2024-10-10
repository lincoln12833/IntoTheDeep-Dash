package org.firstinspires.ftc.teamcode.MM;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MM.MM_OpMode;

@TeleOp(name="TeleOp", group="mm")
public class MM_TeleOp extends MM_OpMode {
    @Override
    public void runProcedures(){
        while(opModeIsActive()){
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

            robot.drivetrain.driveWithSticks();
        }

    }
}
