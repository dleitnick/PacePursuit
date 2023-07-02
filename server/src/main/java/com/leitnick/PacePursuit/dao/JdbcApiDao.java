package com.leitnick.PacePursuit.dao;

import com.leitnick.PacePursuit.model.ApiKey;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Component
public class JdbcApiDao implements ApiDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcApiDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ApiKey getApiKeyByName(String apiName) {
        ApiKey apiKey = new ApiKey();
        String sql = "SELECT * FROM api_key WHERE service_name=?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, apiName);
        if (results.next()) apiKey = mapRowToApiKey(results);
        return apiKey;
    }

    @Override
    public ApiKey updateApiKeyByName(ApiKey apiKeyToUpdate) {
        String sql = "UPDATE api_key SET refresh_token=?, access_token=?, expiration=? WHERE service_name=?";
        jdbcTemplate.update(sql, apiKeyToUpdate.getRefreshToken(), apiKeyToUpdate.getAccessToken(), apiKeyToUpdate.getExpiration(), apiKeyToUpdate.getServiceName());
        return apiKeyToUpdate;
    }

    private ApiKey mapRowToApiKey(SqlRowSet results) {
        ApiKey apiKey = new ApiKey();
        apiKey.setId(results.getInt("id"));
        apiKey.setServiceName(results.getString("service_name"));
        apiKey.setRefreshToken(results.getString("refresh_token"));
        apiKey.setAccessToken(results.getString("access_token"));
        apiKey.setExpiration(results.getLong("expiration"));
        return apiKey;
    }
}
