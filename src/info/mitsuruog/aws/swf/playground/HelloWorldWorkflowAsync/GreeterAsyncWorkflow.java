package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(
		defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface GreeterAsyncWorkflow {
	   @Execute(version = Config.API_VERSION)
	   public void greet();
}
