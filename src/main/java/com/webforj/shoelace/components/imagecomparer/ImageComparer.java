package com.webforj.shoelace.components.imagecomparer;

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
import com.webforj.shoelace.event.ChangeEvent;

/**
 * Shoelace ImageComparer component ({@code <sl-image-comparer>}).
 *
 * <p>Compare visual differences between similar photos with a side-by-side view. The user can
 * drag the divider to reveal more or less of each image.</p>
 *
 * @see <a href="https://shoelace.style/components/image-comparer">Shoelace Image Comparer</a>
 */
@NodeName("sl-image-comparer")
public final class ImageComparer extends ElementCompositeContainer
    implements HasElementClickListener<ImageComparer>, HasClassName<ImageComparer>, HasStyle<ImageComparer>,
    HasVisibility<ImageComparer> {

  private static final String BEFORE_SLOT = "before";
  private static final String AFTER_SLOT = "after";
  private static final String HANDLE_SLOT = "handle";

  private final PropertyDescriptor<Integer> positionProp =
      PropertyDescriptor.property("position", 50);

  /**
   * Creates a new ImageComparer.
   */
  public ImageComparer() {
    super();
  }

  /**
   * Gets the position of the divider as a percentage.
   *
   * @return the position percentage
   */
  public int getPosition() {
    return get(positionProp);
  }

  /**
   * Sets the position of the divider as a percentage.
   *
   * @param position the position percentage
   * @return this component
   */
  public ImageComparer setPosition(int position) {
    set(positionProp, position);
    return this;
  }

  /**
   * Adds components to the before slot.
   *
   * @param components the components to add to the before slot
   * @return this component
   */
  public ImageComparer addToBefore(Component... components) {
    getElement().add(BEFORE_SLOT, components);
    return this;
  }

  /**
   * Adds components to the after slot.
   *
   * @param components the components to add to the after slot
   * @return this component
   */
  public ImageComparer addToAfter(Component... components) {
    getElement().add(AFTER_SLOT, components);
    return this;
  }

  /**
   * Adds components to the handle slot.
   *
   * @param components the components to add to the handle slot
   * @return this component
   */
  public ImageComparer addToHandle(Component... components) {
    getElement().add(HANDLE_SLOT, components);
    return this;
  }

  /**
   * Adds a listener for the change event, fired when the position changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<ImageComparer>> addChangeListener(
      EventListener<ChangeEvent<ImageComparer>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<ImageComparer>> onChange(EventListener<ChangeEvent<ImageComparer>> listener) {
    return addChangeListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
