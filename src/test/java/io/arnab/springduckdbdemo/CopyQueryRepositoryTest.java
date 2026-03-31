package io.arnab.springduckdbdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CopyQueryRepositoryTest {

    @Autowired
    private CopyQueryRepository copyQueryRepository;

    @Test
    public void getAll() {
        var response = copyQueryRepository.getAll();
        List<Map<String, Object>> expectedResponse = List.of(
                Map.of("customer_id", 101L, "first_name", "John", "gender", "Male", "last_name", "Smith"),
                Map.of("customer_id", 102L, "first_name", "Sarah", "gender", "Female", "last_name", "Jones"));

        assertThat(response).containsExactlyInAnyOrderElementsOf(expectedResponse);
    }
}
