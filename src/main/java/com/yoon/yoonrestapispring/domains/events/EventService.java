package com.yoon.yoonrestapispring.domains.events;

import com.yoon.yoonrestapispring.domains.events.dto.EventCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public Event save(EventCreateDto dto) {
        Event event = dto.toEntity();
        event.update();
        return eventRepository.save(event);
    }

}
