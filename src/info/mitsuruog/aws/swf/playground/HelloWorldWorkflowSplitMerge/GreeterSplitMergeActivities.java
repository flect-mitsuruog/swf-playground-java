package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = Config.API_VERSION)
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds = 300,
		defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterSplitMergeActivities {
	   public String decorate(String what);
	   public void greet(String what);
}
