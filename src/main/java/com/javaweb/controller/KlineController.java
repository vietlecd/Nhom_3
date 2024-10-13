package com.javaweb.controller;


import com.javaweb.config.WebSocketConfig;
import com.javaweb.dto.KlineDTO;
import com.javaweb.helpers.Sse.SseHelper;
import com.javaweb.connect.IKlineWebSocketService;
import com.javaweb.service.IKlinePriceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class KlineController {

    @Autowired
    private SseHelper sseHelper;
    @Autowired
    private WebSocketConfig webSocketConfig;

    @Autowired
    private IKlineWebSocketService klineWebSocketService;
    @Autowired
    private IKlinePriceDataService IKlinePriceDataService;

    @GetMapping("/get-kline")
    public SseEmitter streamKlinePrices(@RequestParam List<String> symbols) {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        klineWebSocketService.connectToKlineWebSocket(symbols);

        Map<String, KlineDTO> priceDataMap = IKlinePriceDataService.getKlineDataMap();
        return sseHelper.createKlineSseEmitter(emitter, "kline", priceDataMap, webSocketConfig);
    }


}
