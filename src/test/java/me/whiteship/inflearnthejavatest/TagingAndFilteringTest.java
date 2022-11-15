package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class TagingAndFilteringTest {

    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create_new_study() {
        Study actual = new Study(100);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @Disabled
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_new_study_again() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEachAll() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

}
