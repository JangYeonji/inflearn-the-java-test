package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기")
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void create_new_study() {
        //터미널 > vim ~/.zshrc > export TEST_ENV=LOCAL 추가
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

        assumingThat("yeonji".equalsIgnoreCase(test_env), () -> {
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

//        //Junit 아님
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);

//        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });
//        //TODO ThreadLocal
//        //ThreadLocal을 사용하는 경우에는 테스트가 제대로 적용되지 않을 수 있음
//        //assertTimeoutPreemptively는 Thread와 관련 없을 때 쓰기


//        assertTimeout(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });


//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
//        String message = exception.getMessage();
//        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());


//        Study study = new Study(-10);
//        assertNotNull(study);
//        //람다식은 실패할 때만 메시지를 출력함. 그냥 메시지를 쓰는 것보다 람다를 쓰는게 성능이 더 좋아짐
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."),
//                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
//        );
    }

    @Test
    @Disabled
    @DisabledOnOs(OS.MAC)
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "yeonji")
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