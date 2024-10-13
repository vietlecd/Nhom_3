package com.javaweb.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@Getter
@JsonDeserialize(builder = KlineDTO.Builder.class)
public class KlineDTO {

    private final String symbol;
    private final String openPrice;
    private final String highPrice;
    private final String lowPrice;
    private final String closePrice;
    private final String volume;
    private final String numberOfTrades;
    private final String isKlineClosed;
    private final String baseAssetVolume;
    private final String takerBuyVolume;
    private final String takerBuyBaseVolume;
    private final String eventTime;
    private final String klineStartTime;
    private final String klineCloseTime;

    // Private constructor accessible only through the Builder
    private KlineDTO(Builder builder) {
        this.symbol = builder.symbol;
        this.openPrice = builder.openPrice;
        this.highPrice = builder.highPrice;
        this.lowPrice = builder.lowPrice;
        this.closePrice = builder.closePrice;
        this.volume = builder.volume;
        this.numberOfTrades = builder.numberOfTrades;
        this.isKlineClosed = builder.isKlineClosed;
        this.baseAssetVolume = builder.baseAssetVolume;
        this.takerBuyVolume = builder.takerBuyVolume;
        this.takerBuyBaseVolume = builder.takerBuyBaseVolume;
        this.eventTime = builder.eventTime;
        this.klineStartTime = builder.klineStartTime;
        this.klineCloseTime = builder.klineCloseTime;
    }


    // Static inner Builder class
    public static class Builder {

        private String symbol;
        private String openPrice;
        private String highPrice;
        private String lowPrice;
        private String closePrice;
        private String volume;
        private String numberOfTrades;
        private String isKlineClosed;
        private String baseAssetVolume;
        private String takerBuyVolume;
        private String takerBuyBaseVolume;
        private String eventTime;
        private String klineStartTime;
        private String klineCloseTime;

        // Setter methods that return the builder itself for chaining
        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder openPrice(String openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        public Builder highPrice(String highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public Builder lowPrice(String lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        public Builder closePrice(String closePrice) {
            this.closePrice = closePrice;
            return this;
        }

        public Builder volume(String volume) {
            this.volume = volume;
            return this;
        }

        public Builder numberOfTrades(String numberOfTrades) {
            this.numberOfTrades = numberOfTrades;
            return this;
        }

        public Builder isKlineClosed(String isKlineClosed) {
            this.isKlineClosed = isKlineClosed;
            return this;
        }

        public Builder baseAssetVolume(String baseAssetVolume) {
            this.baseAssetVolume = baseAssetVolume;
            return this;
        }

        public Builder takerBuyVolume(String takerBuyVolume) {
            this.takerBuyVolume = takerBuyVolume;
            return this;
        }

        public Builder takerBuyBaseVolume(String takerBuyBaseVolume) {
            this.takerBuyBaseVolume = takerBuyBaseVolume;
            return this;
        }



        public Builder  klineStartTime(String klineStartTime) {
            this.klineStartTime = klineStartTime;
            return this;
        }

        public Builder klineCloseTime(String klineCloseTime) {
            this.klineCloseTime = klineCloseTime;
            return this;
        }

        // Build method that returns the constructed KlineDTO
        public KlineDTO build() {
            return new KlineDTO(this);
        }

        public Builder eventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }
    }
}
