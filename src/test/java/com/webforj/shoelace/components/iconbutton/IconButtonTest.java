package com.webforj.shoelace.components.iconbutton;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.button.Target;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IconButtonTest {

  IconButton component;

  @BeforeEach
  void setUp() {
    component = new IconButton();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(IconButton.class, component));
    }

    @Test
    void shouldConstructWithName() {
      IconButton button = new IconButton("gear");
      assertEquals("gear", button.getName());
    }

    @Test
    void shouldConstructWithNameAndLabel() {
      IconButton button = new IconButton("gear", "Settings");
      assertEquals("gear", button.getName());
      assertEquals("Settings", button.getLabel());
    }

    @Test
    void shouldChainSetters() {
      IconButton result = component
          .setName("trash")
          .setLibrary("material")
          .setSrc("/icons/trash.svg")
          .setHref("https://example.com")
          .setTarget(Target.BLANK)
          .setDownload("file.pdf")
          .setLabel("Delete")
          .setDisabled(true);

      assertEquals(component, result);
      assertEquals("trash", component.getName());
      assertEquals("material", component.getLibrary());
      assertEquals("/icons/trash.svg", component.getSrc());
      assertEquals("https://example.com", component.getHref());
      assertEquals(Target.BLANK, component.getTarget());
      assertEquals("file.pdf", component.getDownload());
      assertEquals("Delete", component.getLabel());
      assertEquals(true, component.isDisabled());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddBlurListener() {
      component.onBlur(event -> {});
      assertEquals(1, component.getEventListeners(BlurEvent.class).size());
    }

    @Test
    void shouldAddBlurListenerViaAdd() {
      component.addBlurListener(event -> {});
      assertEquals(1, component.getEventListeners(BlurEvent.class).size());
    }

    @Test
    void shouldAddFocusListener() {
      component.onFocus(event -> {});
      assertEquals(1, component.getEventListeners(FocusEvent.class).size());
    }

    @Test
    void shouldAddFocusListenerViaAdd() {
      component.addFocusListener(event -> {});
      assertEquals(1, component.getEventListeners(FocusEvent.class).size());
    }
  }
}
