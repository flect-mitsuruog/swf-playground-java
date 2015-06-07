package info.mitsuruog.aws.swf.playground;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public class SampleConfig {
	public static final String AWS_ACCESS_KEY_ID = "<AWS_ACCESS_KEY_ID>";
	public static final String AWS_SECRET_KEY = "<AWS_SECRET_KEY>";
	public static final String DOMAIN = "swf-playground";
	public static final String TASK_LIST_NAME = "swf-playground-task";
	public static final String ENDPOINT_URL = "https://swf.ap-northeast-1.amazonaws.com";
	
	public static AmazonSimpleWorkflow swfFactory() {
		
		ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);
		
		String swfAccessId = AWS_ACCESS_KEY_ID;
		String swfSecretKey = AWS_SECRET_KEY;
		AWSCredentials awsCredentials = new BasicAWSCredentials(swfAccessId, swfSecretKey);
		 
		AmazonSimpleWorkflow swf = new AmazonSimpleWorkflowClient(awsCredentials, config);
		swf.setEndpoint(ENDPOINT_URL);
		
		return swf;
		
	}
}
