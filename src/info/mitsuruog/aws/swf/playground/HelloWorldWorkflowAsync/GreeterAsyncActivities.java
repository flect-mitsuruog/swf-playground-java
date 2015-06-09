package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = Config.API_VERSION)
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds = 300,
		defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterAsyncActivities {
	   public String getName();
	   public void say(String what);
}
