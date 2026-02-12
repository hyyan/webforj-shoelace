package com.webforj.shoelace.components.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.shoelace.components.menu.event.SelectEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuTest {

  Menu component;

  @BeforeEach
  void setUp() {
    component = new Menu();
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddSelectListener() {
      component.onSelect(event -> {});
      assertEquals(1, component.getEventListeners(SelectEvent.class).size());
    }

    @Test
    void shouldAddSelectListenerViaAdd() {
      component.addSelectListener(event -> {});
      assertEquals(1, component.getEventListeners(SelectEvent.class).size());
    }
  }
}
