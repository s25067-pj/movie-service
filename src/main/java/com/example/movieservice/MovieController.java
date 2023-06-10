package com.example.movieservice;

import com.example.movieservice.model.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Get Movie by id!")
    @ApiResponse(responseCode = "200", description = "OKi")
    @ApiResponse(responseCode = "400", description = "nie wyszlo", content = @Content)
    @ApiResponse(responseCode = "404", description = "beznadzieja", content = @Content)
    @ApiResponse(responseCode = "500", description = "katastrofa", content = @Content)
    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}/available")
    public ResponseEntity<?> setMovieAvailable(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        movie.setAvailable(true);
        movieService.save(movie);
        return ResponseEntity.ok().build();
    }
}
