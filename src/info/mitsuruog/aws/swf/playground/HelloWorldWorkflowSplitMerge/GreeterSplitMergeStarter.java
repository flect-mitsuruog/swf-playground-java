package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMerge;

import info.mitsuruog.aws.swf.playground.Config;
import info.mitsuruog.aws.swf.playground.ConfigHelper;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterSplitMergeStarter {
	public static void main(String[] args) {
		
		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		GreeterSplitMergeWorkflowClientExternalFactory factory = new GreeterSplitMergeWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterSplitMergeWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowSplitMerge"); //workflowID
		workflow.greet();
		
	}
}
