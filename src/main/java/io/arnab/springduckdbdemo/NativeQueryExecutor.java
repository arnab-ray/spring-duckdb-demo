package io.arnab.springduckdbdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NativeQueryExecutor implements QueryExecutor {

    private final JdbcTemplate jdbcTemplate;

    public NativeQueryExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> executeQuery() {

        jdbcTemplate.execute("CREATE TABLE items (item VARCHAR, value DECIMAL(10, 2), count INTEGER)");
        // insert two items into the table
        jdbcTemplate.execute("INSERT INTO items VALUES ('jeans', 20.0, 1), ('hammer', 42.2, 2)");

        return jdbcTemplate.queryForList("SELECT * FROM items");
    }
}
