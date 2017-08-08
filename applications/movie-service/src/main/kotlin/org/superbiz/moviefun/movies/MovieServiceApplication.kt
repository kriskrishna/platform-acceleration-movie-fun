package org.superbiz.moviefun.movies

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.core.env.Environment


@EnableEurekaClient
@SpringBootApplication
class MovieServiceApplication {

    @Autowired
    val environment: Environment? = null
}


fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger(MovieServiceApplication::class.java)
    SpringApplication.run(MovieServiceApplication::class.java, *args)

}