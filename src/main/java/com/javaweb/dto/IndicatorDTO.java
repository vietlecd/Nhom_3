package com.javaweb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonDeserialize(builder = IndicatorDTO.Builder.class)
public class IndicatorDTO {
    private final Map<String, Object> values;
    private final String eventTime;

    private IndicatorDTO(Builder builder) {
        this.values = builder.values;
        this.eventTime = builder.eventTime;
    }

    public static class Builder {
        private Map<String, Object> values;
        private String eventTime;

        public Builder values(Map<String, Object> values) {
            this.values = values;
            return this;
        }

        public Builder eventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public IndicatorDTO build() {
            return new IndicatorDTO(this);
        }
    }
}
