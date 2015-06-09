package info.mitsuruog.aws.swf.playground;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import info.mitsuruog.aws.swf.playground.HelloWorldWorkflow.GreeterActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflow.GreeterWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync.GreeterAsyncActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowAsync.GreeterAsyncWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ChildActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ChildWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowChild.ParentWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel.GreeterParallelActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel.GreeterParallelWorkflowImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMarge.GreeterSplitMargeActivitiesImpl;
import info.mitsuruog.aws.swf.playground.HelloWorldWorkflowSplitMarge.GreeterSplitMargeWorkflowImpl;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class Worker {

	public static void main(String[] args) throws Exception {

		ConfigHelper configHelper = new ConfigHelper();
		AmazonSimpleWorkflow swf = configHelper.swfFactory();
		String domain = Config.DOMAIN;
		String taskListToPoll = Config.TASK_LIST_NAME;
		
		// activity poller start
		final ActivityWorker activityWorker = new ActivityWorker(swf, domain, taskListToPoll);
		activityWorker.addActivitiesImplementation(new GreeterActivitiesImpl());
		activityWorker.addActivitiesImplementation(new GreeterAsyncActivitiesImpl());
		activityWorker.addActivitiesImplementation(new ChildActivitiesImpl());
		activityWorker.addActivitiesImplementation(new GreeterParallelActivitiesImpl());
		activityWorker.addActivitiesImplementation(new GreeterSplitMargeActivitiesImpl());
		activityWorker.start();
		
		// workflow poller start
		final WorkflowWorker workflowWorker = new WorkflowWorker(swf, domain, taskListToPoll);
		workflowWorker.addWorkflowImplementationType(GreeterWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(GreeterAsyncWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(ParentWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(ChildWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(GreeterParallelWorkflowImpl.class);
		workflowWorker.addWorkflowImplementationType(GreeterSplitMargeWorkflowImpl.class);
		workflowWorker.start();
		
        System.out.println("workflowとactivityが開始されました。");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                try {
                	activityWorker.shutdownAndAwaitTermination(1, TimeUnit.MINUTES);
                	workflowWorker.shutdownAndAwaitTermination(1, TimeUnit.MINUTES);
                    System.out.println("workflowとactivityを停止しました。");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
               
            }
        });

        System.out.println("何かキーを押すと停止します。");

        try {
            System.in.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);

	}
	
}
