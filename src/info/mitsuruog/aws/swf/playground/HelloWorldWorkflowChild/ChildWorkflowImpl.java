package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

public class ChildWorkflowImpl implements ChildWorkflow {

	ChildActivitiesClient operation = new ChildActivitiesClientImpl();
	
	@Override
	public void childGreet(String what) {
		operation.say(what);
	}

}
