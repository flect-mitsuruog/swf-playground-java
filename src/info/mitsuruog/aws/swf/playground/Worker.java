package info.mitsuruog.aws.swf.playground;

import info.mitsuruog.aws.swf.playground.HelloWorldWorkflow.GreeterActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflow.GreeterWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync.GreeterAsyncActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync.GreeterAsyncWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ChildActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ChildWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ParentWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel.GreeterParallelActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel.GreeterParallelWorkflowImpl;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class Worker {

	public static void main(String[] args) throws Exception {

		AmazonSimpleWorkflow swf = Config.swfFactory();
		String domain = Config.DOMAIN;
		String taskListToPoll = Config.TASK_LIST_NAME;
		
		// activity poller start
		ActivityWorker activityWorker = new ActivityWorker(swf, domain, taskListToPoll);
		activityWorker.addActivitiesImplementation(new GreeterActivitiesImpl());
		activityWorker.addActivitiesImplementation(new GreeterAsyncActivitiesImpl());
		activityWorker.addActivitiesImplementation(new ChildActivitiesImpl());
		activityWorker.addActivitiesImplementation(new GreeterParallelActivitiesImpl());
		activityWorker.start();
		
		// workflow poller start
		WorkflowWorker workflowWorker = new WorkflowWorker(swf, domain, taskListToPoll);
		workflowWorker.addWorkflowImplementationType(GreeterWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(GreeterAsyncWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(ParentWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(ChildWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(GreeterParallelWorkflowImpl.class);
		workflowWorker.start();
		
	}
	
}
