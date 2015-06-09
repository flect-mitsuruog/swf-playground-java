package info.mitsuruog.aws.swf.playground.HelloWorldWorkflow;

import info.mitsuruog.aws.swf.playground.Config;
import info.mitsuruog.aws.swf.playground.ConfigHelper;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterStarter {

	public static void main(String[] args) {
		
		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflow"); //workflowID
		workflow.greet();
		
	}
}
