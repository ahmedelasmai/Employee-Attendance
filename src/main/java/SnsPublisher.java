import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

public class SnsPublisher {

    private static final String TOPIC_ARN =
            "arn:aws:sns:eu-north-1:738245088039:attendance-compliance-summary";

    public static void publishSummary(String message) {

        try (SnsClient sns = SnsClient.builder()
                .region(Region.EU_NORTH_1)
                .build()) {

            PublishRequest request = PublishRequest.builder()
                    .topicArn(TOPIC_ARN)
                    .subject("Daily Attendance Compliance Report")
                    .message(message)
                    .build();

            sns.publish(request);
            System.out.println("SNS notification sent.");

        } catch (Exception e) {
            System.out.println("SNS publish failed.");
            e.printStackTrace();
        }
    }
}