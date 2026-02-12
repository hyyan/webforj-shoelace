package com.webforj.shoelace.components.range;

import com.webforj.component.Component;
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
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;

/**
 * Shoelace Range component ({@code <sl-range>}).
 *
 * <p>Ranges allow the user to select a single value within a given range using a slider. They
 * support labels, help text, tooltips, and form validation.</p>
 *
 * @see <a href="https://shoelace.style/components/range">Shoelace Range</a>
 */
@NodeName("sl-range")
public final class Range extends ElementCompositeContainer
    implements HasElementClickListener<Range>, HasClassName<Range>, HasStyle<Range>, HasVisibility<Range> {

  // Slot constants
  private static final String LABEL_SLOT = "label";
  private static final String HELP_TEXT_SLOT = "help-text";
  private static final String PREFIX_SLOT = "prefix";
  private static final String SUFFIX_SLOT = "suffix";

  // Property descriptors
  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Double> minProp =
      PropertyDescriptor.property("min", 0.0);
  private final PropertyDescriptor<Double> maxProp =
      PropertyDescriptor.property("max", 100.0);
  private final PropertyDescriptor<Double> stepProp =
      PropertyDescriptor.property("step", 1.0);
  private final PropertyDescriptor<RangeTooltip> tooltipProp =
      PropertyDescriptor.property("tooltip", RangeTooltip.TOP);
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new Range.
   */
  public Range() {
    super();
  }

  /**
   * Creates a new Range with the given value.
   *
   * @param value the initial value
   */
  public Range(double value) {
    this();
    setValue(value);
  }

  /**
   * Gets the name of the range, submitted as a name/value pair with form data.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the range, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Range setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the range.
   *
   * @return the value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the range, submitted as a name/value pair with form data.
   *
   * @param value the value
   * @return this component
   */
  public Range setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the range's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the range's label. If you need to display HTML, use the {@code label} slot instead.
   *
   * @param label the label
   * @return this component
   */
  public Range setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the range's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the range's help text. If you need to display HTML, use the {@code help-text} slot
   * instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Range setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Returns whether the range is disabled.
   *
   * @return {@code true} if the range is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the range is disabled.
   *
   * @param disabled {@code true} to disable the range
   * @return this component
   */
  public Range setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the minimum acceptable value of the range.
   *
   * @return the minimum value
   */
  public double getMin() {
    return get(minProp);
  }

  /**
   * Sets the minimum acceptable value of the range.
   *
   * @param min the minimum value
   * @return this component
   */
  public Range setMin(double min) {
    set(minProp, min);
    return this;
  }

  /**
   * Gets the maximum acceptable value of the range.
   *
   * @return the maximum value
   */
  public double getMax() {
    return get(maxProp);
  }

  /**
   * Sets the maximum acceptable value of the range.
   *
   * @param max the maximum value
   * @return this component
   */
  public Range setMax(double max) {
    set(maxProp, max);
    return this;
  }

  /**
   * Gets the interval at which the range will increase and decrease.
   *
   * @return the step value
   */
  public double getStep() {
    return get(stepProp);
  }

  /**
   * Sets the interval at which the range will increase and decrease.
   *
   * @param step the step value
   * @return this component
   */
  public Range setStep(double step) {
    set(stepProp, step);
    return this;
  }

  /**
   * Gets the preferred placement of the range's tooltip.
   *
   * @return the tooltip placement
   */
  public RangeTooltip getTooltip() {
    return get(tooltipProp);
  }

  /**
   * Sets the preferred placement of the range's tooltip.
   *
   * @param tooltip the tooltip placement
   * @return this component
   */
  public Range setTooltip(RangeTooltip tooltip) {
    set(tooltipProp, tooltip);
    return this;
  }

  /**
   * Gets the form owner ID.
   *
   * @return the form owner ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form owner ID. By default, form controls are associated with the nearest containing
   * form. This attribute allows you to place the form control outside of a form and associate it
   * with the form that has this ID.
   *
   * @param form the form owner ID
   * @return this component
   */
  public Range setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Returns whether the range is required.
   *
   * @return {@code true} if the range is required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the range is required.
   *
   * @param required {@code true} to require a value
   * @return this component
   */
  public Range setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Adds components to the label slot.
   *
   * @param components the components to add to the label slot
   * @return this component
   */
  public Range addToLabel(Component... components) {
    getElement().add(LABEL_SLOT, components);
    return this;
  }

  /**
   * Adds components to the help-text slot.
   *
   * @param components the components to add to the help-text slot
   * @return this component
   */
  public Range addToHelpText(Component... components) {
    getElement().add(HELP_TEXT_SLOT, components);
    return this;
  }

  /**
   * Adds components to the prefix slot.
   *
   * @param components the components to add to the prefix slot
   * @return this component
   */
  public Range addToPrefix(Component... components) {
    getElement().add(PREFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the suffix slot.
   *
   * @param components the components to add to the suffix slot
   * @return this component
   */
  public Range addToSuffix(Component... components) {
    getElement().add(SUFFIX_SLOT, components);
    return this;
  }

  /**
   * Sets focus on the range.
   */
  public void focus() {
    getElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the range.
   */
  public void blur() {
    getElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Increments the value of the range by the value of the step attribute.
   */
  public void stepUp() {
    getElement().callJsFunctionVoidAsync("stepUp");
  }

  /**
   * Decrements the value of the range by the value of the step attribute.
   */
  public void stepDown() {
    getElement().callJsFunctionVoidAsync("stepDown");
  }

  /**
   * Checks for validity but does not show a validation message. Returns {@code true} when valid
   * and {@code false} when invalid.
   */
  public void checkValidity() {
    getElement().callJsFunctionVoidAsync("checkValidity");
  }

  /**
   * Checks for validity and shows the browser's validation message if the control is invalid.
   */
  public void reportValidity() {
    getElement().callJsFunctionVoidAsync("reportValidity");
  }

  /**
   * Sets a custom validation message. Pass an empty string to restore validity.
   *
   * @param message the validation message
   */
  public void setCustomValidity(String message) {
    getElement().callJsFunctionVoidAsync("setCustomValidity", message);
  }

  /**
   * Sets the size of the thumb.
   *
   * @param value the CSS size value
   * @return this component
   */
  public Range setThumbSize(String value) {
    setStyle("--thumb-size", value);
    return this;
  }

  /**
   * Sets the vertical distance the tooltip is offset from the track.
   *
   * @param value the CSS size value
   * @return this component
   */
  public Range setTooltipOffset(String value) {
    setStyle("--tooltip-offset", value);
    return this;
  }

  /**
   * Sets the color of the portion of the track that represents the current value.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Range setTrackColorActive(String value) {
    setStyle("--track-color-active", value);
    return this;
  }

  /**
   * Sets the color of the portion of the track that represents the remaining value.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Range setTrackColorInactive(String value) {
    setStyle("--track-color-inactive", value);
    return this;
  }

  /**
   * Sets the point of origin of the active track.
   *
   * @param value the CSS value
   * @return this component
   */
  public Range setTrackActiveOffset(String value) {
    setStyle("--track-active-offset", value);
    return this;
  }

  /**
   * Sets the height of the track.
   *
   * @param value the CSS height value
   * @return this component
   */
  public Range setTrackHeight(String value) {
    setStyle("--track-height", value);
    return this;
  }

  /**
   * Adds a listener for the blur event, fired when the control loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Range>> addBlurListener(EventListener<BlurEvent<Range>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Range>> onBlur(EventListener<BlurEvent<Range>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the change event, fired when an alteration to the control's value is
   * committed by the user.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Range>> addChangeListener(
      EventListener<ChangeEvent<Range>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Range>> onChange(EventListener<ChangeEvent<Range>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the control gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Range>> addFocusListener(EventListener<FocusEvent<Range>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Range>> onFocus(EventListener<FocusEvent<Range>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the control receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Range>> addInputListener(EventListener<InputEvent<Range>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Range>> onInput(EventListener<InputEvent<Range>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints aren't satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Range>> addInvalidListener(
      EventListener<InvalidEvent<Range>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Range>> onInvalid(EventListener<InvalidEvent<Range>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
