package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild;

public class ParentWorkflowImpl implements ParentWorkflow {

	private ChildWorkflowClientFactory factory = new ChildWorkflowClientFactoryImpl();
		
	@Override
	public void parentGreet() {
		ChildWorkflowClient client = factory.getClient("HelloWorldWorkflowChild"); //workflowID
		client.childGreet("Hello parent");
	}

}
