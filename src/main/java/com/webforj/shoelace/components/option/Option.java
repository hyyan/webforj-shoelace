package com.webforj.shoelace.components.option;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.html.elements.Span;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Option component ({@code <sl-option>}).
 *
 * <p>Options define the selectable items within an {@code <sl-select>} element. Options can
 * optionally include prefix and suffix content such as icons.</p>
 *
 * @see <a href="https://shoelace.style/components/option">Shoelace Option</a>
 */
@NodeName("sl-option")
public final class Option extends ElementCompositeContainer
    implements HasElementClickListener<Option>, HasClassName<Option>, HasStyle<Option>, HasVisibility<Option> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Option.
   */
  public Option() {
    super();
  }

  /**
   * Creates a new Option with the given value.
   *
   * @param value the option's value
   */
  public Option(String value) {
    this();
    setValue(value);
  }

  /**
   * Creates a new Option with the given value and label text.
   *
   * @param value the option's value
   * @param label the text label to display
   */
  public Option(String value, String label) {
    this();
    setValue(value);
    add(new Span(label));
  }

  /**
   * Gets the option's value.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the option's value. When selected, the containing form control will receive this value.
   * Values must not contain spaces, as spaces are used as delimiters when listing multiple values.
   *
   * @param value the value
   * @return this component
   */
  public Option setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Checks whether the option is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the option is disabled, preventing selection.
   *
   * @param disabled {@code true} to disable
   * @return this component
   */
  public Option setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the text label based on the option's content.
   *
   * @return the text label
   */
  public String getTextLabel() {
    return getElement().getAttribute("text-label");
  }

  /**
   * Sets a text label for this option. This is typically set automatically based on the option's
   * slotted content but can be set manually if needed.
   *
   * @param label the text label
   * @return this component
   */
  public Option setLabel(String label) {
    getElement().setAttribute("text-label", label);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
