package com.webforj.shoelace.components.formatdate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FormatDateTest {

  FormatDate component;

  @BeforeEach
  void setUp() {
    component = new FormatDate();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(FormatDate.class, component));
    }

    @Test
    void shouldConstructWithDate() {
      FormatDate fd = new FormatDate("2025-01-15T12:00:00Z");
      assertEquals("2025-01-15T12:00:00Z", fd.getDate());
    }

    @Test
    void shouldChainSetters() {
      FormatDate result = component
          .setDate("2025-06-15T10:30:00Z")
          .setWeekday(NarrowShortLong.LONG)
          .setEra(NarrowShortLong.SHORT)
          .setYear(NumericTwoDigit.NUMERIC)
          .setMonth(MonthFormat.LONG)
          .setDay(NumericTwoDigit.NUMERIC)
          .setHour(NumericTwoDigit.TWO_DIGIT)
          .setMinute(NumericTwoDigit.TWO_DIGIT)
          .setSecond(NumericTwoDigit.TWO_DIGIT)
          .setFractionalSecondDigits(3)
          .setTimeZoneName(TimeZoneNameFormat.LONG)
          .setTimeZone("America/New_York")
          .setHourFormat(HourFormat.TWELVE)
          .setLang("en");

      assertEquals(component, result);
      assertEquals("2025-06-15T10:30:00Z", component.getDate());
      assertEquals(NarrowShortLong.LONG, component.getWeekday());
      assertEquals(NarrowShortLong.SHORT, component.getEra());
      assertEquals(NumericTwoDigit.NUMERIC, component.getYear());
      assertEquals(MonthFormat.LONG, component.getMonth());
      assertEquals(NumericTwoDigit.NUMERIC, component.getDay());
      assertEquals(NumericTwoDigit.TWO_DIGIT, component.getHour());
      assertEquals(NumericTwoDigit.TWO_DIGIT, component.getMinute());
      assertEquals(NumericTwoDigit.TWO_DIGIT, component.getSecond());
      assertEquals(3, component.getFractionalSecondDigits());
      assertEquals(TimeZoneNameFormat.LONG, component.getTimeZoneName());
      assertEquals("America/New_York", component.getTimeZone());
      assertEquals(HourFormat.TWELVE, component.getHourFormat());
      assertEquals("en", component.getLang());
    }
  }
}
