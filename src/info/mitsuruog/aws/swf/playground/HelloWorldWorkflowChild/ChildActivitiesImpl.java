package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

public class ChildActivitiesImpl implements ChildActivities {

	@Override
	public void say(String what) {
		what += " child workflow";
	    System.out.println(what);
	}

}
