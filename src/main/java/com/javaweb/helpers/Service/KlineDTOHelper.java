package com.javaweb.helpers.Service;


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
                .openPrice(openPrice)
                .closePrice(closePrice)
                .highPrice(highPrice)
                .lowPrice(lowPrice)
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

}
