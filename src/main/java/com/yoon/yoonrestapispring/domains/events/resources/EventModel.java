package com.yoon.yoonrestapispring.domains.events.resources;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.yoon.yoonrestapispring.domains.events.Event;
import com.yoon.yoonrestapispring.domains.events.EventController;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
public class EventModel extends RepresentationModel<EventModel> {

    @JsonUnwrapped
    private Event event;

    public EventModel(Event event) {
        this.event = event;
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}
