package com.webforj.shoelace.components.spinner;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Spinner component ({@code <sl-spinner>}).
 *
 * <p>Spinners are used to show the progress of an indeterminate operation. They provide a visual
 * cue that processing is underway.</p>
 *
 * @see <a href="https://shoelace.style/components/spinner">Shoelace Spinner</a>
 */
@NodeName("sl-spinner")
public final class Spinner extends ElementComposite
    implements HasElementClickListener<Spinner>, HasClassName<Spinner>, HasStyle<Spinner>, HasVisibility<Spinner> {

  /**
   * Creates a new Spinner.
   */
  public Spinner() {
    super();
  }

  /**
   * Sets the width of the spinner's track.
   *
   * @param value the CSS width value
   * @return this component
   */
  public Spinner setTrackWidth(String value) {
    setStyle("--track-width", value);
    return this;
  }

  /**
   * Sets the color of the spinner's track.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Spinner setTrackColor(String value) {
    setStyle("--track-color", value);
    return this;
  }

  /**
   * Sets the color of the spinner's indicator.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Spinner setIndicatorColor(String value) {
    setStyle("--indicator-color", value);
    return this;
  }

  /**
   * Sets the time it takes for the spinner to complete one animation cycle.
   *
   * @param value the CSS time value (e.g. "1s", "500ms")
   * @return this component
   */
  public Spinner setSpeed(String value) {
    setStyle("--speed", value);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
