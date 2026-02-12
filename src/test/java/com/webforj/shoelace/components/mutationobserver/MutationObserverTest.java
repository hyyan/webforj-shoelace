package com.webforj.shoelace.components.mutationobserver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.mutationobserver.event.MutationEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MutationObserverTest {

  MutationObserver component;

  @BeforeEach
  void setUp() {
    component = new MutationObserver();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(MutationObserver.class, component));
    }

    @Test
    void shouldChainSetters() {
      MutationObserver result = component
          .setAttr("class id")
          .setAttrOldValue(true)
          .setCharData(true)
          .setCharDataOldValue(true)
          .setChildList(true)
          .setDisabled(true);

      assertEquals(component, result);
      assertEquals("class id", component.getAttr());
      assertEquals(true, component.isAttrOldValue());
      assertEquals(true, component.isCharData());
      assertEquals(true, component.isCharDataOldValue());
      assertEquals(true, component.isChildList());
      assertEquals(true, component.isDisabled());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddMutationListener() {
      component.onMutation(event -> {});
      assertEquals(1, component.getEventListeners(MutationEvent.class).size());
    }

    @Test
    void shouldAddMutationListenerViaAdd() {
      component.addMutationListener(event -> {});
      assertEquals(1, component.getEventListeners(MutationEvent.class).size());
    }
  }
}
