package io.arnab.springduckdbdemo;

import java.util.List;
import java.util.Map;

public interface QueryExecutor {
    List<Map<String, Object>> executeQuery();
}
