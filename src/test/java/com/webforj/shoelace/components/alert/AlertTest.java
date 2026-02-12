package com.webforj.shoelace.components.alert;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.ShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AlertTest {

  Alert component;

  @BeforeEach
  void setUp() {
    component = new Alert();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Alert.class, component));
    }

    @Test
    void shouldChainSetters() {
      Alert result = component
          .setOpen(true)
          .setClosable(true)
          .setVariant(AlertVariant.DANGER)
          .setDuration("5000")
          .setCountdown(AlertCountdown.RTL);

      assertEquals(component, result);
      assertEquals(true, component.isOpen());
      assertEquals(true, component.isClosable());
      assertEquals(AlertVariant.DANGER, component.getVariant());
      assertEquals("5000", component.getDuration());
      assertEquals(AlertCountdown.RTL, component.getCountdown());
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
