package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.annotations.Wait;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;


public class GreeterSplitMergerImpl implements GreeterSplitMerger {
	
	private final GreeterSplitMergeActivitiesClient client = new GreeterSplitMergeActivitiesClientImpl();

	@Override
	public Promise<String> splitMarge(String what) {
		return split(what);
	}
	
	
	@Asynchronous
	private Promise<String> split(String what) {
		List<Promise<String>> results = new ArrayList<Promise<String>>();
		for (String parts : what.split(" ")) {
			results.add(client.decorate(parts));
		}
		return marge(results);
	}

	@Asynchronous
	private Promise<String> marge(@Wait List<Promise<String>> results) {
		String what = "";
		for (Promise<String> parts : results) {
			what += parts.get();
		}
		return Promise.asPromise(what);
	}

	@Override
	@Asynchronous
	public void say(Promise<String> what) {
		client.greet(what);
	}

}
