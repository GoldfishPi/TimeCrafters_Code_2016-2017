package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInitContainer;
import org.timecrafters.team.gfp.jewls.states.arm.servo.gfp_jewlsArmServo;
import org.timecrafters.team.gfp.jewls.states.ballcapture.gfp_ballCapture;
import org.timecrafters.team.gfp.jewls.states.drive.driveToColor.gfp_jewlsDriveToRed;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveBackEncoders;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveForwardEncoders;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.turn.gfp_jewlsDriveEncodersRotateLeft;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.turn.gfp_jewlsDriveEncodersRotateRight;
import org.timecrafters.team.gfp.jewls.states.drive.sensors.gfp_jewlsDriveBalance;
import org.timecrafters.team.gfp.jewls.states.forks.gfp_jewlsDeploy;
import org.timecrafters.team.gfp.jewls.states.logic.gfp_jewlsSleep;
import org.timecrafters.team.gfp.jewls.states.servo.gfp_jewlsButtonPress;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsShoot;
import org.timecrafters.team.gfp.jewls.states.winch.gfp_jewlsWinch;

/**
 * Created by t420 on 2/4/2017.
 */

@Autonomous(name = "JewlsRed", group = "jewls")
public class gfp_jewlsRed extends Engine {

    Container container = new Container();

    @Override
    public void setProcesses() {

        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsInitContainer(this, container);
        processes[0][2] = new gfp_jewlsLoad(this);
        processes[1][0] = new gfp_jewlsDeploy(this, container, -50, 0.7);
        processes[2][0] = new gfp_jewlsWinch(this, container, 0.030);
        processes[3][0] = new gfp_jewlsArmServo(this, 1.0);
        processes[4][0] = new gfp_jewlsShoot(this);
        processes[5][0] = new gfp_jewlsLoad(this);

        processes[6][0] = new gfp_jewlsArmServo(this, 0.0);
        processes[6][1] = new gfp_ballCapture(this, 1200);

        processes[7][0] = new gfp_jewlsArmServo(this, 1.0);

        processes[8][0] = new gfp_jewlsShoot(this);
        processes[9][0] = new gfp_jewlsLoad(this);

        processes[10][0] = new gfp_jewlsArmServo(this,0.0);

        processes[11][0] = new gfp_jewlsDriveForwardEncoders(this,600,500);

        processes[12][0] = new gfp_jewlsDriveEncodersRotateLeft(this,1000,500);
        processes[13][0] = new gfp_jewlsDriveForwardEncoders(this,4500,1000);
        processes[14][0] = new gfp_jewlsDriveEncodersRotateRight(this,1200,500);

        processes[15][0] = new gfp_jewlsDriveBackEncoders(this,-800,500);

        processes[16][0] = new gfp_jewlsDriveBalance(this,0.20,3);

        processes[17][0] = new gfp_jewlsDriveBackEncoders(this, -300, 500);
        //processes[17][1] = new gfp_jewlsButtonPress(this,container,0.8);
        processes[18][0] = new gfp_jewlsButtonPress(this,container,.9);
        processes[19][0] = new gfp_jewlsDriveToRed(this,0.15,2.0);
        processes[20][0] = new gfp_jewlsButtonPress(this, container, 0.0);
        processes[20][1] = new gfp_jewlsSleep(1000);
        processes[21][0] = new gfp_jewlsButtonPress(this,container,1.0);

        processes[22][0] = new gfp_jewlsDriveToRed(this,0.2,2.0);


    }
}