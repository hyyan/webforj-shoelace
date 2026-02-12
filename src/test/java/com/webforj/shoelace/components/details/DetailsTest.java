package com.webforj.shoelace.components.details;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.ShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DetailsTest {

  Details component;

  @BeforeEach
  void setUp() {
    component = new Details();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Details.class, component));
    }

    @Test
    void shouldConstructWithSummary() {
      Details details = new Details("Toggle Me");
      assertEquals("Toggle Me", details.getSummary());
    }

    @Test
    void shouldDefaultToClosed() {
      assertFalse(component.isOpen());
    }

    @Test
    void shouldDefaultToEnabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldChainSetters() {
      Details result = component
          .setOpen(true)
          .setSummary("My Summary")
          .setDisabled(false);

      assertEquals(component, result);
      assertTrue(component.isOpen());
      assertEquals("My Summary", component.getSummary());
      assertFalse(component.isDisabled());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddShowListener() {
      component.onShow(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddShowListenerViaAdd() {
      component.addShowListener(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListener() {
      component.onAfterShow(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListenerViaAdd() {
      component.addAfterShowListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddHideListener() {
      component.onHide(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddHideListenerViaAdd() {
      component.addHideListener(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListener() {
      component.onAfterHide(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListenerViaAdd() {
      component.addAfterHideListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
    }
  }
}
