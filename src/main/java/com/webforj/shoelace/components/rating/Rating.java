package com.webforj.shoelace.components.rating;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.components.rating.event.HoverEvent;

/**
 * Shoelace Rating component ({@code <sl-rating>}).
 *
 * <p>Ratings give users a way to quickly view and provide feedback. They can be configured with
 * different max values, precisions, and states.</p>
 *
 * @see <a href="https://shoelace.style/components/rating">Shoelace Rating</a>
 */
@NodeName("sl-rating")
public final class Rating extends ElementComposite
    implements HasElementClickListener<Rating>, HasClassName<Rating>, HasStyle<Rating>, HasVisibility<Rating> {

  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<Integer> maxProp =
      PropertyDescriptor.property("max", 5);
  private final PropertyDescriptor<Double> precisionProp =
      PropertyDescriptor.property("precision", 1.0);
  private final PropertyDescriptor<Boolean> readonlyProp =
      PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Rating.
   */
  public Rating() {
    super();
  }

  /**
   * Creates a new Rating with the given value.
   *
   * @param value the initial rating value
   */
  public Rating(double value) {
    this();
    setValue(value);
  }

  /**
   * Gets the accessibility label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets a label that describes the rating to assistive devices.
   *
   * @param label the accessibility label
   * @return this component
   */
  public Rating setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the current rating value.
   *
   * @return the rating value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current rating value.
   *
   * @param value the rating value
   * @return this component
   */
  public Rating setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the highest rating to show.
   *
   * @return the maximum rating
   */
  public int getMax() {
    return get(maxProp);
  }

  /**
   * Sets the highest rating to show.
   *
   * @param max the maximum rating
   * @return this component
   */
  public Rating setMax(int max) {
    set(maxProp, max);
    return this;
  }

  /**
   * Gets the precision at which the rating will increase and decrease.
   *
   * @return the precision
   */
  public double getPrecision() {
    return get(precisionProp);
  }

  /**
   * Sets the precision at which the rating will increase and decrease. For example, to allow
   * half-star ratings, set this to {@code 0.5}.
   *
   * @param precision the precision
   * @return this component
   */
  public Rating setPrecision(double precision) {
    set(precisionProp, precision);
    return this;
  }

  /**
   * Returns whether the rating is readonly.
   *
   * @return {@code true} if the rating is readonly
   */
  public boolean isReadonly() {
    return get(readonlyProp);
  }

  /**
   * Sets whether the rating is readonly.
   *
   * @param readonly {@code true} to make the rating readonly
   * @return this component
   */
  public Rating setReadonly(boolean readonly) {
    set(readonlyProp, readonly);
    return this;
  }

  /**
   * Returns whether the rating is disabled.
   *
   * @return {@code true} if the rating is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the rating is disabled.
   *
   * @param disabled {@code true} to disable the rating
   * @return this component
   */
  public Rating setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Sets focus on the rating.
   */
  public void focus() {
    getElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the rating.
   */
  public void blur() {
    getElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Sets the inactive color for symbols.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Rating setSymbolColor(String value) {
    setStyle("--symbol-color", value);
    return this;
  }

  /**
   * Sets the active color for symbols.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Rating setSymbolColorActive(String value) {
    setStyle("--symbol-color-active", value);
    return this;
  }

  /**
   * Sets the size of symbols.
   *
   * @param value the CSS size value
   * @return this component
   */
  public Rating setSymbolSize(String value) {
    setStyle("--symbol-size", value);
    return this;
  }

  /**
   * Sets the spacing to use around symbols.
   *
   * @param value the CSS spacing value
   * @return this component
   */
  public Rating setSymbolSpacing(String value) {
    setStyle("--symbol-spacing", value);
    return this;
  }

  /**
   * Adds a listener for the change event, fired when the rating's value changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Rating>> addChangeListener(
      EventListener<ChangeEvent<Rating>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Rating>> onChange(EventListener<ChangeEvent<Rating>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the hover event, fired when the user hovers over a value.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HoverEvent<Rating>> addHoverListener(
      EventListener<HoverEvent<Rating>> listener) {
    return addEventListener(HoverEvent.class, listener);
  }

  /**
   * Adds a listener for the hover event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HoverEvent<Rating>> onHover(EventListener<HoverEvent<Rating>> listener) {
    return addHoverListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
