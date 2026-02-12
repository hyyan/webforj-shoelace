package com.webforj.shoelace.components.tag;

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
import com.webforj.shoelace.Size;
import com.webforj.shoelace.components.tag.event.RemoveEvent;

/**
 * Shoelace Tag component ({@code <sl-tag>}).
 *
 * <p>Tags are used as labels to organize things or to indicate a selection. They can be configured
 * with different theme variants, sizes, and can optionally be removable or styled as pills.</p>
 *
 * @see <a href="https://shoelace.style/components/tag">Shoelace Tag</a>
 */
@NodeName("sl-tag")
public final class Tag extends ElementCompositeContainer
    implements HasElementClickListener<Tag>, HasClassName<Tag>, HasStyle<Tag>, HasVisibility<Tag> {

  private final PropertyDescriptor<TagVariant> variantProp =
      PropertyDescriptor.property("variant", TagVariant.NEUTRAL);
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> removableProp =
      PropertyDescriptor.property("removable", false);

  /**
   * Creates a new Tag.
   */
  public Tag() {
    super();
  }

  /**
   * Gets the tag's theme variant.
   *
   * @return the variant
   */
  public TagVariant getVariant() {
    return get(variantProp);
  }

  /**
   * Sets the tag's theme variant.
   *
   * @param variant the variant to set
   * @return this component
   */
  public Tag setVariant(TagVariant variant) {
    set(variantProp, variant);
    return this;
  }

  /**
   * Gets the tag's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the tag's size.
   *
   * @param size the size to set
   * @return this component
   */
  public Tag setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Returns whether the tag is rendered as a pill with rounded edges.
   *
   * @return {@code true} if the tag is pill-style
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether the tag is drawn as a pill with rounded edges.
   *
   * @param pill {@code true} to draw as a pill
   * @return this component
   */
  public Tag setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Returns whether the tag is removable.
   *
   * @return {@code true} if the tag shows a remove button
   */
  public boolean isRemovable() {
    return get(removableProp);
  }

  /**
   * Sets whether the tag is removable and shows a remove button.
   *
   * @param removable {@code true} to make the tag removable
   * @return this component
   */
  public Tag setRemovable(boolean removable) {
    set(removableProp, removable);
    return this;
  }

  /**
   * Adds a listener for the remove event, fired when the remove button is activated.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RemoveEvent<Tag>> addRemoveListener(
      EventListener<RemoveEvent<Tag>> listener) {
    return addEventListener(RemoveEvent.class, listener);
  }

  /**
   * Adds a listener for the remove event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RemoveEvent<Tag>> onRemove(EventListener<RemoveEvent<Tag>> listener) {
    return addRemoveListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
