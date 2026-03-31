package io.arnab.springduckdbdemo;

import java.util.List;
import java.util.Map;

public interface DuckDBRepository {
    List<Map<String, Object>> getAll();
}
