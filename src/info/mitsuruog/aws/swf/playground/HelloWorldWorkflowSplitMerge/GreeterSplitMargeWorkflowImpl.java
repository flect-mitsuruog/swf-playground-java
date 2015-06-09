package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class GreeterSplitMargeWorkflowImpl implements GreeterSplitMergeWorkflow {

	@Override
	public void greet() {
		GreeterSplitMerger operations = new GreeterSplitMergerImpl();
		Promise<String> what = operations.splitMarge("i am mitsuru ogawa");
		operations.say(what);
	}

}
