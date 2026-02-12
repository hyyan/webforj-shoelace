package com.webforj.shoelace.components.relativetime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RelativeTimeTest {

  RelativeTime component;

  @BeforeEach
  void setUp() {
    component = new RelativeTime();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(RelativeTime.class, component));
    }

    @Test
    void shouldConstructWithDate() {
      RelativeTime rt = new RelativeTime("2025-01-15T12:00:00Z");
      assertEquals("2025-01-15T12:00:00Z", rt.getDate());
    }

    @Test
    void shouldDefaultSyncToFalse() {
      assertFalse(component.isSync());
    }

    @Test
    void shouldSetSync() {
      component.setSync(true);
      assertTrue(component.isSync());
    }

    @Test
    void shouldChainSetters() {
      RelativeTime result = component
          .setDate("2024-12-25T00:00:00Z")
          .setLang("es")
          .setFormat(RelativeTimeFormat.SHORT)
          .setNumeric(RelativeTimeNumeric.ALWAYS)
          .setSync(true);

      assertEquals(component, result);
      assertEquals("2024-12-25T00:00:00Z", component.getDate());
      assertEquals("es", component.getLang());
      assertEquals(RelativeTimeFormat.SHORT, component.getFormat());
      assertEquals(RelativeTimeNumeric.ALWAYS, component.getNumeric());
      assertTrue(component.isSync());
    }
  }
}
