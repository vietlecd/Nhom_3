package com.javaweb.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funding_interval")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FundingInterval {

    @Id
    private Long id;

    private String symbol;
    private String adjustedFundingRateCap;
    private String adjustedFundingRateFloor;
    private Long fundingIntervalHours;
}
