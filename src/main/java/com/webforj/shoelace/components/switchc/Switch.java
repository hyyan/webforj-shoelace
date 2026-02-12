package com.webforj.shoelace.components.switchc;

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
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;

/**
 * Shoelace Switch component ({@code <sl-switch>}).
 *
 * <p>Switches allow the user to toggle an option on or off.</p>
 *
 * @see <a href="https://shoelace.style/components/switch">Shoelace Switch</a>
 */
@NodeName("sl-switch")
public final class Switch extends ElementCompositeContainer
    implements HasElementClickListener<Switch>, HasClassName<Switch>, HasStyle<Switch>, HasVisibility<Switch> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> checkedProp =
      PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new Switch.
   */
  public Switch() {
    super();
  }

  /**
   * Gets the name of the switch.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the switch, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Switch setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the switch.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the switch, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public Switch setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the switch's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the switch's size.
   *
   * @param size the size
   * @return this component
   */
  public Switch setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets whether the switch is disabled.
   *
   * @return true if the switch is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether to disable the switch.
   *
   * @param disabled true to disable the switch
   * @return this component
   */
  public Switch setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets whether the switch is checked.
   *
   * @return true if the switch is checked
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Sets whether the switch is drawn in a checked state.
   *
   * @param checked true to check the switch
   * @return this component
   */
  public Switch setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Gets the switch's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the switch's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Switch setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Gets the form ID this control is associated with.
   *
   * @return the form ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form ID to associate this control with. The form must be in the same document or
   * shadow root.
   *
   * @param form the form ID
   * @return this component
   */
  public Switch setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Gets whether the switch is required.
   *
   * @return true if the switch is required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the switch is a required field.
   *
   * @param required true to make the switch required
   * @return this component
   */
  public Switch setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Sets focus on the switch.
   */
  public void focus() {
    getOriginalElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the switch.
   */
  public void blur() {
    getOriginalElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Simulates a click on the switch.
   */
  public void click() {
    getOriginalElement().callJsFunctionVoidAsync("click");
  }

  /**
   * Checks for validity but does not show a validation message. Returns {@code true} when valid
   * and {@code false} when invalid.
   */
  public void checkValidity() {
    getOriginalElement().callJsFunctionVoidAsync("checkValidity");
  }

  /**
   * Checks for validity and shows the browser's validation message if the control is invalid.
   */
  public void reportValidity() {
    getOriginalElement().callJsFunctionVoidAsync("reportValidity");
  }

  /**
   * Sets a custom validation message. Pass an empty string to restore validity.
   *
   * @param message the custom validation message
   */
  public void setCustomValidity(String message) {
    getOriginalElement().callJsFunctionVoidAsync("setCustomValidity", message);
  }

  /**
   * Adds a listener for the blur event, fired when the control loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Switch>> addBlurListener(EventListener<BlurEvent<Switch>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Switch>> onBlur(EventListener<BlurEvent<Switch>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when the control's checked state changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Switch>> addChangeListener(
      EventListener<ChangeEvent<Switch>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Switch>> onChange(EventListener<ChangeEvent<Switch>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the control gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Switch>> addFocusListener(
      EventListener<FocusEvent<Switch>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Switch>> onFocus(EventListener<FocusEvent<Switch>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the control receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Switch>> addInputListener(
      EventListener<InputEvent<Switch>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Switch>> onInput(EventListener<InputEvent<Switch>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Switch>> addInvalidListener(
      EventListener<InvalidEvent<Switch>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Switch>> onInvalid(EventListener<InvalidEvent<Switch>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
