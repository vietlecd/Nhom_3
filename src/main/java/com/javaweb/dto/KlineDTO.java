package com.javaweb.dto;

<<<<<<< HEAD

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
=======
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
import lombok.Getter;

@Getter
@JsonDeserialize(builder = KlineDTO.Builder.class)
public class KlineDTO {
<<<<<<< HEAD

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
=======
    private String symbol;
    private String eventTime;
    private Long klineStartTime;
    private Long klineCloseTime;
    private String openPrice;
    private String closePrice;
    private String highPrice;
    private String lowPrice;
    private Long numberOfTrades;
    private String baseAssetVolume;
    private String takerBuyVolume;
    private String takerBuyBaseVolume;
    private String volume;

    private KlineDTO(Builder builder) {
        this.symbol = builder.symbol;
        this.eventTime = builder.eventTime;
        this.klineStartTime = builder.klineStartTime;
        this.klineCloseTime = builder.klineCloseTime;
        this.openPrice = builder.openPrice;
        this.closePrice = builder.closePrice;
        this.highPrice = builder.highPrice;
        this.lowPrice = builder.lowPrice;
        this.numberOfTrades = builder.numberOfTrades;
        this.baseAssetVolume = builder.baseAssetVolume;
        this.takerBuyVolume = builder.takerBuyVolume;
        this.takerBuyBaseVolume = builder.takerBuyBaseVolume;
        this.volume = builder.volume;
    }


    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String symbol;
        private String eventTime;
        private Long klineStartTime;
        private Long klineCloseTime;
        private String openPrice;
        private String closePrice;
        private String highPrice;
        private String lowPrice;
        private Long numberOfTrades;
        private String baseAssetVolume;
        private String takerBuyVolume;
        private String takerBuyBaseVolume;
        private String volume;

>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

<<<<<<< HEAD
=======
        public Builder eventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder klineStartTime(Long klineStartTime) {
            this.klineStartTime = klineStartTime;
            return this;
        }

        public Builder klineCloseTime(Long klineCloseTime) {
            this.klineCloseTime = klineCloseTime;
            return this;
        }

>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
        public Builder openPrice(String openPrice) {
            this.openPrice = openPrice;
            return this;
        }

<<<<<<< HEAD
=======
        public Builder closePrice(String closePrice) {
            this.closePrice = closePrice;
            return this;
        }

>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
        public Builder highPrice(String highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public Builder lowPrice(String lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

<<<<<<< HEAD
        public Builder closePrice(String closePrice) {
            this.closePrice = closePrice;
            return this;
        }

        public Builder volume(String volume) {
            this.volume = volume;
            return this;
        }

        public Builder numberOfTrades(String numberOfTrades) {
=======
        public Builder numberOfTrades(Long numberOfTrades) {
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
            this.numberOfTrades = numberOfTrades;
            return this;
        }

<<<<<<< HEAD
        public Builder isKlineClosed(String isKlineClosed) {
            this.isKlineClosed = isKlineClosed;
            return this;
        }

=======
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
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

<<<<<<< HEAD


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
=======
        public Builder volume(String volume) {
            this.volume = volume;
            return this;
        }

        public KlineDTO build() {
            return new KlineDTO(this);
        }
>>>>>>> 9afd360d4d882e38a47b62f4542c53eb5da010c4
    }
}
