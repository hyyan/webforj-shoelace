package com.webforj.shoelace.components.option;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OptionTest {

  Option component;

  @BeforeEach
  void setUp() {
    component = new Option();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Option.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      Option option = new Option("opt1");
      assertEquals("opt1", option.getValue());
    }

    @Test
    void shouldConstructWithValueAndLabel() {
      Option option = new Option("opt1", "Option One");
      assertEquals("opt1", option.getValue());
    }

    @Test
    void shouldChainSetters() {
      Option result = component
          .setValue("opt1")
          .setDisabled(true);

      assertEquals(component, result);
      assertEquals("opt1", component.getValue());
      assertEquals(true, component.isDisabled());
    }
  }
}
