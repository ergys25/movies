package codes.ergyshila.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovieByImdbId(@PathVariable String imdbId) {
        return service.findMovieByImdbId(imdbId)
                .map(movie -> new ResponseEntity<Movie>(movie, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Movie>(HttpStatus.NOT_FOUND));
    }



}