package com.webforj.shoelace.components.formatbytes;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;

/**
 * Shoelace FormatBytes component ({@code <sl-format-bytes>}).
 *
 * <p>Formats a number as a human-readable byte value. The output is localized and can display the
 * result in bytes or bits using long, short, or narrow display formats.</p>
 *
 * @see <a href="https://shoelace.style/components/format-bytes">Shoelace FormatBytes</a>
 */
@NodeName("sl-format-bytes")
public final class FormatBytes extends ElementComposite {

  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<ByteUnit> unitProp =
      PropertyDescriptor.property("unit", ByteUnit.BYTE);
  private final PropertyDescriptor<ByteDisplay> displayProp =
      PropertyDescriptor.property("display", ByteDisplay.SHORT);
  private final PropertyDescriptor<String> langProp =
      PropertyDescriptor.property("lang", "");

  /**
   * Creates a new FormatBytes.
   */
  public FormatBytes() {
    super();
  }

  /**
   * Creates a new FormatBytes with the given value.
   *
   * @param value the number to format in bytes
   */
  public FormatBytes(double value) {
    this();
    setValue(value);
  }

  /**
   * Gets the number to format in bytes.
   *
   * @return the value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Sets the number to format in bytes.
   *
   * @param value the number to format
   * @return this component
   */
  public FormatBytes setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the type of unit to display.
   *
   * @return the unit
   */
  public ByteUnit getUnit() {
    return get(unitProp);
  }

  /**
   * Sets the type of unit to display.
   *
   * @param unit the unit to display
   * @return this component
   */
  public FormatBytes setUnit(ByteUnit unit) {
    set(unitProp, unit);
    return this;
  }

  /**
   * Gets the display format for the result.
   *
   * @return the display format
   */
  public ByteDisplay getDisplay() {
    return get(displayProp);
  }

  /**
   * Sets the display format for the result, e.g. "100 bytes", "100 b", or "100b".
   *
   * @param display the display format
   * @return this component
   */
  public FormatBytes setDisplay(ByteDisplay display) {
    set(displayProp, display);
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
  public FormatBytes setLang(String lang) {
    set(langProp, lang);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
