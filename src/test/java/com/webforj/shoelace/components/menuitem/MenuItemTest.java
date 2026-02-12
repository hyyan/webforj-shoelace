package com.webforj.shoelace.components.menuitem;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuItemTest {

  MenuItem component;

  @BeforeEach
  void setUp() {
    component = new MenuItem();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(MenuItem.class, component));
    }

    @Test
    void shouldConstructWithText() {
      MenuItem item = new MenuItem("Copy");
      assertEquals("Copy", item.getText());
    }

    @Test
    void shouldConstructWithTextAndValue() {
      MenuItem item = new MenuItem("Copy", "copy");
      assertEquals("Copy", item.getText());
      assertEquals("copy", item.getValue());
    }

    @Test
    void shouldChainSetters() {
      MenuItem result = component
          .setType(MenuItemType.CHECKBOX)
          .setChecked(true)
          .setValue("option-1")
          .setLoading(true)
          .setDisabled(true)
          .setHref("https://example.com")
          .setTarget("_blank")
          .setRel("noreferrer")
          .setDownload("file.pdf");

      assertEquals(component, result);
      assertEquals(MenuItemType.CHECKBOX, component.getType());
      assertEquals(true, component.isChecked());
      assertEquals("option-1", component.getValue());
      assertEquals(true, component.isLoading());
      assertEquals(true, component.isDisabled());
      assertEquals("https://example.com", component.getHref());
      assertEquals("_blank", component.getTarget());
      assertEquals("noreferrer", component.getRel());
      assertEquals("file.pdf", component.getDownload());
    }
  }
}
