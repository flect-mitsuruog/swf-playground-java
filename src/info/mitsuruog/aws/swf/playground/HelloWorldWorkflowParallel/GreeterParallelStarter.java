package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterParallelStarter {
	public static void main(String[] args) {
		
		AmazonSimpleWorkflow swf = Config.swfFactory();
		GreeterParallelWorkflowClientExternalFactory factory = new GreeterParallelWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterParallelWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowParallel"); //workflowID
		workflow.greet();
		
	}
}
