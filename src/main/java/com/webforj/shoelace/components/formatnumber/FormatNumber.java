package com.webforj.shoelace.components.formatnumber;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.annotation.PropertyExclude;

/**
 * Shoelace FormatNumber component ({@code <sl-format-number>}).
 *
 * <p>Formats a number using the specified locale and options. Formatting is handled by the
 * {@code Intl.NumberFormat} API.</p>
 *
 * @see <a href="https://shoelace.style/components/format-number">Shoelace FormatNumber</a>
 */
@NodeName("sl-format-number")
public final class FormatNumber extends ElementComposite {

  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<NumberType> typeProp =
      PropertyDescriptor.property("type", NumberType.DECIMAL);
  private final PropertyDescriptor<Boolean> noGroupingProp =
      PropertyDescriptor.property("noGrouping", false);
  private final PropertyDescriptor<String> currencyProp =
      PropertyDescriptor.property("currency", "USD");
  private final PropertyDescriptor<CurrencyDisplay> currencyDisplayProp =
      PropertyDescriptor.property("currencyDisplay", CurrencyDisplay.SYMBOL);

  @PropertyExclude
  private final PropertyDescriptor<Integer> minimumIntegerDigitsProp =
      PropertyDescriptor.property("minimumIntegerDigits", null);
  @PropertyExclude
  private final PropertyDescriptor<Integer> minimumFractionDigitsProp =
      PropertyDescriptor.property("minimumFractionDigits", null);
  @PropertyExclude
  private final PropertyDescriptor<Integer> maximumFractionDigitsProp =
      PropertyDescriptor.property("maximumFractionDigits", null);
  @PropertyExclude
  private final PropertyDescriptor<Integer> minimumSignificantDigitsProp =
      PropertyDescriptor.property("minimumSignificantDigits", null);
  @PropertyExclude
  private final PropertyDescriptor<Integer> maximumSignificantDigitsProp =
      PropertyDescriptor.property("maximumSignificantDigits", null);

  private final PropertyDescriptor<String> langProp =
      PropertyDescriptor.property("lang", "");

  /**
   * Creates a new FormatNumber.
   */
  public FormatNumber() {
    super();
  }

  /**
   * Creates a new FormatNumber with the given value.
   *
   * @param value the number to format
   */
  public FormatNumber(double value) {
    this();
    setValue(value);
  }

  /**
   * Gets the number to format.
   *
   * @return the value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Sets the number to format.
   *
   * @param value the number to format
   * @return this component
   */
  public FormatNumber setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the formatting style to use.
   *
   * @return the number type
   */
  public NumberType getType() {
    return get(typeProp);
  }

  /**
   * Sets the formatting style to use.
   *
   * @param type the number type
   * @return this component
   */
  public FormatNumber setType(NumberType type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Checks whether grouping separators are turned off.
   *
   * @return {@code true} if grouping is disabled, {@code false} otherwise
   */
  public boolean isNoGrouping() {
    return get(noGroupingProp);
  }

  /**
   * Sets whether to turn off grouping separators.
   *
   * @param noGrouping {@code true} to disable grouping
   * @return this component
   */
  public FormatNumber setNoGrouping(boolean noGrouping) {
    set(noGroupingProp, noGrouping);
    return this;
  }

  /**
   * Gets the ISO 4217 currency code.
   *
   * @return the currency code
   */
  public String getCurrency() {
    return get(currencyProp);
  }

  /**
   * Sets the ISO 4217 currency code to use when formatting.
   *
   * @param currency the currency code
   * @return this component
   */
  public FormatNumber setCurrency(String currency) {
    set(currencyProp, currency);
    return this;
  }

  /**
   * Gets the currency display format.
   *
   * @return the currency display format
   */
  public CurrencyDisplay getCurrencyDisplay() {
    return get(currencyDisplayProp);
  }

  /**
   * Sets how to display the currency.
   *
   * @param currencyDisplay the currency display format
   * @return this component
   */
  public FormatNumber setCurrencyDisplay(CurrencyDisplay currencyDisplay) {
    set(currencyDisplayProp, currencyDisplay);
    return this;
  }

  /**
   * Gets the minimum number of integer digits.
   *
   * @return the minimum integer digits
   */
  public Integer getMinimumIntegerDigits() {
    return get(minimumIntegerDigitsProp);
  }

  /**
   * Sets the minimum number of integer digits to use. Possible values are 1-21.
   *
   * @param minimumIntegerDigits the minimum integer digits
   * @return this component
   */
  public FormatNumber setMinimumIntegerDigits(Integer minimumIntegerDigits) {
    set(minimumIntegerDigitsProp, minimumIntegerDigits);
    return this;
  }

  /**
   * Gets the minimum number of fraction digits.
   *
   * @return the minimum fraction digits
   */
  public Integer getMinimumFractionDigits() {
    return get(minimumFractionDigitsProp);
  }

  /**
   * Sets the minimum number of fraction digits to use. Possible values are 0-20.
   *
   * @param minimumFractionDigits the minimum fraction digits
   * @return this component
   */
  public FormatNumber setMinimumFractionDigits(Integer minimumFractionDigits) {
    set(minimumFractionDigitsProp, minimumFractionDigits);
    return this;
  }

  /**
   * Gets the maximum number of fraction digits.
   *
   * @return the maximum fraction digits
   */
  public Integer getMaximumFractionDigits() {
    return get(maximumFractionDigitsProp);
  }

  /**
   * Sets the maximum number of fraction digits to use. Possible values are 0-20.
   *
   * @param maximumFractionDigits the maximum fraction digits
   * @return this component
   */
  public FormatNumber setMaximumFractionDigits(Integer maximumFractionDigits) {
    set(maximumFractionDigitsProp, maximumFractionDigits);
    return this;
  }

  /**
   * Gets the minimum number of significant digits.
   *
   * @return the minimum significant digits
   */
  public Integer getMinimumSignificantDigits() {
    return get(minimumSignificantDigitsProp);
  }

  /**
   * Sets the minimum number of significant digits to use. Possible values are 1-21.
   *
   * @param minimumSignificantDigits the minimum significant digits
   * @return this component
   */
  public FormatNumber setMinimumSignificantDigits(Integer minimumSignificantDigits) {
    set(minimumSignificantDigitsProp, minimumSignificantDigits);
    return this;
  }

  /**
   * Gets the maximum number of significant digits.
   *
   * @return the maximum significant digits
   */
  public Integer getMaximumSignificantDigits() {
    return get(maximumSignificantDigitsProp);
  }

  /**
   * Sets the maximum number of significant digits to use. Possible values are 1-21.
   *
   * @param maximumSignificantDigits the maximum significant digits
   * @return this component
   */
  public FormatNumber setMaximumSignificantDigits(Integer maximumSignificantDigits) {
    set(maximumSignificantDigitsProp, maximumSignificantDigits);
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
  public FormatNumber setLang(String lang) {
    set(langProp, lang);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
