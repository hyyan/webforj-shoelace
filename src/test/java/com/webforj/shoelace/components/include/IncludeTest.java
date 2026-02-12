package com.webforj.shoelace.components.include;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.ErrorEvent;
import com.webforj.shoelace.event.LoadEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IncludeTest {

  Include component;

  @BeforeEach
  void setUp() {
    component = new Include();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Include.class, component));
    }

    @Test
    void shouldConstructWithSrc() {
      Include include = new Include("/content.html");
      assertEquals("/content.html", include.getSrc());
    }

    @Test
    void shouldDefaultToCorsFetchMode() {
      assertEquals(IncludeMode.CORS, component.getMode());
    }

    @Test
    void shouldDefaultToDisallowScripts() {
      assertFalse(component.isAllowScripts());
    }

    @Test
    void shouldChainSetters() {
      Include result = component
          .setSrc("/page.html")
          .setMode(IncludeMode.SAME_ORIGIN)
          .setAllowScripts(true);

      assertEquals(component, result);
      assertEquals("/page.html", component.getSrc());
      assertEquals(IncludeMode.SAME_ORIGIN, component.getMode());
      assertEquals(true, component.isAllowScripts());
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
