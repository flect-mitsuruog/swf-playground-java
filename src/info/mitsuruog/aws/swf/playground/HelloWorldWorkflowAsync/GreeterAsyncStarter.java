package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

import info.mitsuruog.aws.swf.playground.Config;
import info.mitsuruog.aws.swf.playground.ConfigHelper;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterAsyncStarter {
	public static void main(String[] args) {
		
		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		GreeterAsyncWorkflowClientExternalFactory factory = new GreeterAsyncWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterAsyncWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowAsync"); //workflowID
		workflow.greet();
		
	}
}
