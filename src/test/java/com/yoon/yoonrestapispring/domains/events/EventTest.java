package com.yoon.yoonrestapispring.domains.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    public void hasBuilder_test() {
        Event event = Event.builder().build();
        assertThat(event).isNotNull();
    }

    @Test
    public void isJavaBean_test() {
        String name = "First Event";
        String description = "Spring";
        Event event = Event.builder()
                .name(name)
                .description(description)
                .build();
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);

    }

}