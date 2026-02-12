package com.webforj.shoelace.components.formatdate;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.annotation.PropertyExclude;

/**
 * Shoelace FormatDate component ({@code <sl-format-date>}).
 *
 * <p>Formats a date/time using the specified locale and options. The date can be provided as an
 * ISO 8601 string. Formatting is handled by the
 * {@code Intl.DateTimeFormat} API.</p>
 *
 * @see <a href="https://shoelace.style/components/format-date">Shoelace FormatDate</a>
 */
@NodeName("sl-format-date")
public final class FormatDate extends ElementComposite {

  private final PropertyDescriptor<String> dateProp =
      PropertyDescriptor.property("date", "");
  @PropertyExclude
  private final PropertyDescriptor<NarrowShortLong> weekdayProp =
      PropertyDescriptor.property("weekday", null);
  @PropertyExclude
  private final PropertyDescriptor<NarrowShortLong> eraProp =
      PropertyDescriptor.property("era", null);
  @PropertyExclude
  private final PropertyDescriptor<NumericTwoDigit> yearProp =
      PropertyDescriptor.property("year", null);
  @PropertyExclude
  private final PropertyDescriptor<MonthFormat> monthProp =
      PropertyDescriptor.property("month", null);
  @PropertyExclude
  private final PropertyDescriptor<NumericTwoDigit> dayProp =
      PropertyDescriptor.property("day", null);
  @PropertyExclude
  private final PropertyDescriptor<NumericTwoDigit> hourProp =
      PropertyDescriptor.property("hour", null);
  @PropertyExclude
  private final PropertyDescriptor<NumericTwoDigit> minuteProp =
      PropertyDescriptor.property("minute", null);
  @PropertyExclude
  private final PropertyDescriptor<NumericTwoDigit> secondProp =
      PropertyDescriptor.property("second", null);

  @PropertyExclude
  private final PropertyDescriptor<Integer> fractionalSecondDigitsProp =
      PropertyDescriptor.property("fractionalSecondDigits", null);

  @PropertyExclude
  private final PropertyDescriptor<TimeZoneNameFormat> timeZoneNameProp =
      PropertyDescriptor.property("timeZoneName", null);
  private final PropertyDescriptor<String> timeZoneProp =
      PropertyDescriptor.property("timeZone", "");
  private final PropertyDescriptor<HourFormat> hourFormatProp =
      PropertyDescriptor.property("hourFormat", HourFormat.AUTO);
  private final PropertyDescriptor<String> langProp =
      PropertyDescriptor.property("lang", "");

  /**
   * Creates a new FormatDate.
   */
  public FormatDate() {
    super();
  }

  /**
   * Creates a new FormatDate with the given date string.
   *
   * @param date the ISO 8601 date string
   */
  public FormatDate(String date) {
    this();
    setDate(date);
  }

  /**
   * Gets the date/time to format.
   *
   * @return the date string
   */
  public String getDate() {
    return get(dateProp);
  }

  /**
   * Sets the date/time to format. When passing a string, it's strongly recommended to use the
   * ISO 8601 format to ensure timezones are handled correctly.
   *
   * @param date the ISO 8601 date string
   * @return this component
   */
  public FormatDate setDate(String date) {
    set(dateProp, date);
    return this;
  }

  /**
   * Gets the format for displaying the weekday.
   *
   * @return the weekday format
   */
  public NarrowShortLong getWeekday() {
    return get(weekdayProp);
  }

  /**
   * Sets the format for displaying the weekday.
   *
   * @param weekday the weekday format
   * @return this component
   */
  public FormatDate setWeekday(NarrowShortLong weekday) {
    set(weekdayProp, weekday);
    return this;
  }

  /**
   * Gets the format for displaying the era.
   *
   * @return the era format
   */
  public NarrowShortLong getEra() {
    return get(eraProp);
  }

  /**
   * Sets the format for displaying the era.
   *
   * @param era the era format
   * @return this component
   */
  public FormatDate setEra(NarrowShortLong era) {
    set(eraProp, era);
    return this;
  }

  /**
   * Gets the format for displaying the year.
   *
   * @return the year format
   */
  public NumericTwoDigit getYear() {
    return get(yearProp);
  }

  /**
   * Sets the format for displaying the year.
   *
   * @param year the year format
   * @return this component
   */
  public FormatDate setYear(NumericTwoDigit year) {
    set(yearProp, year);
    return this;
  }

  /**
   * Gets the format for displaying the month.
   *
   * @return the month format
   */
  public MonthFormat getMonth() {
    return get(monthProp);
  }

  /**
   * Sets the format for displaying the month.
   *
   * @param month the month format
   * @return this component
   */
  public FormatDate setMonth(MonthFormat month) {
    set(monthProp, month);
    return this;
  }

  /**
   * Gets the format for displaying the day.
   *
   * @return the day format
   */
  public NumericTwoDigit getDay() {
    return get(dayProp);
  }

  /**
   * Sets the format for displaying the day.
   *
   * @param day the day format
   * @return this component
   */
  public FormatDate setDay(NumericTwoDigit day) {
    set(dayProp, day);
    return this;
  }

  /**
   * Gets the format for displaying the hour.
   *
   * @return the hour format
   */
  public NumericTwoDigit getHour() {
    return get(hourProp);
  }

  /**
   * Sets the format for displaying the hour.
   *
   * @param hour the hour format
   * @return this component
   */
  public FormatDate setHour(NumericTwoDigit hour) {
    set(hourProp, hour);
    return this;
  }

  /**
   * Gets the format for displaying the minute.
   *
   * @return the minute format
   */
  public NumericTwoDigit getMinute() {
    return get(minuteProp);
  }

  /**
   * Sets the format for displaying the minute.
   *
   * @param minute the minute format
   * @return this component
   */
  public FormatDate setMinute(NumericTwoDigit minute) {
    set(minuteProp, minute);
    return this;
  }

  /**
   * Gets the format for displaying the second.
   *
   * @return the second format
   */
  public NumericTwoDigit getSecond() {
    return get(secondProp);
  }

  /**
   * Sets the format for displaying the second.
   *
   * @param second the second format
   * @return this component
   */
  public FormatDate setSecond(NumericTwoDigit second) {
    set(secondProp, second);
    return this;
  }

  /**
   * Gets the number of fractional second digits to display.
   *
   * @return the number of fractional second digits
   */
  public Integer getFractionalSecondDigits() {
    return get(fractionalSecondDigitsProp);
  }

  /**
   * Sets the number of fractional second digits to display.
   *
   * @param fractionalSecondDigits the number of fractional second digits
   * @return this component
   */
  public FormatDate setFractionalSecondDigits(Integer fractionalSecondDigits) {
    set(fractionalSecondDigitsProp, fractionalSecondDigits);
    return this;
  }

  /**
   * Gets the format for displaying the time zone name.
   *
   * @return the time zone name format
   */
  public TimeZoneNameFormat getTimeZoneName() {
    return get(timeZoneNameProp);
  }

  /**
   * Sets the format for displaying the time zone name.
   *
   * @param timeZoneName the time zone name format
   * @return this component
   */
  public FormatDate setTimeZoneName(TimeZoneNameFormat timeZoneName) {
    set(timeZoneNameProp, timeZoneName);
    return this;
  }

  /**
   * Gets the time zone to express the time in.
   *
   * @return the time zone
   */
  public String getTimeZone() {
    return get(timeZoneProp);
  }

  /**
   * Sets the time zone to express the time in.
   *
   * @param timeZone the IANA time zone identifier
   * @return this component
   */
  public FormatDate setTimeZone(String timeZone) {
    set(timeZoneProp, timeZone);
    return this;
  }

  /**
   * Gets the hour format.
   *
   * @return the hour format
   */
  public HourFormat getHourFormat() {
    return get(hourFormatProp);
  }

  /**
   * Sets the hour format for displaying the time.
   *
   * @param hourFormat the hour format
   * @return this component
   */
  public FormatDate setHourFormat(HourFormat hourFormat) {
    set(hourFormatProp, hourFormat);
    return this;
  }

  /**
   * Gets the locale language tag.
   *
   * @return the language tag
   */
  public String getLang() {
    return get(langProp);
  }

  /**
   * Sets the locale language tag to use for formatting.
   *
   * @param lang the BCP 47 language tag
   * @return this component
   */
  public FormatDate setLang(String lang) {
    set(langProp, lang);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
