package io.arnab.springduckdbdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CSVQueryExecutor implements QueryExecutor {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    public CSVQueryExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = "customer";
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE " + tableName + " " +
                "AS SELECT * FROM read_csv('src/main/resources/customer.csv')");
    }

    public List<Map<String, Object>> executeQuery() {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }
}
