package com.webforj.shoelace.components.skeleton;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Skeleton component ({@code <sl-skeleton>}).
 *
 * <p>Skeletons are used to provide a visual placeholder while content is loading. They can use
 * different animation effects such as pulse or sheen to indicate loading state.</p>
 *
 * @see <a href="https://shoelace.style/components/skeleton">Shoelace Skeleton</a>
 */
@NodeName("sl-skeleton")
public final class Skeleton extends ElementComposite
    implements HasElementClickListener<Skeleton>, HasClassName<Skeleton>, HasStyle<Skeleton>, HasVisibility<Skeleton> {

  private final PropertyDescriptor<SkeletonEffect> effectProp =
      PropertyDescriptor.property("effect", SkeletonEffect.NONE);

  /**
   * Creates a new Skeleton.
   */
  public Skeleton() {
    super();
  }

  /**
   * Gets the skeleton's animation effect.
   *
   * @return the effect
   */
  public SkeletonEffect getEffect() {
    return get(effectProp);
  }

  /**
   * Sets the skeleton's animation effect.
   *
   * @param effect the effect to use
   * @return this component
   */
  public Skeleton setEffect(SkeletonEffect effect) {
    set(effectProp, effect);
    return this;
  }

  /**
   * Sets the skeleton's border radius.
   *
   * @param value the CSS border-radius value
   * @return this component
   */
  public Skeleton setBorderRadius(String value) {
    setStyle("--border-radius", value);
    return this;
  }

  /**
   * Sets the color of the skeleton.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Skeleton setColor(String value) {
    setStyle("--color", value);
    return this;
  }

  /**
   * Sets the sheen color when the skeleton is in its loading state.
   *
   * @param value the CSS color value
   * @return this component
   */
  public Skeleton setSheenColor(String value) {
    setStyle("--sheen-color", value);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
