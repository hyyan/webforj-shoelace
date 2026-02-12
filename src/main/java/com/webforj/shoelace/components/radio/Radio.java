package com.webforj.shoelace.components.radio;

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
 * Shoelace Radio component ({@code <sl-radio>}).
 *
 * <p>Radios allow the user to select a single option from a group. Radios should be used inside
 * an {@code <sl-radio-group>} element.</p>
 *
 * @see <a href="https://shoelace.style/components/radio">Shoelace Radio</a>
 */
@NodeName("sl-radio")
public final class Radio extends ElementCompositeContainer
    implements HasElementClickListener<Radio>, HasClassName<Radio>, HasStyle<Radio>, HasVisibility<Radio> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Radio.
   */
  public Radio() {
    super();
  }

  /**
   * Creates a new Radio with the given value.
   *
   * @param value the radio's value
   */
  public Radio(String value) {
    this();
    setValue(value);
  }

  /**
   * Gets the radio's value.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the radio's value. When selected, the radio group will receive this value.
   *
   * @param value the value
   * @return this component
   */
  public Radio setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the radio's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the radio's size. When used inside a radio group, the size will be determined by the
   * radio group's size so this attribute can typically be omitted.
   *
   * @param size the size
   * @return this component
   */
  public Radio setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Checks whether the radio is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the radio is disabled.
   *
   * @param disabled {@code true} to disable
   * @return this component
   */
  public Radio setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Adds a listener for the blur event, fired when the radio loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Radio>> addBlurListener(EventListener<BlurEvent<Radio>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Radio>> onBlur(EventListener<BlurEvent<Radio>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the radio gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Radio>> addFocusListener(EventListener<FocusEvent<Radio>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Radio>> onFocus(EventListener<FocusEvent<Radio>> listener) {
    return addFocusListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
