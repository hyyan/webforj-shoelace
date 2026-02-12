package com.webforj.shoelace.components.progressring;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Progress Ring component ({@code <sl-progress-ring>}).
 *
 * <p>Progress rings are used to show the progress of a determinate operation in a circular format.
 * They display a visual indicator of progress as a percentage from 0 to 100.</p>
 *
 * @see <a href="https://shoelace.style/components/progress-ring">Shoelace Progress Ring</a>
 */
@NodeName("sl-progress-ring")
public final class ProgressRing extends ElementCompositeContainer
    implements HasElementClickListener<ProgressRing>, HasClassName<ProgressRing>, HasStyle<ProgressRing>, HasVisibility<ProgressRing> {

  private final PropertyDescriptor<Double> valueProp =
      PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");

  /**
   * Creates a new ProgressRing.
   */
  public ProgressRing() {
    super();
  }

  /**
   * Creates a new ProgressRing with the given value.
   *
   * @param value the current progress as a percentage, 0 to 100
   */
  public ProgressRing(double value) {
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
  public ProgressRing setValue(double value) {
    set(valueProp, value);
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
  public ProgressRing setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Sets the diameter of the progress ring (cannot be a percentage).
   *
   * @param value the CSS size value
   * @return this component
   */
  public ProgressRing setSize(String value) {
    setStyle("--size", value);
    return this;
  }

  /**
   * Sets the width of the track.
   *
   * @param value the CSS width value
   * @return this component
   */
  public ProgressRing setTrackWidth(String value) {
    setStyle("--track-width", value);
    return this;
  }

  /**
   * Sets the color of the track.
   *
   * @param value the CSS color value
   * @return this component
   */
  public ProgressRing setTrackColor(String value) {
    setStyle("--track-color", value);
    return this;
  }

  /**
   * Sets the width of the indicator. Defaults to the track width.
   *
   * @param value the CSS width value
   * @return this component
   */
  public ProgressRing setIndicatorWidth(String value) {
    setStyle("--indicator-width", value);
    return this;
  }

  /**
   * Sets the color of the indicator.
   *
   * @param value the CSS color value
   * @return this component
   */
  public ProgressRing setIndicatorColor(String value) {
    setStyle("--indicator-color", value);
    return this;
  }

  /**
   * Sets the duration of the indicator's transition when the value changes.
   *
   * @param value the CSS time value (e.g. "0.3s", "200ms")
   * @return this component
   */
  public ProgressRing setIndicatorTransitionDuration(String value) {
    setStyle("--indicator-transition-duration", value);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
