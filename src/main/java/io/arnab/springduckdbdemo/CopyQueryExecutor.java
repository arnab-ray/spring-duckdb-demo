package io.arnab.springduckdbdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CopyQueryExecutor implements QueryExecutor {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    public CopyQueryExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = "customer_";
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE " + tableName + " (" +
                "customer_id BIGINT, first_name  VARCHAR, last_name VARCHAR, gender VARCHAR);");
        jdbcTemplate.execute("COPY " + tableName + " FROM 'src/main/resources/customer.csv'");
    }

    @Override
    public List<Map<String, Object>> executeQuery() {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }
}
