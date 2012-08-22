// Copyright 2009 Michael Brown All Rights Reserved.
package version3;

import com.google.wave.api.ProfileServlet;

/**
* A servlet that is used to fetch the profile information for Slashdot_Robot.
* 
*/
@SuppressWarnings("serial")
public class Slashdot_RobotProfileServlet extends ProfileServlet {

@Override
public String getRobotAvatarUrl() {
        return "http://www.m1cr0sux0r.com/topicslashdot.gif";
}

@Override
public String getRobotName() {
        return "Slashdot Robot";
}

@Override
public String getRobotProfilePageUrl() {
        return "http://slashdotbot.appspot.com/_wave/robot/profile";
}
}