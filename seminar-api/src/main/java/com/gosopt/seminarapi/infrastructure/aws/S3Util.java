package com.gosopt.seminarapi.infrastructure.aws;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.gosopt.seminardomain.global.config.AwsS3Config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class S3Util {

    private final AwsS3Config awsS3Config;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;



    public void putObject(String keyName,  InputStream inputStream, ObjectMetadata objectMetadata) {
        awsS3Config.amazonS3Client().putObject(bucket,  keyName, inputStream, objectMetadata);
    }

    public String getObjectUrl(String keyName) {
        return awsS3Config.amazonS3Client().getUrl(bucket, keyName).toString();
    }

    public void deleteObject(String keyName) {
        awsS3Config.amazonS3Client().deleteObject(bucket, keyName);
    }
}
