package com.javaweb.helpers.service;

<<<<<<< HEAD

import com.javaweb.dto.KlineDTO;

public class KlineDTOHelper {

    public static KlineDTO createKlineDTO(String symbol, String openPrice, String closePrice, String highPrice, String lowPrice, String volume, String numberOfTrades,
                                          String isKlineClosed,
                                          String baseAssetVolume,
                                          String takerBuyVolume,
                                          String takerBuyBaseVolume,
                                          String eventTime,
                                          String klineStartTime,
                                          String klineCloseTime ) {
        return new KlineDTO.Builder()
                .symbol(symbol)
                .eventTime(eventTime)
=======
import com.javaweb.dto.KlineDTO;

public class KlineDTOHelper {
    public static KlineDTO createKlineDTO(String symbol, Long klineStartTime, Long klineCloseTime, String openPrice, String closePrice, String highPrice, String lowPrice, Long numberOfTrades, String baseAssetVolume, String takerBuyVolume, String takerBuyBaseVolume, String volume, String eventTime) {
        return new KlineDTO.Builder()
                .symbol(symbol)
                .eventTime(eventTime)
                .klineStartTime(klineStartTime)
                .klineCloseTime(klineCloseTime)
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
                .openPrice(openPrice)
                .closePrice(closePrice)
                .highPrice(highPrice)
                .lowPrice(lowPrice)
<<<<<<< HEAD
                .volume(volume)
                .numberOfTrades(numberOfTrades)
                .isKlineClosed(isKlineClosed)
                .baseAssetVolume(baseAssetVolume)
                .takerBuyBaseVolume(takerBuyBaseVolume)
                .takerBuyVolume(takerBuyVolume)
                .klineCloseTime(klineCloseTime)
                .klineStartTime(klineStartTime)

                .build();
    }

=======
                .numberOfTrades(numberOfTrades)
                .baseAssetVolume(baseAssetVolume)
                .takerBuyVolume(takerBuyVolume)
                .takerBuyBaseVolume(takerBuyBaseVolume)
                .volume(volume)
                .build();
    }
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
}
