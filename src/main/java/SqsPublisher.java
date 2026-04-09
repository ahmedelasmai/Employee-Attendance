import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsPublisher {

    private static final String QUEUE_URL =
            "https://sqs.eu-north-1.amazonaws.com/738245088039/attendance-compliance-violations";

    public static void publishViolation(ComplianceViolation violation) {

        String messageBody =
                "Employee ID: " + violation.getEmployeeId() + "\n" +
                "Employee Name: " + violation.getEmployeeName() + "\n" +
                "Violation: " + violation.getViolationType() + "\n" +
                "Date: " + violation.getDate();

        try (SqsClient sqs = SqsClient.builder()
                .region(Region.EU_NORTH_1)
                .build()) {

            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(QUEUE_URL)
                    .messageBody(messageBody)
                    .build();

            sqs.sendMessage(request);
            System.out.println("SQS message sent for employee " + violation.getEmployeeId());

        } catch (Exception e) {
            System.out.println("Failed to send SQS message");
            e.printStackTrace();
        }
    }
}
