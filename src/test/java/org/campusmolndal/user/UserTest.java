package org.campusmolndal.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User sut;
    @BeforeEach
    void setUp() {
        sut = new User(1, "default", 10);
    }

    @Test
    void getId() {
        // arrange
        int expected =1;
        // act
        int actual = sut.getId();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        // arrange
        String expected = "default";
        // act
        String actual = sut.getName();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        // arrange
        String expected = "Whiskey Tango";
        // act
        sut.setName(expected);
        String actual = sut.getName();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void failSetName() {
        // arrange
        String expected = "default";
        // act
        sut.setName("");
        String actual = sut.getName();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAge() {
        // arrange
        int expected =10;
        // act
        int actual = sut.getAge();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setAge() {
        // arrange
        int expected =150;
        // act
        sut.setAge(expected);
        int actual = sut.getAge();
        // Assert
        assertEquals(expected, actual);
    }
}