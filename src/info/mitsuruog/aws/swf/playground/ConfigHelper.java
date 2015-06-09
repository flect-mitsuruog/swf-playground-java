package info.mitsuruog.aws.swf.playground;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public class ConfigHelper {

	public AmazonSimpleWorkflow swfFactory() {
		
		ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);
		
		String swfAccessId = Config.AWS_ACCESS_KEY_ID;
		String swfSecretKey = Config.AWS_SECRET_KEY;
		AWSCredentials awsCredentials = new BasicAWSCredentials(swfAccessId, swfSecretKey);
		 
		AmazonSimpleWorkflow swf = new AmazonSimpleWorkflowClient(awsCredentials, config);
		swf.setEndpoint(Config.ENDPOINT_URL);

		return swf;
		
	}
}
