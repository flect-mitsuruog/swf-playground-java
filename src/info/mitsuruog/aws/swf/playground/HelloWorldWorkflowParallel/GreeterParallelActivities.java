package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = Config.API_VERSION)
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds = 300,
		defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterParallelActivities {
	   public String getName();
	   public String getGreeting();
	   public void say(String greeting, String name);
}
