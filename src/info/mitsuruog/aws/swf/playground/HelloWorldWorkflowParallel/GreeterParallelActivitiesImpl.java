package info.mitsuruog.aws.swf.playground.HelloWorldWorkflowParallel;

public class GreeterParallelActivitiesImpl implements GreeterParallelActivities {
	
	   @Override
	   public String getName() {
	      return "paralle workflow";
	   }
	
	   @Override
	   public String getGreeting() {
	      return "Hello ";
	   }
	   
	   @Override
	   public void say(String greeting, String name) {
	      System.out.println(greeting + name);
	   }

}
