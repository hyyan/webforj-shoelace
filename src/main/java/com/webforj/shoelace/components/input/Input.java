package com.webforj.shoelace.components.input;

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
import com.webforj.shoelace.event.ClearEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;

/**
 * Shoelace Input component ({@code <sl-input>}).
 *
 * <p>Inputs collect data from the user. They support a variety of types such as text, number,
 * password, email, and more.</p>
 *
 * @see <a href="https://shoelace.style/components/input">Shoelace Input</a>
 */
@NodeName("sl-input")
public final class Input extends ElementCompositeContainer
    implements HasElementClickListener<Input>, HasClassName<Input>, HasStyle<Input>, HasVisibility<Input> {

  private final PropertyDescriptor<InputType> typeProp =
      PropertyDescriptor.property("type", InputType.TEXT);
  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> filledProp =
      PropertyDescriptor.property("filled", false);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<Boolean> clearableProp =
      PropertyDescriptor.property("clearable", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> placeholderProp =
      PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<Boolean> readonlyProp =
      PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<Boolean> passwordToggleProp =
      PropertyDescriptor.property("passwordToggle", false);
  private final PropertyDescriptor<Boolean> passwordVisibleProp =
      PropertyDescriptor.property("passwordVisible", false);
  private final PropertyDescriptor<Boolean> noSpinButtonsProp =
      PropertyDescriptor.property("noSpinButtons", false);
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<String> patternProp =
      PropertyDescriptor.property("pattern", "");
  private final PropertyDescriptor<Integer> minlengthProp =
      PropertyDescriptor.property("minlength", 0);
  private final PropertyDescriptor<Integer> maxlengthProp =
      PropertyDescriptor.property("maxlength", 0);
  private final PropertyDescriptor<String> minProp =
      PropertyDescriptor.property("min", "");
  private final PropertyDescriptor<String> maxProp =
      PropertyDescriptor.property("max", "");
  private final PropertyDescriptor<String> stepProp =
      PropertyDescriptor.property("step", "");
  private final PropertyDescriptor<String> autocompleteProp =
      PropertyDescriptor.property("autocomplete", "");
  private final PropertyDescriptor<Boolean> autofocusProp =
      PropertyDescriptor.property("autofocus", false);
  private final PropertyDescriptor<Boolean> spellcheckProp =
      PropertyDescriptor.property("spellcheck", false);

  /**
   * Creates a new Input.
   */
  public Input() {
    super();
  }

  /**
   * Gets the input type.
   *
   * @return the input type
   */
  public InputType getType() {
    return get(typeProp);
  }

  /**
   * Sets the type of input. Works the same as a native input element, but only a subset of types
   * are supported.
   *
   * @param type the input type
   * @return this component
   */
  public Input setType(InputType type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Gets the name of the input.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the input, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Input setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the input.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the input, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public Input setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the input's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the input's size.
   *
   * @param size the size
   * @return this component
   */
  public Input setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets whether the input is drawn in a filled style.
   *
   * @return true if the input is filled
   */
  public boolean isFilled() {
    return get(filledProp);
  }

  /**
   * Sets whether to draw a filled input.
   *
   * @param filled true to draw a filled input
   * @return this component
   */
  public Input setFilled(boolean filled) {
    set(filledProp, filled);
    return this;
  }

  /**
   * Gets whether the input is drawn with rounded edges.
   *
   * @return true if the input has a pill style
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether to draw a pill-style input with rounded edges.
   *
   * @param pill true to draw a pill-style input
   * @return this component
   */
  public Input setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Gets the input's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the input's label. If you need to display HTML, use the label slot instead.
   *
   * @param label the label
   * @return this component
   */
  public Input setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the input's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the input's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Input setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Gets whether the input has a clear button.
   *
   * @return true if the input is clearable
   */
  public boolean isClearable() {
    return get(clearableProp);
  }

  /**
   * Sets whether to add a clear button when the input is not empty.
   *
   * @param clearable true to add a clear button
   * @return this component
   */
  public Input setClearable(boolean clearable) {
    set(clearableProp, clearable);
    return this;
  }

  /**
   * Gets whether the input is disabled.
   *
   * @return true if the input is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether to disable the input.
   *
   * @param disabled true to disable the input
   * @return this component
   */
  public Input setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the placeholder text.
   *
   * @return the placeholder text
   */
  public String getPlaceholder() {
    return get(placeholderProp);
  }

  /**
   * Sets placeholder text to show as a hint when the input is empty.
   *
   * @param placeholder the placeholder text
   * @return this component
   */
  public Input setPlaceholder(String placeholder) {
    set(placeholderProp, placeholder);
    return this;
  }

  /**
   * Gets whether the input is readonly.
   *
   * @return true if the input is readonly
   */
  public boolean isReadonly() {
    return get(readonlyProp);
  }

  /**
   * Sets whether to make the input readonly.
   *
   * @param readonly true to make the input readonly
   * @return this component
   */
  public Input setReadonly(boolean readonly) {
    set(readonlyProp, readonly);
    return this;
  }

  /**
   * Gets whether the password toggle button is shown.
   *
   * @return true if the password toggle is shown
   */
  public boolean isPasswordToggle() {
    return get(passwordToggleProp);
  }

  /**
   * Sets whether to add a button to toggle the password's visibility. Only applies to password
   * types.
   *
   * @param passwordToggle true to show the password toggle
   * @return this component
   */
  public Input setPasswordToggle(boolean passwordToggle) {
    set(passwordToggleProp, passwordToggle);
    return this;
  }

  /**
   * Gets whether the password is currently visible.
   *
   * @return true if the password is visible
   */
  public boolean isPasswordVisible() {
    return get(passwordVisibleProp);
  }

  /**
   * Sets whether the password is currently visible. Only applies to password input types.
   *
   * @param passwordVisible true to make the password visible
   * @return this component
   */
  public Input setPasswordVisible(boolean passwordVisible) {
    set(passwordVisibleProp, passwordVisible);
    return this;
  }

  /**
   * Gets whether the spin buttons are hidden for number inputs.
   *
   * @return true if spin buttons are hidden
   */
  public boolean isNoSpinButtons() {
    return get(noSpinButtonsProp);
  }

  /**
   * Sets whether to hide the browser's built-in increment/decrement spin buttons for number
   * inputs.
   *
   * @param noSpinButtons true to hide spin buttons
   * @return this component
   */
  public Input setNoSpinButtons(boolean noSpinButtons) {
    set(noSpinButtonsProp, noSpinButtons);
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
  public Input setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Gets whether the input is required.
   *
   * @return true if the input is required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the input is a required field.
   *
   * @param required true to make the input required
   * @return this component
   */
  public Input setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Gets the validation pattern.
   *
   * @return the pattern
   */
  public String getPattern() {
    return get(patternProp);
  }

  /**
   * Sets a regular expression pattern to validate input against.
   *
   * @param pattern the validation pattern
   * @return this component
   */
  public Input setPattern(String pattern) {
    set(patternProp, pattern);
    return this;
  }

  /**
   * Gets the minimum length of input that will be considered valid.
   *
   * @return the minimum length
   */
  public int getMinlength() {
    return get(minlengthProp);
  }

  /**
   * Sets the minimum length of input that will be considered valid.
   *
   * @param minlength the minimum length
   * @return this component
   */
  public Input setMinlength(int minlength) {
    set(minlengthProp, minlength);
    return this;
  }

  /**
   * Gets the maximum length of input that will be considered valid.
   *
   * @return the maximum length
   */
  public int getMaxlength() {
    return get(maxlengthProp);
  }

  /**
   * Sets the maximum length of input that will be considered valid.
   *
   * @param maxlength the maximum length
   * @return this component
   */
  public Input setMaxlength(int maxlength) {
    set(maxlengthProp, maxlength);
    return this;
  }

  /**
   * Gets the input's minimum value. Only applies to date and number input types.
   *
   * @return the minimum value
   */
  public String getMin() {
    return get(minProp);
  }

  /**
   * Sets the input's minimum value. Only applies to date and number input types.
   *
   * @param min the minimum value
   * @return this component
   */
  public Input setMin(String min) {
    set(minProp, min);
    return this;
  }

  /**
   * Gets the input's maximum value. Only applies to date and number input types.
   *
   * @return the maximum value
   */
  public String getMax() {
    return get(maxProp);
  }

  /**
   * Sets the input's maximum value. Only applies to date and number input types.
   *
   * @param max the maximum value
   * @return this component
   */
  public Input setMax(String max) {
    set(maxProp, max);
    return this;
  }

  /**
   * Gets the step value for numeric and date inputs.
   *
   * @return the step value
   */
  public String getStep() {
    return get(stepProp);
  }

  /**
   * Sets the granularity that the value must adhere to, or the special value {@code any} which
   * means no stepping is implied. Only applies to date and number input types.
   *
   * @param step the step value
   * @return this component
   */
  public Input setStep(String step) {
    set(stepProp, step);
    return this;
  }

  /**
   * Gets the autocomplete hint.
   *
   * @return the autocomplete value
   */
  public String getAutocomplete() {
    return get(autocompleteProp);
  }

  /**
   * Sets what permission the browser has to provide assistance in filling out form field values.
   *
   * @param autocomplete the autocomplete value
   * @return this component
   */
  public Input setAutocomplete(String autocomplete) {
    set(autocompleteProp, autocomplete);
    return this;
  }

  /**
   * Gets whether the input should receive focus on page load.
   *
   * @return true if autofocus is enabled
   */
  public boolean isAutofocus() {
    return get(autofocusProp);
  }

  /**
   * Sets whether the input should receive focus on page load.
   *
   * @param autofocus true to enable autofocus
   * @return this component
   */
  public Input setAutofocus(boolean autofocus) {
    set(autofocusProp, autofocus);
    return this;
  }

  /**
   * Gets whether spell checking is enabled.
   *
   * @return true if spell checking is enabled
   */
  public boolean isSpellcheck() {
    return get(spellcheckProp);
  }

  /**
   * Sets whether to enable spell checking on the input.
   *
   * @param spellcheck true to enable spell checking
   * @return this component
   */
  public Input setSpellcheck(boolean spellcheck) {
    set(spellcheckProp, spellcheck);
    return this;
  }

  /**
   * Sets focus on the input.
   */
  public void focus() {
    getOriginalElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the input.
   */
  public void blur() {
    getOriginalElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Selects all the text in the input.
   */
  public void select() {
    getOriginalElement().callJsFunctionVoidAsync("select");
  }

  /**
   * Increments the value of a numeric input type by the value of the step attribute.
   */
  public void stepUp() {
    getOriginalElement().callJsFunctionVoidAsync("stepUp");
  }

  /**
   * Decrements the value of a numeric input type by the value of the step attribute.
   */
  public void stepDown() {
    getOriginalElement().callJsFunctionVoidAsync("stepDown");
  }

  /**
   * Displays the browser picker for an input element. Only works if the browser supports it for
   * the input type.
   */
  public void showPicker() {
    getOriginalElement().callJsFunctionVoidAsync("showPicker");
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
  public ListenerRegistration<BlurEvent<Input>> addBlurListener(EventListener<BlurEvent<Input>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Input>> onBlur(EventListener<BlurEvent<Input>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when an alteration to the control's value is
   * committed by the user.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Input>> addChangeListener(
      EventListener<ChangeEvent<Input>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Input>> onChange(EventListener<ChangeEvent<Input>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the clear event, fired when the clear button is activated.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ClearEvent<Input>> addClearListener(EventListener<ClearEvent<Input>> listener) {
    return addEventListener(ClearEvent.class, listener);
  }

  /**
   * Adds a listener for the clear event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ClearEvent<Input>> onClear(EventListener<ClearEvent<Input>> listener) {
    return addClearListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the control gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Input>> addFocusListener(
      EventListener<FocusEvent<Input>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Input>> onFocus(EventListener<FocusEvent<Input>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the control receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Input>> addInputListener(
      EventListener<InputEvent<Input>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Input>> onInput(EventListener<InputEvent<Input>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Input>> addInvalidListener(
      EventListener<InvalidEvent<Input>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Input>> onInvalid(EventListener<InvalidEvent<Input>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
