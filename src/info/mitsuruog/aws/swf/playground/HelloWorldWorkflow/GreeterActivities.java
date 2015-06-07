package info.mitsuruog.aws.swf.playground.HelloWorldWorkflow;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version="1.1")
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds = 300,
		defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterActivities {
	   public String getName();
	   public String getGreeting(String name);
	   public void say(String what);
}
