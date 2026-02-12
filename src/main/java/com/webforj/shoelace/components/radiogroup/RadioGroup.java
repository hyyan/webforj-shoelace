package com.webforj.shoelace.components.radiogroup;

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
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;

/**
 * Shoelace Radio Group component ({@code <sl-radio-group>}).
 *
 * <p>Radio groups are used to group multiple radios or radio buttons so they function as a single
 * form control. The group ensures that only one radio in the group can be selected at a time.</p>
 *
 * @see <a href="https://shoelace.style/components/radio-group">Shoelace Radio Group</a>
 */
@NodeName("sl-radio-group")
public final class RadioGroup extends ElementCompositeContainer
    implements HasElementClickListener<RadioGroup>, HasClassName<RadioGroup>, HasStyle<RadioGroup>, HasVisibility<RadioGroup> {

  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "option");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new RadioGroup.
   */
  public RadioGroup() {
    super();
  }

  /**
   * Creates a new RadioGroup with the given label.
   *
   * @param label the group's label
   */
  public RadioGroup(String label) {
    this();
    setLabel(label);
  }

  /**
   * Gets the radio group's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the radio group's label. Required for proper accessibility. If you need to display HTML,
   * use the label slot instead.
   *
   * @param label the label
   * @return this component
   */
  public RadioGroup setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the radio group's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the radio group's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public RadioGroup setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Gets the name of the radio group.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the radio group, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public RadioGroup setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the radio group.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the radio group, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public RadioGroup setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the radio group's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the radio group's size. This size will be applied to all child radios and radio buttons.
   *
   * @param size the size
   * @return this component
   */
  public RadioGroup setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets the form ID that this control is associated with.
   *
   * @return the form ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form ID to associate this control with. The form must be in the same document or
   * shadow root for this to work.
   *
   * @param form the form ID
   * @return this component
   */
  public RadioGroup setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Checks whether the radio group is required.
   *
   * @return {@code true} if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether a child radio must be checked before allowing the containing form to submit.
   *
   * @param required {@code true} to require selection
   * @return this component
   */
  public RadioGroup setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Checks for validity but does not show a validation message. Returns {@code true} when valid
   * and {@code false} when invalid.
   */
  public void checkValidity() {
    getElement().callJsFunction("checkValidity");
  }

  /**
   * Checks for validity and shows the browser's validation message if the control is invalid.
   */
  public void reportValidity() {
    getElement().callJsFunction("reportValidity");
  }

  /**
   * Sets a custom validation message. Pass an empty string to restore validity.
   *
   * @param message the custom validation message
   */
  public void setCustomValidity(String message) {
    getElement().callJsFunction("setCustomValidity", message);
  }

  /**
   * Sets focus on the radio group.
   */
  public void focus() {
    getElement().callJsFunction("focus");
  }

  /**
   * Adds a listener for the change event, fired when the radio group's selected value changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<RadioGroup>> addChangeListener(
      EventListener<ChangeEvent<RadioGroup>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<RadioGroup>> onChange(EventListener<ChangeEvent<RadioGroup>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the radio group receives user input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<RadioGroup>> addInputListener(
      EventListener<InputEvent<RadioGroup>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<RadioGroup>> onInput(EventListener<InputEvent<RadioGroup>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<RadioGroup>> addInvalidListener(
      EventListener<InvalidEvent<RadioGroup>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<RadioGroup>> onInvalid(EventListener<InvalidEvent<RadioGroup>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
