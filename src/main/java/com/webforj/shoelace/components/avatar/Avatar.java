package com.webforj.shoelace.components.avatar;

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
import com.webforj.shoelace.event.ErrorEvent;

/**
 * Shoelace Avatar component ({@code <sl-avatar>}).
 *
 * <p>Avatars are used to represent a person or object. They can display an image, initials, or a
 * default icon as a fallback. The image loading strategy and shape are configurable.</p>
 *
 * @see <a href="https://shoelace.style/components/avatar">Shoelace Avatar</a>
 */
@NodeName("sl-avatar")
public final class Avatar extends ElementComposite
    implements HasElementClickListener<Avatar>, HasClassName<Avatar>, HasStyle<Avatar>, HasVisibility<Avatar> {

  private final PropertyDescriptor<String> imageProp =
      PropertyDescriptor.property("image", "");
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> initialsProp =
      PropertyDescriptor.property("initials", "");
  private final PropertyDescriptor<AvatarLoading> loadingProp =
      PropertyDescriptor.property("loading", AvatarLoading.EAGER);
  private final PropertyDescriptor<AvatarShape> shapeProp =
      PropertyDescriptor.property("shape", AvatarShape.CIRCLE);

  /**
   * Creates a new Avatar.
   */
  public Avatar() {
    super();
  }

  /**
   * Gets the image source URL.
   *
   * @return the image source URL
   */
  public String getImage() {
    return get(imageProp);
  }

  /**
   * Sets the image source to use for the avatar.
   *
   * @param image the image source URL
   * @return this component
   */
  public Avatar setImage(String image) {
    set(imageProp, image);
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
   * Sets a label to describe the avatar to assistive devices.
   *
   * @param label the accessibility label
   * @return this component
   */
  public Avatar setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the initials displayed as a fallback.
   *
   * @return the initials
   */
  public String getInitials() {
    return get(initialsProp);
  }

  /**
   * Sets initials to use as a fallback when no image is available (1-2 characters max
   * recommended).
   *
   * @param initials the initials to display
   * @return this component
   */
  public Avatar setInitials(String initials) {
    set(initialsProp, initials);
    return this;
  }

  /**
   * Gets the image loading strategy.
   *
   * @return the loading strategy
   */
  public AvatarLoading getLoading() {
    return get(loadingProp);
  }

  /**
   * Sets how the browser should load the image.
   *
   * @param loading the loading strategy
   * @return this component
   */
  public Avatar setLoading(AvatarLoading loading) {
    set(loadingProp, loading);
    return this;
  }

  /**
   * Gets the avatar shape.
   *
   * @return the shape
   */
  public AvatarShape getShape() {
    return get(shapeProp);
  }

  /**
   * Sets the shape of the avatar.
   *
   * @param shape the shape to use
   * @return this component
   */
  public Avatar setShape(AvatarShape shape) {
    set(shapeProp, shape);
    return this;
  }

  /**
   * Adds a listener for the error event, fired when the image fails to load.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Avatar>> addErrorListener(EventListener<ErrorEvent<Avatar>> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }

  /**
   * Adds a listener for the error event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Avatar>> onError(EventListener<ErrorEvent<Avatar>> listener) {
    return addErrorListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
