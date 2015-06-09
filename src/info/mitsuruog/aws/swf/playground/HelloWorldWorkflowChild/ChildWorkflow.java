package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(
		defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface ChildWorkflow {
	   @Execute(version = Config.API_VERSION)
	   public void childGreet(String what);
}
