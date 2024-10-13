package com.javaweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.javaweb.dto.PriceDTO;
import com.javaweb.model.KlineDTO;

import java.util.Map;

public interface IKlineService {

    void handleSpotWebSocketMessage(JsonNode data);

    Map<String, KlineDTO> getKlineDataMap();
}
