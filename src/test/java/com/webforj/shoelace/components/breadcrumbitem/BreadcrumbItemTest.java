package com.webforj.shoelace.components.breadcrumbitem;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BreadcrumbItemTest {

  BreadcrumbItem component;

  @BeforeEach
  void setUp() {
    component = new BreadcrumbItem();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(BreadcrumbItem.class, component));
    }

    @Test
    void shouldConstructWithText() {
      BreadcrumbItem item = new BreadcrumbItem("Home");
      assertEquals("Home", item.getText());
    }

    @Test
    void shouldConstructWithTextAndHref() {
      BreadcrumbItem item = new BreadcrumbItem("Home", "/");
      assertEquals("Home", item.getText());
      assertEquals("/", item.getHref());
    }

    @Test
    void shouldChainSetters() {
      BreadcrumbItem result = component
          .setHref("https://example.com")
          .setTarget(BreadcrumbItemTarget.BLANK)
          .setRel("nofollow");

      assertEquals(component, result);
      assertEquals("https://example.com", component.getHref());
      assertEquals(BreadcrumbItemTarget.BLANK, component.getTarget());
      assertEquals("nofollow", component.getRel());
    }
  }
}
