package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class GreeterParallelWorkflowImpl implements GreeterParallelWorkflow {

	private GreeterParallelActivitiesClient operations = new GreeterParallelActivitiesClientImpl();
	
	@Override
	public void greet() {
	      Promise<String> name = operations.getName();
	      Promise<String> greeting = operations.getGreeting();
	      operations.say(greeting, name);
	}

}
