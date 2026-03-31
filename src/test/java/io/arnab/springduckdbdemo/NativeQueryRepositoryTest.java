package io.arnab.springduckdbdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NativeQueryRepositoryTest {

    @Autowired
    private NativeQueryRepository executor;

    @Test
    void testNativeQueryExecutor() {
        var response = executor.getAll();
        List<Map<String, Object>> expectedResponse = List.of(
                Map.of("count", 1, "item", "jeans", "value", BigDecimal.valueOf(20.00).setScale(2, RoundingMode.HALF_DOWN)),
                Map.of("count", 2, "item", "hammer", "value", BigDecimal.valueOf(42.20).setScale(2, RoundingMode.HALF_DOWN)));

        assertThat(response).containsExactlyInAnyOrderElementsOf(expectedResponse);
    }
}
