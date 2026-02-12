package com.webforj.shoelace.components.copybutton;

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
import com.webforj.shoelace.components.copybutton.event.CopyErrorEvent;
import com.webforj.shoelace.components.copybutton.event.CopySuccessEvent;

/**
 * Shoelace Copy Button component ({@code <sl-copy-button>}).
 *
 * <p>Copies text data to the clipboard when the user clicks the trigger. The copy button supports
 * custom icons for copy, success, and error states, as well as configurable tooltip placement and
 * feedback duration.</p>
 *
 * @see <a href="https://shoelace.style/components/copy-button">Shoelace Copy Button</a>
 */
@NodeName("sl-copy-button")
public final class CopyButton extends ElementCompositeContainer
    implements HasElementClickListener<CopyButton>, HasClassName<CopyButton>, HasStyle<CopyButton>, HasVisibility<CopyButton> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> fromProp =
      PropertyDescriptor.property("from", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> copyLabelProp =
      PropertyDescriptor.property("copyLabel", "");
  private final PropertyDescriptor<String> successLabelProp =
      PropertyDescriptor.property("successLabel", "");
  private final PropertyDescriptor<String> errorLabelProp =
      PropertyDescriptor.property("errorLabel", "");
  private final PropertyDescriptor<Integer> feedbackDurationProp =
      PropertyDescriptor.property("feedbackDuration", 1000);
  private final PropertyDescriptor<TooltipPlacement> tooltipPlacementProp =
      PropertyDescriptor.property("tooltipPlacement", TooltipPlacement.TOP);
  private final PropertyDescriptor<Boolean> hoistProp =
      PropertyDescriptor.property("hoist", false);

  /**
   * Creates a new CopyButton.
   */
  public CopyButton() {
    super();
  }

  /**
   * Creates a new CopyButton with the given value to copy.
   *
   * @param value the text value to copy
   */
  public CopyButton(String value) {
    this();
    setValue(value);
  }

  /**
   * Gets the text value to copy.
   *
   * @return the text value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the text value to copy.
   *
   * @param value the text value to copy
   * @return this component
   */
  public CopyButton setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the id of the element to copy data from.
   *
   * @return the element id reference
   */
  public String getFrom() {
    return get(fromProp);
  }

  /**
   * Sets an id that references an element in the same document from which data will be copied. If
   * both this and {@code value} are present, this value will take precedence. By default, the
   * target element's {@code textContent} will be copied. To copy an attribute, append the
   * attribute name wrapped in square brackets, e.g. {@code "el[value]"}. To copy a property,
   * append a dot and the property name, e.g. {@code "el.value"}.
   *
   * @param from the element id reference
   * @return this component
   */
  public CopyButton setFrom(String from) {
    set(fromProp, from);
    return this;
  }

  /**
   * Returns whether the copy button is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the copy button is disabled.
   *
   * @param disabled {@code true} to disable the button
   * @return this component
   */
  public CopyButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the custom label shown in the tooltip.
   *
   * @return the copy label
   */
  public String getCopyLabel() {
    return get(copyLabelProp);
  }

  /**
   * Sets a custom label to show in the tooltip.
   *
   * @param copyLabel the tooltip label
   * @return this component
   */
  public CopyButton setCopyLabel(String copyLabel) {
    set(copyLabelProp, copyLabel);
    return this;
  }

  /**
   * Gets the custom label shown in the tooltip after copying.
   *
   * @return the success label
   */
  public String getSuccessLabel() {
    return get(successLabelProp);
  }

  /**
   * Sets a custom label to show in the tooltip after copying.
   *
   * @param successLabel the success tooltip label
   * @return this component
   */
  public CopyButton setSuccessLabel(String successLabel) {
    set(successLabelProp, successLabel);
    return this;
  }

  /**
   * Gets the custom label shown in the tooltip when a copy error occurs.
   *
   * @return the error label
   */
  public String getErrorLabel() {
    return get(errorLabelProp);
  }

  /**
   * Sets a custom label to show in the tooltip when a copy error occurs.
   *
   * @param errorLabel the error tooltip label
   * @return this component
   */
  public CopyButton setErrorLabel(String errorLabel) {
    set(errorLabelProp, errorLabel);
    return this;
  }

  /**
   * Gets the feedback duration in milliseconds.
   *
   * @return the feedback duration
   */
  public Integer getFeedbackDuration() {
    return get(feedbackDurationProp);
  }

  /**
   * Sets the length of time to show feedback before restoring the default trigger.
   *
   * @param feedbackDuration the duration in milliseconds
   * @return this component
   */
  public CopyButton setFeedbackDuration(Integer feedbackDuration) {
    set(feedbackDurationProp, feedbackDuration);
    return this;
  }

  /**
   * Gets the preferred placement of the tooltip.
   *
   * @return the tooltip placement
   */
  public TooltipPlacement getTooltipPlacement() {
    return get(tooltipPlacementProp);
  }

  /**
   * Sets the preferred placement of the tooltip.
   *
   * @param tooltipPlacement the tooltip placement
   * @return this component
   */
  public CopyButton setTooltipPlacement(TooltipPlacement tooltipPlacement) {
    set(tooltipPlacementProp, tooltipPlacement);
    return this;
  }

  /**
   * Returns whether the tooltip is hoisted.
   *
   * @return {@code true} if hoisted
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether to prevent the tooltip from being clipped when the component is placed inside a
   * container with {@code overflow: auto|hidden|scroll}. Hoisting uses a fixed positioning
   * strategy that works in many, but not all, scenarios.
   *
   * @param hoist {@code true} to enable hoisting
   * @return this component
   */
  public CopyButton setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Sets the color to use for success feedback.
   *
   * @param value the CSS color value
   * @return this component
   */
  public CopyButton setSuccessColor(String value) {
    setStyle("--success-color", value);
    return this;
  }

  /**
   * Sets the color to use for error feedback.
   *
   * @param value the CSS color value
   * @return this component
   */
  public CopyButton setErrorColor(String value) {
    setStyle("--error-color", value);
    return this;
  }

  /**
   * Adds a listener for the copy event, fired when data has been copied successfully.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CopySuccessEvent<CopyButton>> addCopySuccessListener(
      EventListener<CopySuccessEvent<CopyButton>> listener) {
    return addEventListener(CopySuccessEvent.class, listener);
  }

  /**
   * Adds a listener for the copy event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CopySuccessEvent<CopyButton>> onCopySuccess(
      EventListener<CopySuccessEvent<CopyButton>> listener) {
    return addCopySuccessListener(listener);
  }

  /**
   * Adds a listener for the error event, fired when data could not be copied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CopyErrorEvent<CopyButton>> addCopyErrorListener(
      EventListener<CopyErrorEvent<CopyButton>> listener) {
    return addEventListener(CopyErrorEvent.class, listener);
  }

  /**
   * Adds a listener for the error event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CopyErrorEvent<CopyButton>> onCopyError(
      EventListener<CopyErrorEvent<CopyButton>> listener) {
    return addCopyErrorListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
