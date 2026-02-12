package com.webforj.shoelace.components.qrcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QrCodeTest {

  QrCode component;

  @BeforeEach
  void setUp() {
    component = new QrCode();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(QrCode.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      QrCode qrCode = new QrCode("https://example.com");
      assertEquals("https://example.com", qrCode.getValue());
    }

    @Test
    void shouldChainSetters() {
      QrCode result = component
          .setValue("https://example.com")
          .setLabel("Example QR Code")
          .setSize(256)
          .setFill("#000000")
          .setBackground("#ffffff")
          .setRadius(0.5)
          .setErrorCorrection(ErrorCorrectionLevel.LOW);

      assertEquals(component, result);
      assertEquals("https://example.com", component.getValue());
      assertEquals("Example QR Code", component.getLabel());
      assertEquals(256, component.getSize());
      assertEquals("#000000", component.getFill());
      assertEquals("#ffffff", component.getBackground());
      assertEquals(0.5, component.getRadius());
      assertEquals(ErrorCorrectionLevel.LOW, component.getErrorCorrection());
    }
  }
}
