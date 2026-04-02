import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Paths;

public class S3Uploader {

    private static final String BUCKET_NAME = "attendance-compliance-bucket-ahmed";

    public static void upload(String localFilePath, String s3Key) {

        try (S3Client s3 = S3Client.builder().build()) {

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(s3Key)
                    .build();

            s3.putObject(request, Paths.get(localFilePath));
            System.out.println("Uploaded to S3: " + s3Key);

        } catch (Exception e) {
            System.out.println("S3 upload failed");
            e.printStackTrace();
        }
    }
}