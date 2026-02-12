package com.webforj.shoelace.components.formatbytes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FormatBytesTest {

  FormatBytes component;

  @BeforeEach
  void setUp() {
    component = new FormatBytes();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(FormatBytes.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      FormatBytes fb = new FormatBytes(1024);
      assertEquals(1024.0, fb.getValue());
    }

    @Test
    void shouldChainSetters() {
      FormatBytes result = component
          .setValue(2048)
          .setUnit(ByteUnit.BIT)
          .setDisplay(ByteDisplay.LONG)
          .setLang("de");

      assertEquals(component, result);
      assertEquals(2048.0, component.getValue());
      assertEquals(ByteUnit.BIT, component.getUnit());
      assertEquals(ByteDisplay.LONG, component.getDisplay());
      assertEquals("de", component.getLang());
    }
  }
}
