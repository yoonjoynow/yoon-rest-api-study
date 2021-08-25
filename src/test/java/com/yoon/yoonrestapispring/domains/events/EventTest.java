package com.yoon.yoonrestapispring.domains.events;

import junitparams.Parameters;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

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

    @Test
    public void isOffline_test() throws Exception {
        //given
        Event event1 = Event.builder()
                .location("강남역")
                .build();

        Event event2 = Event.builder()
                .location("")
                .build();

        Event event3 = Event.builder()
                .location(" ")
                .build();

        Event event4 = Event.builder()
                .build();

        //when
        event1.update();
        event2.update();
        event3.update();
        event4.update();

        //then
        assertThat(event1.isOffline()).isTrue();
        assertThat(event2.isOffline()).isFalse();
        assertThat(event3.isOffline()).isFalse();
        assertThat(event4.isOffline()).isFalse();
    }


}