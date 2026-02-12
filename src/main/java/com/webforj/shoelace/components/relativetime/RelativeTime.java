package com.webforj.shoelace.components.relativetime;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;

/**
 * Shoelace RelativeTime component ({@code <sl-relative-time>}).
 *
 * <p>Outputs a localized time phrase relative to the current date and time. Formatting is handled
 * by the {@code Intl.RelativeTimeFormat} API.</p>
 *
 * @see <a href="https://shoelace.style/components/relative-time">Shoelace RelativeTime</a>
 */
@NodeName("sl-relative-time")
public final class RelativeTime extends ElementComposite {

  private final PropertyDescriptor<String> dateProp =
      PropertyDescriptor.property("date", "");
  private final PropertyDescriptor<String> langProp =
      PropertyDescriptor.property("lang", "");
  private final PropertyDescriptor<RelativeTimeFormat> formatProp =
      PropertyDescriptor.property("format", RelativeTimeFormat.LONG);
  private final PropertyDescriptor<RelativeTimeNumeric> numericProp =
      PropertyDescriptor.property("numeric", RelativeTimeNumeric.AUTO);
  private final PropertyDescriptor<Boolean> syncProp =
      PropertyDescriptor.property("sync", false);

  /**
   * Creates a new RelativeTime.
   */
  public RelativeTime() {
    super();
  }

  /**
   * Creates a new RelativeTime with the given date string.
   *
   * @param date the ISO 8601 date string
   */
  public RelativeTime(String date) {
    this();
    setDate(date);
  }

  /**
   * Gets the date from which to calculate relative time.
   *
   * @return the date string
   */
  public String getDate() {
    return get(dateProp);
  }

  /**
   * Sets the date from which to calculate time from. When passing a string, it's strongly
   * recommended to use the ISO 8601 format to ensure timezones are handled correctly.
   *
   * @param date the ISO 8601 date string
   * @return this component
   */
  public RelativeTime setDate(String date) {
    set(dateProp, date);
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
  public RelativeTime setLang(String lang) {
    set(langProp, lang);
    return this;
  }

  /**
   * Gets the formatting style.
   *
   * @return the format
   */
  public RelativeTimeFormat getFormat() {
    return get(formatProp);
  }

  /**
   * Sets the formatting style to use.
   *
   * @param format the format
   * @return this component
   */
  public RelativeTime setFormat(RelativeTimeFormat format) {
    set(formatProp, format);
    return this;
  }

  /**
   * Gets the numeric display mode.
   *
   * @return the numeric mode
   */
  public RelativeTimeNumeric getNumeric() {
    return get(numericProp);
  }

  /**
   * Sets the numeric display mode. When {@code auto}, values such as "yesterday" and "tomorrow"
   * will be shown when possible. When {@code always}, values such as "1 day ago" and "in 1 day"
   * will be shown.
   *
   * @param numeric the numeric mode
   * @return this component
   */
  public RelativeTime setNumeric(RelativeTimeNumeric numeric) {
    set(numericProp, numeric);
    return this;
  }

  /**
   * Checks whether the displayed value is kept up to date as time passes.
   *
   * @return {@code true} if syncing is enabled, {@code false} otherwise
   */
  public boolean isSync() {
    return get(syncProp);
  }

  /**
   * Sets whether to keep the displayed value up to date as time passes.
   *
   * @param sync {@code true} to enable syncing
   * @return this component
   */
  public RelativeTime setSync(boolean sync) {
    set(syncProp, sync);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
