package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterAsyncStarter {
	public static void main(String[] args) {
		
		AmazonSimpleWorkflow swf = Config.swfFactory();		
		GreeterAsyncWorkflowClientExternalFactory factory = new GreeterAsyncWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterAsyncWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowAsync"); //workflowID
		workflow.greet();
		
	}
}
