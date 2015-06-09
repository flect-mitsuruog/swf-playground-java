package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public interface GreeterSplitMerger {
	public abstract Promise<String>splitMarge(String what);
	public abstract void say(Promise<String> what);
}