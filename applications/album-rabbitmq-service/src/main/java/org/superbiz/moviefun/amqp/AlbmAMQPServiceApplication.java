package org.superbiz.moviefun.amqp;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.superbiz.moviefun.blobstore.BlobStore;
import org.superbiz.moviefun.blobstore.S3Store;

/**
 * Created by kshitizkriskrishna on 9/17/17.
 */
//@EnableEurekaClient
@SpringBootApplication
@ComponentScans({@ComponentScan("org.superbiz.moviefun.albums"), @ComponentScan("org.superbiz.moviefun.amqp")})
@EntityScan("org.superbiz.moviefun.albums")
public class AlbmAMQPServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(AlbmAMQPServiceApplication.class, args);
    }

    @Value("${s3.accessKey}") String s3AccessKey;
    @Value("${s3.secretKey}") String s3SecretKey;
    @Value("${s3.bucketName}") String s3BucketName;
    @Value("${s3.endpoint}") String s3EndpointURL;

    @Bean
    public BlobStore blobStore() {
        AWSCredentials credentials = new BasicAWSCredentials(s3AccessKey, s3SecretKey);
        AmazonS3Client s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(s3EndpointURL);
        return new S3Store(s3Client, s3BucketName);
    }


   /* @Bean
    public AlbumsRepository albumsRepository() {
        return new AlbumsRepository();
    }

    @Bean
    public AlbumsUpdater albumsUpdater(BlobStore blobStore, AlbumsRepository albumsRepository) {
        return new AlbumsUpdater(blobStore, albumsRepository);
    }
*/

}
