package info.mitsuruog.aws.swf.playground.HelloWorldWorkflow;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = Config.API_VERSION)
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds = 300,
		defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterActivities {
	   public String getName();
	   public String getGreeting(String name);
	   public void say(String what);
}
