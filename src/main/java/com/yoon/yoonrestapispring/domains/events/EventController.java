package com.yoon.yoonrestapispring.domains.events;

import com.yoon.yoonrestapispring.domains.events.dto.EventCreateDto;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping(value = "/api/events/", produces = MediaTypes.HAL_JSON_VALUE)
@Controller
public class EventController {

    @PostMapping
    public ResponseEntity<Object> createEvent(EventCreateDto dto) throws NoSuchFieldException, IllegalAccessException {
        URI uri = linkTo(EventController.class).slash("{id}").toUri();

        Event event = dto.toEntity();
        Field id = event.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(event, 1);

        return ResponseEntity.created(uri).body(event);
    }

}
