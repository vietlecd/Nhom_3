package com.javaweb.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.controller.KlineController;
import com.javaweb.dto.KlineDTO;

import com.javaweb.helpers.Service.DateTimeHelper;
import com.javaweb.helpers.Service.KlineDTOHelper;
import com.javaweb.helpers.Service.PriceDTOHelper;

import com.javaweb.service.IKlinePriceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KlinePriceDataService extends TextWebSocketHandler implements IKlinePriceDataService {

    private final Map<String, KlineDTO> KlinePriceDataMap = new ConcurrentHashMap<>();
    @Override
    public void  handleKlineWebSocketMessage(JsonNode data) {

        long eventTimeLong = data.get("E").asLong();
        String eventTime = DateTimeHelper.formatEventTime(eventTimeLong);
        // Lấy dữ liệu từ kline


        String symbol = data.get("s").asText();
        String klineStartTime = data.get("t").asText(); // Thời gian bắt đầu K-line
        String klineCloseTime = data.get("T").asText(); // Thời gian kết thúc K-line
        String openPrice = data.get("o").asText();   // Giá mở
        String closePrice = data.get("c").asText();  // Giá đóng
        String highPrice = data.get("h").asText();   // Giá cao nhất
        String lowPrice = data.get("l").asText();    // Giá thấp nhất
        String numberOfTrades = data.get("n").asText(); // Số lượng giao dịch
        String isKlineClosed = data.get("x").asText(); // Nến đã đóng hay chưa
        String baseAssetVolume = data.get("q").asText(); // Khối lượng tài sản cơ sở
        String takerBuyVolume = data.get("V").asText(); // Khối lượng mua của taker
        String takerBuyBaseVolume = data.get("Q").asText(); // Khối lượng mua tài sản cơ sở của taker
         // Thời gian sự kiện
        String volume = data.get("v").asText(); // Khối lượng giao dịch

        System.out.println("Symbol: " + symbol +
                ", Open Price: " + openPrice +
                ", Close Price: " + closePrice +
                ", High Price: " + highPrice +
                ", Low Price: " + lowPrice +
                ", Volume: " + volume +
                ", Number of Trades: " + numberOfTrades +
                ", Is Kline Closed: " + isKlineClosed +
                ", Base Asset Volume: " + baseAssetVolume +
                ", Taker Buy Volume: " + takerBuyVolume +
                ", Taker Buy Base Volume: " + takerBuyBaseVolume +
                ", Event Time: " + eventTime +
                ", Kline Start Time: " + klineStartTime +
                ", Kline Close Time: " + klineCloseTime);

        KlineDTO klineDTO = KlineDTOHelper.createKlineDTO(symbol, openPrice, closePrice, highPrice, lowPrice, volume, numberOfTrades, isKlineClosed, baseAssetVolume, takerBuyVolume, takerBuyBaseVolume, eventTime, klineStartTime, klineCloseTime);
        KlinePriceDataMap.put("KlinePrice:", klineDTO);

    }
    public Map<String, KlineDTO> getKlineDataMap(){
        return KlinePriceDataMap;
    }
}