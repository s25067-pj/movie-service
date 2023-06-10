package com.example.movieservice;

import com.example.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long along);
    Optional<Movie> findByActiveIsTrueAndId(Long id);

    @Modifying
    @Transactional
    @Query("update Movie m set m.active = :active where m.id = :id")
    void activateMovie(@Param("active")boolean active, @Param("id") Long id);

    List<Movie> findByIsAvailable(boolean isAvailable);
}
