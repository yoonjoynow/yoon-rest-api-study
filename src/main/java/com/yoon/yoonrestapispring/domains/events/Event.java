package com.yoon.yoonrestapispring.domains.events;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@Getter
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    private EventStatus eventStatus = EventStatus.DRAFT;

    @Builder
    public Event(Integer id, String name, String description, LocalDateTime beginEnrollmentDateTime, LocalDateTime closeEnrollmentDateTime, LocalDateTime beginEventDateTime, LocalDateTime endEventDateTime, String location, int basePrice, int maxPrice, int limitOfEnrollment, boolean offline, boolean free, EventStatus eventStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.beginEnrollmentDateTime = beginEnrollmentDateTime;
        this.closeEnrollmentDateTime = closeEnrollmentDateTime;
        this.beginEventDateTime = beginEventDateTime;
        this.endEventDateTime = endEventDateTime;
        this.location = location;
        this.basePrice = basePrice;
        this.maxPrice = maxPrice;
        this.limitOfEnrollment = limitOfEnrollment;
        this.offline = offline;
        this.free = free;
    }

    public void update() {
        this.free = this.basePrice == 0 && this.maxPrice == 0;
        this.offline = this.location != null && !this.location.isBlank();
    }

}
