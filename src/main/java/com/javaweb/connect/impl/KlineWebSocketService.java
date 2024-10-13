package com.javaweb.connect.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.config.WebSocketConfig;
<<<<<<< HEAD
import com.javaweb.connect.IKlineWebSocketService;

import com.javaweb.service.IKlinePriceDataService;
import com.javaweb.service.ISpotPriceDataService;
=======
import com.javaweb.connect.IConnectToWebSocketService;
import com.javaweb.service.impl.KlineDataService;
import com.javaweb.service.impl.SpotPriceDataService;
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
<<<<<<< HEAD
public class KlineWebSocketService extends TextWebSocketHandler implements IKlineWebSocketService {

    @Autowired
    private IKlinePriceDataService klinePriceDataService;
=======
public class KlineWebSocketService extends TextWebSocketHandler implements IConnectToWebSocketService {
    @Autowired
    private KlineDataService klineDataService;
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebSocketConfig webSocketConfig;

    @Autowired
    private WebSocketClient webSocketClient;



    private String buildKlineWebSocketUrl(List<String> streams) {
<<<<<<< HEAD
        // Create the stream parameter with the correct format and kline interval fixed at "1m"
        String streamParam = streams.stream()
                .map(s -> s.toLowerCase() + "@kline_1m") // Ensure lowercase and append "@kline_1m"
                .collect(Collectors.joining("/")); // Join streams with "/"

        // Return the constructed URL using the base URL wss://fstream.binance.com
        return "wss://fstream.binance.com/stream?streams=" + streamParam;
    }


    @Override
    public void connectToKlineWebSocket(List<String> streams) {
=======
        String streamParam = streams.stream()
                .map(s -> s.toLowerCase() + "@kline_1s")
                .collect(Collectors.joining("/"));
        return "wss://stream.binance.com/stream?streams=" + streamParam;
    }

    @Override
    public void connectToWebSocket(List<String> streams) {
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
        String wsUrl = buildKlineWebSocketUrl(streams);
        webSocketConfig.connectToWebSocket(wsUrl, webSocketClient, this);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
<<<<<<< HEAD
        System.out.println("Received from Binance: " + payload);

        JsonNode data = objectMapper.readTree(payload).get("data");

        klinePriceDataService.handleKlineWebSocketMessage(data);
    }

//    public void closeWebSocket() {
//        webSocketConfig.closeWebSocket();
//        System.out.println("WebSocket closed from service.");
//    }

=======

        JsonNode data = objectMapper.readTree(payload).get("data");

        klineDataService.handleWebSocketMessage(data);
    }

>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
}
