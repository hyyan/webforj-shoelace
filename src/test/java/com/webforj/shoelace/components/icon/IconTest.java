package com.webforj.shoelace.components.icon;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.ErrorEvent;
import com.webforj.shoelace.event.LoadEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IconTest {

  Icon component;

  @BeforeEach
  void setUp() {
    component = new Icon();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Icon.class, component));
    }

    @Test
    void shouldConstructWithName() {
      Icon icon = new Icon("arrow-right");
      assertEquals("arrow-right", icon.getName());
    }

    @Test
    void shouldConstructWithNameAndLibrary() {
      Icon icon = new Icon("arrow-right", "material");
      assertEquals("arrow-right", icon.getName());
      assertEquals("material", icon.getLibrary());
    }

    @Test
    void shouldChainSetters() {
      Icon result = component
          .setName("check")
          .setSrc("/icons/check.svg")
          .setLabel("Checkmark")
          .setLibrary("custom");

      assertEquals(component, result);
      assertEquals("check", component.getName());
      assertEquals("/icons/check.svg", component.getSrc());
      assertEquals("Checkmark", component.getLabel());
      assertEquals("custom", component.getLibrary());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddLoadListener() {
      component.onLoad(event -> {});
      assertEquals(1, component.getEventListeners(LoadEvent.class).size());
    }

    @Test
    void shouldAddLoadListenerViaAdd() {
      component.addLoadListener(event -> {});
      assertEquals(1, component.getEventListeners(LoadEvent.class).size());
    }

    @Test
    void shouldAddErrorListener() {
      component.onError(event -> {});
      assertEquals(1, component.getEventListeners(ErrorEvent.class).size());
    }

    @Test
    void shouldAddErrorListenerViaAdd() {
      component.addErrorListener(event -> {});
      assertEquals(1, component.getEventListeners(ErrorEvent.class).size());
    }
  }
}
