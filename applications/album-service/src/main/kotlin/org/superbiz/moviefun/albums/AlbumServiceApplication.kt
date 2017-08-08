package org.superbiz.moviefun.albums

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.superbiz.moviefun.blobstore.BlobStore
import org.superbiz.moviefun.blobstore.S3Store

@EnableEurekaClient
@SpringBootApplication
class AlbumServiceApplication {

    @Value("\${s3.accessKey}") internal var s3AccessKey: String? = null
    @Value("\${s3.secretKey}") internal var s3SecretKey: String? = null
    @Value("\${s3.bucketName}") internal var s3BucketName: String? = null
    @Value("\${s3.endPoint}") internal var s3EndPoint: String? = null
    @Bean
    fun blobStore(): BlobStore {
        val credentials = BasicAWSCredentials(s3AccessKey, s3SecretKey)
        val s3Client = AmazonS3Client(credentials)
        s3Client.setEndpoint(s3EndPoint)
        return S3Store(s3Client, s3BucketName!!)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(AlbumServiceApplication::class.java, *args)
}
