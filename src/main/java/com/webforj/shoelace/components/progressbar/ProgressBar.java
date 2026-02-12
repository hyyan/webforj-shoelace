package com.webforj.shoelace.components.progressbar;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Progress Bar component ({@code <sl-progress-bar>}).
 *
 * <p>Progress bars are used to show the status of an ongoing operation. They display a visual
 * indicator of progress as a percentage from 0 to 100.</p>
 *
 * @see <a href="https://shoelace.style/components/progress-bar">Shoelace Progress Bar</a>
 */
@NodeName("sl-progress-bar")
public final class ProgressBar extends ElementCompositeContainer
    implements HasElementClickListener<ProgressBar>, HasClassName<ProgressBar>, HasStyle<ProgressBar>, HasVisibility<ProgressBar> {

  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<Boolean> indeterminateProp =
      PropertyDescriptor.property("indeterminate", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");

  /**
   * Creates a new ProgressBar.
   */
  public ProgressBar() {
    super();
  }

  /**
   * Creates a new ProgressBar with the given value.
   *
   * @param value the current progress as a percentage, 0 to 100
   */
  public ProgressBar(double value) {
    this();
    setValue(value);
  }

  /**
   * Gets the current progress value.
   *
   * @return the progress as a percentage, 0 to 100
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current progress as a percentage, 0 to 100.
   *
   * @param value the progress percentage
   * @return this component
   */
  public ProgressBar setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Returns whether the progress bar is in an indeterminate state.
   *
   * @return {@code true} if the progress bar is indeterminate
   */
  public boolean isIndeterminate() {
    return get(indeterminateProp);
  }

  /**
   * Sets whether the progress bar is in an indeterminate state. When true, the percentage is
   * ignored, the label is hidden, and the progress bar is drawn in an indeterminate state.
   *
   * @param indeterminate {@code true} for indeterminate state
   * @return this component
   */
  public ProgressBar setIndeterminate(boolean indeterminate) {
    set(indeterminateProp, indeterminate);
    return this;
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
   * Sets a custom label for assistive devices.
   *
   * @param label the accessibility label
   * @return this component
   */
  public ProgressBar setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Sets the height of the progress bar.
   *
   * @param value the CSS height value
   * @return this component
   */
  public ProgressBar setHeight(String value) {
    setStyle("--height", value);
    return this;
  }

  /**
   * Sets the color of the track.
   *
   * @param value the CSS color value
   * @return this component
   */
  public ProgressBar setTrackColor(String value) {
    setStyle("--track-color", value);
    return this;
  }

  /**
   * Sets the color of the indicator.
   *
   * @param value the CSS color value
   * @return this component
   */
  public ProgressBar setIndicatorColor(String value) {
    setStyle("--indicator-color", value);
    return this;
  }

  /**
   * Sets the color of the label.
   *
   * @param value the CSS color value
   * @return this component
   */
  public ProgressBar setLabelColor(String value) {
    setStyle("--label-color", value);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
