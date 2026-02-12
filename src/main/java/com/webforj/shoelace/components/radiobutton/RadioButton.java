package com.webforj.shoelace.components.radiobutton;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;

/**
 * Shoelace Radio Button component ({@code <sl-radio-button>}).
 *
 * <p>Radio buttons are designed to be used with radio groups. When a radio button has focus,
 * the arrow keys can be used to change the selected option, and the button style provides a more
 * prominent visual appearance than standard radios.</p>
 *
 * @see <a href="https://shoelace.style/components/radio-button">Shoelace Radio Button</a>
 */
@NodeName("sl-radio-button")
public final class RadioButton extends ElementCompositeContainer
    implements HasElementClickListener<RadioButton>, HasClassName<RadioButton>, HasStyle<RadioButton>, HasVisibility<RadioButton> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);

  /**
   * Creates a new RadioButton.
   */
  public RadioButton() {
    super();
  }

  /**
   * Creates a new RadioButton with the given value.
   *
   * @param value the radio button's value
   */
  public RadioButton(String value) {
    this();
    setValue(value);
  }

  /**
   * Gets the radio button's value.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the radio button's value. When selected, the radio group will receive this value.
   *
   * @param value the value
   * @return this component
   */
  public RadioButton setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Checks whether the radio button is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the radio button is disabled.
   *
   * @param disabled {@code true} to disable
   * @return this component
   */
  public RadioButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the radio button's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the radio button's size. When used inside a radio group, the size will be determined by
   * the radio group's size so this attribute can typically be omitted.
   *
   * @param size the size
   * @return this component
   */
  public RadioButton setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Checks whether the radio button has pill style.
   *
   * @return {@code true} if pill style is applied
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether the radio button uses a pill style with rounded edges.
   *
   * @param pill {@code true} to apply pill style
   * @return this component
   */
  public RadioButton setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Sets focus on the radio button.
   */
  public void focus() {
    getElement().callJsFunction("focus");
  }

  /**
   * Removes focus from the radio button.
   */
  public void blur() {
    getElement().callJsFunction("blur");
  }

  /**
   * Adds a listener for the blur event, fired when the radio button loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<RadioButton>> addBlurListener(EventListener<BlurEvent<RadioButton>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<RadioButton>> onBlur(EventListener<BlurEvent<RadioButton>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the radio button gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<RadioButton>> addFocusListener(EventListener<FocusEvent<RadioButton>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<RadioButton>> onFocus(EventListener<FocusEvent<RadioButton>> listener) {
    return addFocusListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
