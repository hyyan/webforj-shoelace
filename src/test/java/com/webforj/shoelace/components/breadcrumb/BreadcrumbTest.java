package com.webforj.shoelace.components.breadcrumb;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BreadcrumbTest {

  Breadcrumb component;

  @BeforeEach
  void setUp() {
    component = new Breadcrumb();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Breadcrumb.class, component));
    }

    @Test
    void shouldChainSetters() {
      Breadcrumb result = component.setLabel("Navigation");

      assertEquals(component, result);
      assertEquals("Navigation", component.getLabel());
    }
  }
}
