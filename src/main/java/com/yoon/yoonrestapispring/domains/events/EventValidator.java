package com.yoon.yoonrestapispring.domains.events;

import com.yoon.yoonrestapispring.domains.events.dto.EventCreateDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventCreateDto dto, Errors errors) {
        if (dto.getBasePrice() > dto.getMaxPrice() && dto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
//            errors.reject("wrongPrices", "prices are wrong");
        }

        LocalDateTime endEventDateTime = dto.getEndEventDateTime();
        if (endEventDateTime.isBefore(dto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(dto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(dto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong");
        }

        // TODO beginEventTime
        // TODO closeEnrollmentDateTime
    }

}
