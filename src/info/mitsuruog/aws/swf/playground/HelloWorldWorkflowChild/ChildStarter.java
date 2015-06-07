package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

import info.mitsuruog.aws.swf.playground.Config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class ChildStarter {

	public static void main(String[] args) {
		
		AmazonSimpleWorkflow swf = Config.swfFactory();
		ParentWorkflowClientExternalFactory factory = new ParentWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		ParentWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowParent"); //workflowID
		workflow.parentGreet();		
		
	}
	
}
