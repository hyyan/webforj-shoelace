package com.webforj.shoelace.components.formatnumber;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FormatNumberTest {

  FormatNumber component;

  @BeforeEach
  void setUp() {
    component = new FormatNumber();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(FormatNumber.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      FormatNumber fn = new FormatNumber(1234.56);
      assertEquals(1234.56, fn.getValue());
    }

    @Test
    void shouldDefaultNoGroupingToFalse() {
      assertFalse(component.isNoGrouping());
    }

    @Test
    void shouldSetNoGrouping() {
      component.setNoGrouping(true);
      assertTrue(component.isNoGrouping());
    }

    @Test
    void shouldChainSetters() {
      FormatNumber result = component
          .setValue(9999.99)
          .setType(NumberType.CURRENCY)
          .setNoGrouping(true)
          .setCurrency("EUR")
          .setCurrencyDisplay(CurrencyDisplay.CODE)
          .setMinimumIntegerDigits(2)
          .setMinimumFractionDigits(1)
          .setMaximumFractionDigits(3)
          .setMinimumSignificantDigits(1)
          .setMaximumSignificantDigits(5)
          .setLang("fr");

      assertEquals(component, result);
      assertEquals(9999.99, component.getValue());
      assertEquals(NumberType.CURRENCY, component.getType());
      assertTrue(component.isNoGrouping());
      assertEquals("EUR", component.getCurrency());
      assertEquals(CurrencyDisplay.CODE, component.getCurrencyDisplay());
      assertEquals(2, component.getMinimumIntegerDigits());
      assertEquals(1, component.getMinimumFractionDigits());
      assertEquals(3, component.getMaximumFractionDigits());
      assertEquals(1, component.getMinimumSignificantDigits());
      assertEquals(5, component.getMaximumSignificantDigits());
      assertEquals("fr", component.getLang());
    }
  }
}
