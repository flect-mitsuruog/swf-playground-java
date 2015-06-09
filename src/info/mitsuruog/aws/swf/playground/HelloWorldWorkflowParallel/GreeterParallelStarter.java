package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel;

import info.mitsuruog.aws.swf.playground.Config;
import info.mitsuruog.aws.swf.playground.ConfigHelper;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class GreeterParallelStarter {
	public static void main(String[] args) {
		
		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		GreeterParallelWorkflowClientExternalFactory factory = new GreeterParallelWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		GreeterParallelWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowParallel"); //workflowID
		workflow.greet();
		
	}
}
