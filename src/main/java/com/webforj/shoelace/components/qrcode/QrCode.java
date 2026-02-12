package com.webforj.shoelace.components.qrcode;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace QR Code component ({@code <sl-qr-code>}).
 *
 * <p>Generates a QR code and renders it using the Canvas API. QR codes are useful for providing
 * small pieces of information to users who can quickly scan them with a smartphone.</p>
 *
 * @see <a href="https://shoelace.style/components/qr-code">Shoelace QR Code</a>
 */
@NodeName("sl-qr-code")
public final class QrCode extends ElementComposite
    implements HasElementClickListener<QrCode>, HasClassName<QrCode>, HasStyle<QrCode>, HasVisibility<QrCode> {

  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Integer> sizeProp =
      PropertyDescriptor.property("size", 128);
  private final PropertyDescriptor<String> fillProp =
      PropertyDescriptor.property("fill", "black");
  private final PropertyDescriptor<String> backgroundProp =
      PropertyDescriptor.property("background", "white");
  private final PropertyDescriptor<Double> radiusProp =
      PropertyDescriptor.property("radius", 0.0);
  private final PropertyDescriptor<ErrorCorrectionLevel> errorCorrectionProp =
      PropertyDescriptor.property("errorCorrection", ErrorCorrectionLevel.HIGH);

  /**
   * Creates a new QR Code.
   */
  public QrCode() {
    super();
  }

  /**
   * Creates a new QR Code with the given value.
   *
   * @param value the value to encode in the QR code
   */
  public QrCode(String value) {
    this();
    setValue(value);
  }

  /**
   * Gets the QR code's value.
   *
   * @return the value encoded in the QR code
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the QR code's value. This is the data that will be encoded.
   *
   * @param value the value to encode
   * @return this component
   */
  public QrCode setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the accessibility label.
   *
   * @return the label for assistive devices
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the label for assistive devices to announce. If unspecified, the value will be used
   * instead.
   *
   * @param label the accessibility label
   * @return this component
   */
  public QrCode setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the size of the QR code in pixels.
   *
   * @return the size in pixels
   */
  public Integer getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the size of the QR code in pixels.
   *
   * @param size the size in pixels
   * @return this component
   */
  public QrCode setSize(Integer size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets the fill color of the QR code.
   *
   * @return the fill color
   */
  public String getFill() {
    return get(fillProp);
  }

  /**
   * Sets the fill color. This can be any valid CSS color, but not a CSS custom property.
   *
   * @param fill the CSS color value
   * @return this component
   */
  public QrCode setFill(String fill) {
    set(fillProp, fill);
    return this;
  }

  /**
   * Gets the background color of the QR code.
   *
   * @return the background color
   */
  public String getBackground() {
    return get(backgroundProp);
  }

  /**
   * Sets the background color. This can be any valid CSS color or {@code transparent}. It cannot
   * be a CSS custom property.
   *
   * @param background the CSS color value
   * @return this component
   */
  public QrCode setBackground(String background) {
    set(backgroundProp, background);
    return this;
  }

  /**
   * Gets the edge radius of each module.
   *
   * @return the radius value
   */
  public Double getRadius() {
    return get(radiusProp);
  }

  /**
   * Sets the edge radius of each module. Must be between 0 and 0.5.
   *
   * @param radius the radius value between 0 and 0.5
   * @return this component
   */
  public QrCode setRadius(Double radius) {
    set(radiusProp, radius);
    return this;
  }

  /**
   * Gets the error correction level.
   *
   * @return the error correction level
   */
  public ErrorCorrectionLevel getErrorCorrection() {
    return get(errorCorrectionProp);
  }

  /**
   * Sets the level of error correction to use. Higher levels make the QR code more resilient to
   * damage but also increase its size.
   *
   * @param errorCorrection the error correction level
   * @return this component
   */
  public QrCode setErrorCorrection(ErrorCorrectionLevel errorCorrection) {
    set(errorCorrectionProp, errorCorrection);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
