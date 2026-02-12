package com.webforj.shoelace.components.visuallyhidden;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;

/**
 * Shoelace Visually Hidden component ({@code <sl-visually-hidden>}).
 *
 * <p>The visually hidden utility makes content accessible to assistive devices without displaying
 * it on the screen. This is useful for providing additional context, such as skip links or labels,
 * that sighted users do not need to see.</p>
 *
 * @see <a href="https://shoelace.style/components/visually-hidden">Shoelace Visually Hidden</a>
 */
@NodeName("sl-visually-hidden")
public final class VisuallyHidden extends ElementCompositeContainer
    implements HasElementClickListener<VisuallyHidden>, HasClassName<VisuallyHidden>, HasStyle<VisuallyHidden> {

  /**
   * Creates a new VisuallyHidden.
   */
  public VisuallyHidden() {
    super();
  }

  Element getOriginalElement() {
    return getElement();
  }
}
