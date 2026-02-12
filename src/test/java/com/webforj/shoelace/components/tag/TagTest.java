package com.webforj.shoelace.components.tag;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.components.tag.event.RemoveEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TagTest {

  Tag component;

  @BeforeEach
  void setUp() {
    component = new Tag();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Tag.class, component));
    }

    @Test
    void shouldChainSetters() {
      Tag result = component
          .setVariant(TagVariant.DANGER)
          .setSize(Size.LARGE)
          .setPill(true)
          .setRemovable(true);

      assertEquals(component, result);
      assertEquals(TagVariant.DANGER, component.getVariant());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isPill());
      assertEquals(true, component.isRemovable());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddRemoveListener() {
      component.onRemove(event -> {});
      assertEquals(1, component.getEventListeners(RemoveEvent.class).size());
    }

    @Test
    void shouldAddRemoveListenerViaAdd() {
      component.addRemoveListener(event -> {});
      assertEquals(1, component.getEventListeners(RemoveEvent.class).size());
    }
  }
}
