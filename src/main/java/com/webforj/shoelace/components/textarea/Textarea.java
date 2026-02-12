package com.webforj.shoelace.components.textarea;

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
 * Shoelace Textarea component ({@code <sl-textarea>}).
 *
 * <p>Textareas collect data from the user and allow multiple lines of text.</p>
 *
 * @see <a href="https://shoelace.style/components/textarea">Shoelace Textarea</a>
 */
@NodeName("sl-textarea")
public final class Textarea extends ElementCompositeContainer
    implements HasElementClickListener<Textarea>, HasClassName<Textarea>, HasStyle<Textarea>, HasVisibility<Textarea> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> filledProp =
      PropertyDescriptor.property("filled", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<String> placeholderProp =
      PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<Integer> rowsProp =
      PropertyDescriptor.property("rows", 4);
  private final PropertyDescriptor<Resize> resizeProp =
      PropertyDescriptor.property("resize", Resize.VERTICAL);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> readonlyProp =
      PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<Integer> minlengthProp =
      PropertyDescriptor.property("minlength", 0);
  private final PropertyDescriptor<Integer> maxlengthProp =
      PropertyDescriptor.property("maxlength", 0);
  private final PropertyDescriptor<String> autocompleteProp =
      PropertyDescriptor.property("autocomplete", "");
  private final PropertyDescriptor<Boolean> autofocusProp =
      PropertyDescriptor.property("autofocus", false);
  private final PropertyDescriptor<Boolean> spellcheckProp =
      PropertyDescriptor.property("spellcheck", false);
  private final PropertyDescriptor<String> enterkeyhintProp =
      PropertyDescriptor.property("enterkeyhint", "");
  private final PropertyDescriptor<String> inputmodeProp =
      PropertyDescriptor.property("inputmode", "");

  /**
   * Creates a new Textarea.
   */
  public Textarea() {
    super();
  }

  /**
   * Gets the name of the textarea.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the textarea, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Textarea setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the textarea.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the textarea, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public Textarea setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the textarea's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the textarea's size.
   *
   * @param size the size
   * @return this component
   */
  public Textarea setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets whether the textarea is drawn in a filled style.
   *
   * @return true if the textarea is filled
   */
  public boolean isFilled() {
    return get(filledProp);
  }

  /**
   * Sets whether to draw a filled textarea.
   *
   * @param filled true to draw a filled textarea
   * @return this component
   */
  public Textarea setFilled(boolean filled) {
    set(filledProp, filled);
    return this;
  }

  /**
   * Gets the textarea's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the textarea's label. If you need to display HTML, use the label slot instead.
   *
   * @param label the label
   * @return this component
   */
  public Textarea setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the textarea's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the textarea's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Textarea setHelpText(String helpText) {
    set(helpTextProp, helpText);
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
   * Sets placeholder text to show as a hint when the textarea is empty.
   *
   * @param placeholder the placeholder text
   * @return this component
   */
  public Textarea setPlaceholder(String placeholder) {
    set(placeholderProp, placeholder);
    return this;
  }

  /**
   * Gets the number of rows to display by default.
   *
   * @return the number of rows
   */
  public int getRows() {
    return get(rowsProp);
  }

  /**
   * Sets the number of rows to display by default.
   *
   * @param rows the number of rows
   * @return this component
   */
  public Textarea setRows(int rows) {
    set(rowsProp, rows);
    return this;
  }

  /**
   * Gets how the textarea can be resized.
   *
   * @return the resize mode
   */
  public Resize getResize() {
    return get(resizeProp);
  }

  /**
   * Sets how the textarea can be resized.
   *
   * @param resize the resize mode
   * @return this component
   */
  public Textarea setResize(Resize resize) {
    set(resizeProp, resize);
    return this;
  }

  /**
   * Gets whether the textarea is disabled.
   *
   * @return true if the textarea is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether to disable the textarea.
   *
   * @param disabled true to disable the textarea
   * @return this component
   */
  public Textarea setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets whether the textarea is readonly.
   *
   * @return true if the textarea is readonly
   */
  public boolean isReadonly() {
    return get(readonlyProp);
  }

  /**
   * Sets whether to make the textarea readonly.
   *
   * @param readonly true to make the textarea readonly
   * @return this component
   */
  public Textarea setReadonly(boolean readonly) {
    set(readonlyProp, readonly);
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
  public Textarea setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Gets whether the textarea is required.
   *
   * @return true if the textarea is required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the textarea is a required field.
   *
   * @param required true to make the textarea required
   * @return this component
   */
  public Textarea setRequired(boolean required) {
    set(requiredProp, required);
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
  public Textarea setMinlength(int minlength) {
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
  public Textarea setMaxlength(int maxlength) {
    set(maxlengthProp, maxlength);
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
  public Textarea setAutocomplete(String autocomplete) {
    set(autocompleteProp, autocomplete);
    return this;
  }

  /**
   * Gets whether the textarea should receive focus on page load.
   *
   * @return true if autofocus is enabled
   */
  public boolean isAutofocus() {
    return get(autofocusProp);
  }

  /**
   * Sets whether the textarea should receive focus on page load.
   *
   * @param autofocus true to enable autofocus
   * @return this component
   */
  public Textarea setAutofocus(boolean autofocus) {
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
   * Sets whether to enable spell checking on the textarea.
   *
   * @param spellcheck true to enable spell checking
   * @return this component
   */
  public Textarea setSpellcheck(boolean spellcheck) {
    set(spellcheckProp, spellcheck);
    return this;
  }

  /**
   * Gets the enter key hint used to customize the label or icon of the Enter key on virtual
   * keyboards.
   *
   * @return the enter key hint
   */
  public String getEnterkeyhint() {
    return get(enterkeyhintProp);
  }

  /**
   * Sets the enter key hint used to customize the label or icon of the Enter key on virtual
   * keyboards.
   *
   * @param enterkeyhint the enter key hint
   * @return this component
   */
  public Textarea setEnterkeyhint(String enterkeyhint) {
    set(enterkeyhintProp, enterkeyhint);
    return this;
  }

  /**
   * Gets the input mode that tells the browser what type of data will be entered by the user.
   *
   * @return the input mode
   */
  public String getInputmode() {
    return get(inputmodeProp);
  }

  /**
   * Sets the input mode that tells the browser what type of data will be entered by the user,
   * allowing it to display the appropriate virtual keyboard on supportive devices.
   *
   * @param inputmode the input mode
   * @return this component
   */
  public Textarea setInputmode(String inputmode) {
    set(inputmodeProp, inputmode);
    return this;
  }

  /**
   * Sets focus on the textarea.
   */
  public void focus() {
    getOriginalElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the textarea.
   */
  public void blur() {
    getOriginalElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Selects all the text in the textarea.
   */
  public void select() {
    getOriginalElement().callJsFunctionVoidAsync("select");
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
  public ListenerRegistration<BlurEvent<Textarea>> addBlurListener(EventListener<BlurEvent<Textarea>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Textarea>> onBlur(EventListener<BlurEvent<Textarea>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when an alteration to the control's value is
   * committed by the user.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Textarea>> addChangeListener(
      EventListener<ChangeEvent<Textarea>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Textarea>> onChange(EventListener<ChangeEvent<Textarea>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the control gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Textarea>> addFocusListener(
      EventListener<FocusEvent<Textarea>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Textarea>> onFocus(EventListener<FocusEvent<Textarea>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the control receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Textarea>> addInputListener(
      EventListener<InputEvent<Textarea>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Textarea>> onInput(EventListener<InputEvent<Textarea>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Textarea>> addInvalidListener(
      EventListener<InvalidEvent<Textarea>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Textarea>> onInvalid(EventListener<InvalidEvent<Textarea>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
