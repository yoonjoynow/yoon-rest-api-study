package com.yoon.yoonrestapispring.domains.events;

import com.yoon.yoonrestapispring.domains.events.dto.EventCreateDto;
import com.yoon.yoonrestapispring.domains.events.resources.EventModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RequestMapping(value = "/api/events/", produces = MediaTypes.HAL_JSON_VALUE)
@Controller
public class EventController {

    private final EventService eventService;
    private final EventValidator eventValidator;

    @PostMapping
    public ResponseEntity<Object> createEvent(@RequestBody @Valid EventCreateDto dto,
                                              Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        eventValidator.validate(dto, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Event savedEvent = eventService.save(dto);

        WebMvcLinkBuilder selfLinkBuilder = linkTo(EventController.class).slash(savedEvent.getId());
        URI createdUri = selfLinkBuilder.toUri();

        EventModel eventModel = new EventModel(savedEvent);
        eventModel.add(linkTo(EventController.class).withRel("query-events"));
        eventModel.add(selfLinkBuilder.withRel("update-event"));
        return ResponseEntity.created(createdUri).body(eventModel);
    }

}
