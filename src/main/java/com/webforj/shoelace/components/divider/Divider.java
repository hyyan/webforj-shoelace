package com.webforj.shoelace.components.divider;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Divider component ({@code <sl-divider>}).
 *
 * <p>Dividers are used to visually separate or group elements.</p>
 *
 * @see <a href="https://shoelace.style/components/divider">Shoelace Divider</a>
 */
@NodeName("sl-divider")
public final class Divider extends ElementComposite
    implements HasElementClickListener<Divider>, HasClassName<Divider>, HasStyle<Divider>, HasVisibility<Divider> {

  private final PropertyDescriptor<Boolean> verticalProp =
      PropertyDescriptor.property("vertical", false);

  /**
   * Creates a new Divider.
   */
  public Divider() {
    super();
  }

  /**
   * Checks whether the divider is drawn in a vertical orientation.
   *
   * @return {@code true} if the divider is vertical, {@code false} otherwise
   */
  public boolean isVertical() {
    return get(verticalProp);
  }

  /**
   * Sets whether the divider is drawn in a vertical orientation.
   *
   * @param vertical {@code true} to draw the divider vertically
   * @return this component
   */
  public Divider setVertical(boolean vertical) {
    set(verticalProp, vertical);
    return this;
  }

  /**
   * Sets the color of the divider.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Divider setColor(String value) {
    setStyle("--color", value);
    return this;
  }

  /**
   * Sets the width of the divider.
   *
   * @param value the CSS width value
   * @return this component
   */
  public Divider setDividerWidth(String value) {
    setStyle("--width", value);
    return this;
  }

  /**
   * Sets the spacing of the divider.
   *
   * @param value the CSS spacing value
   * @return this component
   */
  public Divider setSpacing(String value) {
    setStyle("--spacing", value);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
