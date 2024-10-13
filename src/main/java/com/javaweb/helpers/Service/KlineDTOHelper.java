package com.javaweb.helpers.Service;

import com.javaweb.model.KlineDTO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateKline {
    private final Map<String, KlineDTO> priceDataMap = new ConcurrentHashMap<>();
    public void updateKlineData(String symbol, String openPrice, String closePrice, String highPrice, String lowPrice, String volume, String numberOfTrades,
                                String isKlineClosed,
                                String baseAssetVolume,
                                String takerBuyVolume,
                                String takerBuyBaseVolume,
                                String eventTime,
                                String klineStartTime,
                                String klineCloseTime ) {
        priceDataMap.put(symbol.toUpperCase(), new KlineDTO(symbol,
                openPrice,
                closePrice,
                highPrice,
                lowPrice,
                volume,
                numberOfTrades,
                isKlineClosed,
                baseAssetVolume,
                takerBuyVolume,
                takerBuyBaseVolume,
                eventTime,
                klineStartTime,
                klineCloseTime));
    }

}
