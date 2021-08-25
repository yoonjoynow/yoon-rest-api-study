package com.yoon.yoonrestapispring.domains.events.dto;

import com.yoon.yoonrestapispring.domains.events.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EventResponseDto {

    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;

    public EventResponseDto(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.beginEnrollmentDateTime = event.getBeginEnrollmentDateTime();
        this.closeEnrollmentDateTime = event.getCloseEnrollmentDateTime();
        this.beginEventDateTime = event.getBeginEventDateTime();
        this.endEventDateTime = event.getEndEventDateTime();
        this.location = event.getLocation();
        this.basePrice = event.getBasePrice();
        this.maxPrice = event.getMaxPrice();
        this.limitOfEnrollment = event.getLimitOfEnrollment();
    }

}
