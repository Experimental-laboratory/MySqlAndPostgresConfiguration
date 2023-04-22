package db_service.db_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.WithAssertions;
import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class DbServiceIntegrationTests /*implements WithAssertions*/
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void checkAllColumns()
	{
		final String queryStr = "SELECT * FROM table_for_test";

		List<Map<String, Object>> result = jdbcTemplate.query(queryStr, new ColumnMapRowMapper());

		assertThat(result).hasSize(10);
		assertThat(result.get(0).keySet()).hasSize(3)
				.containsSequence("ID", "NAME", "LAST_NAME");
	}

	@Test
	void checkOneColumns()
	{
		final String queryStr = "SELECT LAST_NAME FROM table_for_test";

		List<Map<String, Object>> result = jdbcTemplate.query(queryStr, new ColumnMapRowMapper());

		assertThat(result).hasSize(10);
		assertThat(result.get(0).keySet()).hasSize(1)
				.containsSequence("LAST_NAME");
	}



}
