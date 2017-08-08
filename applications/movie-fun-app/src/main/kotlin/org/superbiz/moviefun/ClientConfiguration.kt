package org.superbiz.moviefun

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestOperations
import org.superbiz.moviefun.albumsapi.AlbumsClient
import org.superbiz.moviefun.moviesapi.MoviesClient

@Configuration
class ClientConfiguration {


    @Value("\${albums.url}") var albumsUrl: String? = null
    @Value("\${movies.url}") var moviesUrl: String? = null

    @Bean
    fun albumsClient(restOperations: RestOperations) = AlbumsClient("//album-service/albums", restOperations)

    @Bean
    fun moviesClient(restOperations: RestOperations) = MoviesClient("//movie-service/movies", restOperations)


   /* @Bean
    fun albumsClient(restOperations: RestOperations) = AlbumsClient(albumsUrl.toString(), restOperations)

    @Bean
    fun moviesClient(restOperations: RestOperations) = MoviesClient(moviesUrl.toString(), restOperations)*/
}