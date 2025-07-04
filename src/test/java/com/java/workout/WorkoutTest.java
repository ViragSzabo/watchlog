package com.java.workout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    Workout workout;

    @BeforeEach
    void setUp() {
        workout = new Workout(10, 10, 20);
    }

    @Test
    void getTotalPushups() {
        assertEquals(10, workout.getTotalPushups());
    }

    @Test
    void setTotalPushups() {
        workout.setTotalPushups(20);
        assertEquals(20, workout.getTotalPushups());
    }

    @Test
    void getTotalSquats() {
        assertEquals(10, workout.getTotalSquats());
    }

    @Test
    void setTotalSquats() {
        workout.setTotalSquats(30);
        assertEquals(30, workout.getTotalSquats());
    }

    @Test
    void getTotalPlankSeconds() {
        assertEquals(20, workout.getTotalPlankSeconds());
    }

    @Test
    void setTotalPlankSeconds() {
        workout.setTotalPlankSeconds(60);
        assertEquals(60, workout.getTotalPlankSeconds());
    }
}