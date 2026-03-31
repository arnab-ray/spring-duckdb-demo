package io.arnab.springduckdbdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CSVQueryRepository implements DuckDBRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    public CSVQueryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = "customer";
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE " + tableName + " " +
                "AS SELECT * FROM read_csv('src/main/resources/customer.csv')");
    }

    public List<Map<String, Object>> getAll() {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }
}
