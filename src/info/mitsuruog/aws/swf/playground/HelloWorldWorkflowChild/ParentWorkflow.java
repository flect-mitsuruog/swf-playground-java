package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(
		defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface ParentWorkflow {
	   @Execute(version = "1.1")
	   public void parentGreet();
}
