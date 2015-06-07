package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class GreeterAsyncWorkflowImpl implements GreeterAsyncWorkflow {

	private GreeterAsyncActivitiesClient operations = new GreeterAsyncActivitiesClientImpl();
	
	@Override
	public void greet() {
		Promise<String> name = operations.getName();
		Promise<String> greeting = getGreeting(name);
		operations.say(greeting);
	}

	@Asynchronous
	private Promise<String> getGreeting(Promise<String> name) {
		String returnString = "Hello " + name.get();
	    return Promise.asPromise(returnString);
	}

}
