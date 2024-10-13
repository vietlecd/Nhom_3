package com.javaweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.javaweb.dto.PriceDTO;

import java.util.Map;

public interface ISpotPriceDataService {



    Map<String, PriceDTO> getSpotPriceDataMap();

    void handleSpotWebSocketMessage(JsonNode data);
}
