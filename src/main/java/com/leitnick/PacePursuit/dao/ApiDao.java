package com.leitnick.PacePursuit.dao;

import com.leitnick.PacePursuit.model.ApiKey;

public interface ApiDao {

    ApiKey getApiKeyByName(String apiName);
    ApiKey updateApiKeyByName(ApiKey apiKeyToUpdate);
}
