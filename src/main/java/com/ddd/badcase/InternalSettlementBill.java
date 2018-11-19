package com.ddd.badcase;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:49
 */

@Data
public class InternalSettlementBill {
    private String billNumber;
    private String newAndOldBillNumber;
    private String flightIdentity;
    private String flightNumber;
    private String flightRoute;
    private String scheduledDate;
    private String passengerClass;
    private List<Passenger> passengers;
    private String serviceReason;
    private List<CostDetail> costDetails;
    private BigDecimal totalCost;

    private class Passenger {
    }

    private class CostDetail {
    }
}