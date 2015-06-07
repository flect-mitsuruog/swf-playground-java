package info.mitsuruog.aws.swf.playground.HelloWorldWorkflow;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterStarter {

	public static void main(String[] args) {
		
		AmazonSimpleWorkflow swf = Config.swfFactory();		
		GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflow"); //workflowID
		workflow.greet();
		
	}
}
