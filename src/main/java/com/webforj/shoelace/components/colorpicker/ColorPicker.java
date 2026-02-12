package com.webforj.shoelace.components.colorpicker;

import com.webforj.PendingResult;
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
 * Shoelace Color Picker component ({@code <sl-color-picker>}).
 *
 * <p>Color pickers allow the user to select a color. The component provides a color grid, hue and
 * opacity sliders, an input field for manual entry, and optional swatches for preset colors. The
 * value's format will vary based on the {@code format} attribute.</p>
 *
 * @see <a href="https://shoelace.style/components/color-picker">Shoelace Color Picker</a>
 */
@NodeName("sl-color-picker")
public final class ColorPicker extends ElementCompositeContainer
    implements HasElementClickListener<ColorPicker>, HasClassName<ColorPicker>, HasStyle<ColorPicker>, HasVisibility<ColorPicker> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<ColorPickerFormat> formatProp =
      PropertyDescriptor.property("format", ColorPickerFormat.HEX);
  private final PropertyDescriptor<Boolean> inlineProp =
      PropertyDescriptor.property("inline", false);
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> noFormatToggleProp =
      PropertyDescriptor.property("noFormatToggle", false);
  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> hoistProp =
      PropertyDescriptor.property("hoist", false);
  private final PropertyDescriptor<Boolean> opacityProp =
      PropertyDescriptor.property("opacity", false);
  private final PropertyDescriptor<Boolean> uppercaseProp =
      PropertyDescriptor.property("uppercase", false);
  private final PropertyDescriptor<String> swatchesProp =
      PropertyDescriptor.property("swatches", "");
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new ColorPicker.
   */
  public ColorPicker() {
    super();
  }

  /**
   * Creates a new ColorPicker with the given initial value.
   *
   * @param value the initial color value
   */
  public ColorPicker(String value) {
    this();
    setValue(value);
  }

  /**
   * Gets the current color value.
   *
   * @return the color value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the color picker. The value's format will vary based on the
   * {@code format} attribute. To get the value in a specific format, use the
   * {@link #getFormattedValue(String)} method. The value is submitted as a name/value pair with
   * form data.
   *
   * @param value the color value
   * @return this component
   */
  public ColorPicker setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the color picker's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the color picker's label. This will not be displayed, but it will be announced by
   * assistive devices. If you need to display HTML, you can use the {@code label} slot instead.
   *
   * @param label the accessibility label
   * @return this component
   */
  public ColorPicker setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the color format.
   *
   * @return the color format
   */
  public ColorPickerFormat getFormat() {
    return get(formatProp);
  }

  /**
   * Sets the format to use. If opacity is enabled, these will translate to HEXA, RGBA, HSLA, and
   * HSVA respectively. The color picker will accept user input in any format (including CSS color
   * names) and convert it to the desired format.
   *
   * @param format the color format
   * @return this component
   */
  public ColorPicker setFormat(ColorPickerFormat format) {
    set(formatProp, format);
    return this;
  }

  /**
   * Returns whether the color picker is rendered inline.
   *
   * @return {@code true} if inline
   */
  public boolean isInline() {
    return get(inlineProp);
  }

  /**
   * Sets whether to render the color picker inline rather than in a dropdown.
   *
   * @param inline {@code true} to render inline
   * @return this component
   */
  public ColorPicker setInline(boolean inline) {
    set(inlineProp, inline);
    return this;
  }

  /**
   * Gets the size of the color picker's trigger.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the size of the color picker's trigger. This has no effect on inline color pickers.
   *
   * @param size the size
   * @return this component
   */
  public ColorPicker setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Returns whether the format toggle button is hidden.
   *
   * @return {@code true} if the format toggle is hidden
   */
  public boolean isNoFormatToggle() {
    return get(noFormatToggleProp);
  }

  /**
   * Sets whether to remove the button that lets users toggle between format.
   *
   * @param noFormatToggle {@code true} to hide the format toggle button
   * @return this component
   */
  public ColorPicker setNoFormatToggle(boolean noFormatToggle) {
    set(noFormatToggleProp, noFormatToggle);
    return this;
  }

  /**
   * Gets the name of the form control.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the form control, submitted as a name/value pair with form data.
   *
   * @param name the form control name
   * @return this component
   */
  public ColorPicker setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Returns whether the color picker is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the color picker is disabled.
   *
   * @param disabled {@code true} to disable
   * @return this component
   */
  public ColorPicker setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Returns whether the panel is hoisted.
   *
   * @return {@code true} if hoisted
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether to prevent the panel from being clipped when the component is placed inside a
   * container with {@code overflow: auto|scroll}. Hoisting uses a fixed positioning strategy that
   * works in many, but not all, scenarios.
   *
   * @param hoist {@code true} to enable hoisting
   * @return this component
   */
  public ColorPicker setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Returns whether the opacity slider is visible.
   *
   * @return {@code true} if opacity is enabled
   */
  public boolean isOpacity() {
    return get(opacityProp);
  }

  /**
   * Sets whether to show the opacity slider. Enabling this will cause the formatted value to be
   * HEXA, RGBA, or HSLA.
   *
   * @param opacity {@code true} to show the opacity slider
   * @return this component
   */
  public ColorPicker setOpacity(boolean opacity) {
    set(opacityProp, opacity);
    return this;
  }

  /**
   * Returns whether values are displayed in uppercase.
   *
   * @return {@code true} if uppercase
   */
  public boolean isUppercase() {
    return get(uppercaseProp);
  }

  /**
   * Sets whether values will be uppercase instead of lowercase.
   *
   * @param uppercase {@code true} to display values in uppercase
   * @return this component
   */
  public ColorPicker setUppercase(boolean uppercase) {
    set(uppercaseProp, uppercase);
    return this;
  }

  /**
   * Gets the predefined color swatches.
   *
   * @return the swatches string
   */
  public String getSwatches() {
    return get(swatchesProp);
  }

  /**
   * Sets one or more predefined color swatches to display as presets in the color picker. Can
   * include any format the color picker can parse, including HEX(A), RGB(A), HSL(A), HSV(A), and
   * CSS color names. Each color must be separated by a semicolon ({@code ;}).
   *
   * @param swatches the predefined colors separated by semicolons
   * @return this component
   */
  public ColorPicker setSwatches(String swatches) {
    set(swatchesProp, swatches);
    return this;
  }

  /**
   * Gets the associated form id.
   *
   * @return the form id
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form id to associate with. By default, form controls are associated with the nearest
   * containing {@code <form>} element. This attribute allows you to place the form control outside
   * of a form and associate it with the form that has this id.
   *
   * @param form the form id
   * @return this component
   */
  public ColorPicker setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Returns whether the color picker is a required field.
   *
   * @return {@code true} if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the color picker is a required field.
   *
   * @param required {@code true} to make it required
   * @return this component
   */
  public ColorPicker setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Sets focus on the color picker.
   */
  public void focus() {
    getOriginalElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the color picker.
   */
  public void blur() {
    getOriginalElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Returns the current value as a string in the specified format.
   *
   * @param format the format string (e.g. "hex", "hexa", "rgb", "rgba", "hsl", "hsla", "hsv",
   *               "hsva")
   * @return a PendingResult containing the formatted value
   */
  public PendingResult<Object> getFormattedValue(String format) {
    return getOriginalElement().callJsFunctionAsync("getFormattedValue", format);
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
   * Sets the width of the color grid.
   *
   * @param value the CSS width value
   * @return this component
   */
  public ColorPicker setGridWidth(String value) {
    setStyle("--grid-width", value);
    return this;
  }

  /**
   * Sets the height of the color grid.
   *
   * @param value the CSS height value
   * @return this component
   */
  public ColorPicker setGridHeight(String value) {
    setStyle("--grid-height", value);
    return this;
  }

  /**
   * Sets the size of the color grid's handle.
   *
   * @param value the CSS size value
   * @return this component
   */
  public ColorPicker setGridHandleSize(String value) {
    setStyle("--grid-handle-size", value);
    return this;
  }

  /**
   * Sets the height of the hue and alpha sliders.
   *
   * @param value the CSS height value
   * @return this component
   */
  public ColorPicker setSliderHeight(String value) {
    setStyle("--slider-height", value);
    return this;
  }

  /**
   * Sets the diameter of the slider's handle.
   *
   * @param value the CSS size value
   * @return this component
   */
  public ColorPicker setSliderHandleSize(String value) {
    setStyle("--slider-handle-size", value);
    return this;
  }

  /**
   * Sets the size of each predefined color swatch.
   *
   * @param value the CSS size value
   * @return this component
   */
  public ColorPicker setSwatchSize(String value) {
    setStyle("--swatch-size", value);
    return this;
  }

  /**
   * Adds a listener for the blur event, fired when the color picker loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<ColorPicker>> addBlurListener(EventListener<BlurEvent<ColorPicker>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<ColorPicker>> onBlur(EventListener<BlurEvent<ColorPicker>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when the color picker's value changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<ColorPicker>> addChangeListener(
      EventListener<ChangeEvent<ColorPicker>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<ColorPicker>> onChange(EventListener<ChangeEvent<ColorPicker>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the color picker receives focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<ColorPicker>> addFocusListener(EventListener<FocusEvent<ColorPicker>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<ColorPicker>> onFocus(EventListener<FocusEvent<ColorPicker>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the color picker receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<ColorPicker>> addInputListener(EventListener<InputEvent<ColorPicker>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<ColorPicker>> onInput(EventListener<InputEvent<ColorPicker>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<ColorPicker>> addInvalidListener(
      EventListener<InvalidEvent<ColorPicker>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<ColorPicker>> onInvalid(EventListener<InvalidEvent<ColorPicker>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
