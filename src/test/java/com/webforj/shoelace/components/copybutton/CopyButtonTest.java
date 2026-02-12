package com.webforj.shoelace.components.copybutton;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.copybutton.event.CopyErrorEvent;
import com.webforj.shoelace.components.copybutton.event.CopySuccessEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CopyButtonTest {

  CopyButton component;

  @BeforeEach
  void setUp() {
    component = new CopyButton();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(CopyButton.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      CopyButton copyButton = new CopyButton("Hello, World!");
      assertEquals("Hello, World!", copyButton.getValue());
    }

    @Test
    void shouldChainSetters() {
      CopyButton result = component
          .setValue("copy me")
          .setFrom("source-element")
          .setDisabled(true)
          .setCopyLabel("Copy")
          .setSuccessLabel("Copied!")
          .setErrorLabel("Error!")
          .setFeedbackDuration(2000)
          .setTooltipPlacement(TooltipPlacement.BOTTOM)
          .setHoist(true);

      assertEquals(component, result);
      assertEquals("copy me", component.getValue());
      assertEquals("source-element", component.getFrom());
      assertEquals(true, component.isDisabled());
      assertEquals("Copy", component.getCopyLabel());
      assertEquals("Copied!", component.getSuccessLabel());
      assertEquals("Error!", component.getErrorLabel());
      assertEquals(2000, component.getFeedbackDuration());
      assertEquals(TooltipPlacement.BOTTOM, component.getTooltipPlacement());
      assertEquals(true, component.isHoist());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddCopySuccessListener() {
      component.onCopySuccess(event -> {});
      assertEquals(1, component.getEventListeners(CopySuccessEvent.class).size());
    }

    @Test
    void shouldAddCopySuccessListenerViaAdd() {
      component.addCopySuccessListener(event -> {});
      assertEquals(1, component.getEventListeners(CopySuccessEvent.class).size());
    }

    @Test
    void shouldAddCopyErrorListener() {
      component.onCopyError(event -> {});
      assertEquals(1, component.getEventListeners(CopyErrorEvent.class).size());
    }

    @Test
    void shouldAddCopyErrorListenerViaAdd() {
      component.addCopyErrorListener(event -> {});
      assertEquals(1, component.getEventListeners(CopyErrorEvent.class).size());
    }
  }
}
