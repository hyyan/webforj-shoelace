package com.webforj.shoelace.components.badge;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Badge component ({@code <sl-badge>}).
 *
 * <p>Badges are used to draw attention and display statuses or counts. They can be configured
 * with different theme variants and styled as pills or with a pulsing animation.</p>
 *
 * @see <a href="https://shoelace.style/components/badge">Shoelace Badge</a>
 */
@NodeName("sl-badge")
public final class Badge extends ElementCompositeContainer
    implements HasElementClickListener<Badge>, HasClassName<Badge>, HasStyle<Badge>, HasVisibility<Badge> {

  private final PropertyDescriptor<BadgeVariant> variantProp =
      PropertyDescriptor.property("variant", BadgeVariant.PRIMARY);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> pulseProp =
      PropertyDescriptor.property("pulse", false);

  /**
   * Creates a new Badge.
   */
  public Badge() {
    super();
  }

  /**
   * Gets the badge's theme variant.
   *
   * @return the variant
   */
  public BadgeVariant getVariant() {
    return get(variantProp);
  }

  /**
   * Sets the badge's theme variant.
   *
   * @param variant the variant to set
   * @return this component
   */
  public Badge setVariant(BadgeVariant variant) {
    set(variantProp, variant);
    return this;
  }

  /**
   * Returns whether the badge is rendered as a pill with rounded edges.
   *
   * @return {@code true} if the badge is pill-style
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether the badge is drawn as a pill with rounded edges.
   *
   * @param pill {@code true} to draw as a pill
   * @return this component
   */
  public Badge setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Returns whether the badge is pulsating to draw attention.
   *
   * @return {@code true} if the badge is pulsating
   */
  public boolean isPulse() {
    return get(pulseProp);
  }

  /**
   * Sets whether the badge pulsates to draw attention.
   *
   * @param pulse {@code true} to enable pulsating
   * @return this component
   */
  public Badge setPulse(boolean pulse) {
    set(pulseProp, pulse);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
