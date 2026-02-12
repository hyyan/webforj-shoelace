package com.webforj.shoelace.components.checkbox;

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
 * Shoelace Checkbox component ({@code <sl-checkbox>}).
 *
 * <p>Checkboxes allow the user to toggle an option on or off.</p>
 *
 * @see <a href="https://shoelace.style/components/checkbox">Shoelace Checkbox</a>
 */
@NodeName("sl-checkbox")
public final class Checkbox extends ElementCompositeContainer
    implements HasElementClickListener<Checkbox>, HasClassName<Checkbox>, HasStyle<Checkbox>, HasVisibility<Checkbox> {

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
  private final PropertyDescriptor<Boolean> indeterminateProp =
      PropertyDescriptor.property("indeterminate", false);
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new Checkbox.
   */
  public Checkbox() {
    super();
  }

  /**
   * Gets the name of the checkbox.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the checkbox, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Checkbox setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the checkbox.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the checkbox, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public Checkbox setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the checkbox's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the checkbox's size.
   *
   * @param size the size
   * @return this component
   */
  public Checkbox setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets whether the checkbox is disabled.
   *
   * @return true if the checkbox is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether to disable the checkbox.
   *
   * @param disabled true to disable the checkbox
   * @return this component
   */
  public Checkbox setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets whether the checkbox is checked.
   *
   * @return true if the checkbox is checked
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Sets whether the checkbox is drawn in a checked state.
   *
   * @param checked true to check the checkbox
   * @return this component
   */
  public Checkbox setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Gets whether the checkbox is in an indeterminate state.
   *
   * @return true if the checkbox is indeterminate
   */
  public boolean isIndeterminate() {
    return get(indeterminateProp);
  }

  /**
   * Sets whether the checkbox is drawn in an indeterminate state. This is usually applied to
   * checkboxes that represent a "select all/none" behavior when associated checkboxes have a mix
   * of checked and unchecked states.
   *
   * @param indeterminate true to set the checkbox as indeterminate
   * @return this component
   */
  public Checkbox setIndeterminate(boolean indeterminate) {
    set(indeterminateProp, indeterminate);
    return this;
  }

  /**
   * Gets the checkbox's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the checkbox's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Checkbox setHelpText(String helpText) {
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
  public Checkbox setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Gets whether the checkbox is required.
   *
   * @return true if the checkbox is required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the checkbox is a required field.
   *
   * @param required true to make the checkbox required
   * @return this component
   */
  public Checkbox setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Sets focus on the checkbox.
   */
  public void focus() {
    getOriginalElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the checkbox.
   */
  public void blur() {
    getOriginalElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Simulates a click on the checkbox.
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
   * Sets a custom validation message. The value provided will be shown to the user when the form
   * is submitted. To clear the custom validation message, call this method with an empty string.
   *
   * @param message the custom validation message
   */
  public void setCustomValidity(String message) {
    getOriginalElement().callJsFunctionVoidAsync("setCustomValidity", message);
  }

  /**
   * Adds a listener for the blur event, fired when the checkbox loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Checkbox>> addBlurListener(EventListener<BlurEvent<Checkbox>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Checkbox>> onBlur(EventListener<BlurEvent<Checkbox>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when the checked state changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Checkbox>> addChangeListener(
      EventListener<ChangeEvent<Checkbox>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Checkbox>> onChange(EventListener<ChangeEvent<Checkbox>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the checkbox gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Checkbox>> addFocusListener(
      EventListener<FocusEvent<Checkbox>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Checkbox>> onFocus(EventListener<FocusEvent<Checkbox>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the checkbox receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Checkbox>> addInputListener(
      EventListener<InputEvent<Checkbox>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Checkbox>> onInput(EventListener<InputEvent<Checkbox>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Checkbox>> addInvalidListener(
      EventListener<InvalidEvent<Checkbox>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Checkbox>> onInvalid(EventListener<InvalidEvent<Checkbox>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
