package com.javaweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.javaweb.dto.KlineDTO;


import java.util.Map;

public interface IKlinePriceDataService {

    void handleKlineWebSocketMessage(JsonNode data);

    Map<String, KlineDTO> getKlineDataMap();
}
