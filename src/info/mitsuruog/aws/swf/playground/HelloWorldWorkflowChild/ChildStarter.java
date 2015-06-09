package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

import info.mitsuruog.aws.swf.playground.Config;
import info.mitsuruog.aws.swf.playground.ConfigHelper;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class ChildStarter {

	public static void main(String[] args) {
		
		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		ParentWorkflowClientExternalFactory factory = new ParentWorkflowClientExternalFactoryImpl(swf, Config.DOMAIN);
		ParentWorkflowClientExternal workflow = factory.getClient("HelloWorldWorkflowParent");
		workflow.parentGreet();		
		
	}
	
}
