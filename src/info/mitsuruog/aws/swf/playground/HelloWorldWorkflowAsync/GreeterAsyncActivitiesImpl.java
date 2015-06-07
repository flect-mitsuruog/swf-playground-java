package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

public class GreeterAsyncActivitiesImpl implements GreeterAsyncActivities {

	@Override
	public String getName() {
		return "async workflow";
	}

	@Override
	public void say(String what) {
		System.out.println(what);
	}

}
