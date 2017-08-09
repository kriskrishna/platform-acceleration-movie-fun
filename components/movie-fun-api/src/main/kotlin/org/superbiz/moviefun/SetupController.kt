package org.superbiz.moviefun

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.superbiz.moviefun.albumsapi.AlbumFixtures
import org.superbiz.moviefun.albumsapi.AlbumsClient
import org.superbiz.moviefun.albumsapi.PlaysClient
import org.superbiz.moviefun.moviesapi.MovieFixtures
import org.superbiz.moviefun.moviesapi.MoviesClient
import org.superbiz.moviefun.playsapi.PlayFixtures

@Controller
class SetupController(private val moviesClient: MoviesClient, private val albumsClient: AlbumsClient, private val playsClient: PlaysClient, private val movieFixtures: MovieFixtures, private val albumFixtures: AlbumFixtures,
                      private val playFixtures: PlayFixtures) {

    @GetMapping("/setup")
    fun setup(model: MutableMap<String, Any>): String {
        for (movie in movieFixtures.load()) {
            moviesClient.addMovie(movie)
        }

        for (album in albumFixtures.load()) {
            albumsClient.addAlbum(album)
        }

        for (album in albumFixtures.load()) {
            albumsClient.addAlbum(album)
        }

        for (play in playFixtures.load()) {
            playsClient.addPlay(play)
        }

        model.put("movies", moviesClient.movies)
        model.put("albums", albumsClient.albums)
        model.put("plays", playsClient.plays)

        return "setup"
    }
}
