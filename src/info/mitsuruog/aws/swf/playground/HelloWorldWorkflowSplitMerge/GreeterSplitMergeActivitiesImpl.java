package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

public class GreeterSplitMergeActivitiesImpl implements GreeterSplitMergeActivities {

	@Override
	public String decorate(String what) {
		return "[" + what + "]";
	}

	@Override
	public void greet(String what) {
		System.out.println("Hello split marge workflow." + what);
	}

}
