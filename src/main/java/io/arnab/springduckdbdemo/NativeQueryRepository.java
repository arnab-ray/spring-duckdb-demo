package io.arnab.springduckdbdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NativeQueryRepository implements DuckDBRepository {

    private final JdbcTemplate jdbcTemplate;

    public NativeQueryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE items (item VARCHAR, value DECIMAL(10, 2), count INTEGER)");
        // insert two items into the table
        jdbcTemplate.execute("INSERT INTO items VALUES ('jeans', 20.0, 1), ('hammer', 42.2, 2)");
    }

    public List<Map<String, Object>> getAll() {
        return jdbcTemplate.queryForList("SELECT * FROM items");
    }
}
