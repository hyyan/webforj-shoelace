package com.webforj.shoelace.components.card;

import com.webforj.component.Component;
import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;

/**
 * Shoelace Card component ({@code <sl-card>}).
 *
 * <p>Cards can be used to group related subjects in a container. They support optional header,
 * footer, and image slots for flexible content layout.</p>
 *
 * @see <a href="https://shoelace.style/components/card">Shoelace Card</a>
 */
@NodeName("sl-card")
public final class Card extends ElementCompositeContainer
    implements HasElementClickListener<Card>, HasClassName<Card>, HasStyle<Card> {

  private static final String HEADER_SLOT = "header";
  private static final String FOOTER_SLOT = "footer";
  private static final String IMAGE_SLOT = "image";

  /**
   * Creates a new Card.
   */
  public Card() {
    super();
  }

  /**
   * Adds components to the header slot.
   *
   * @param components the components to add to the header slot
   * @return this component
   */
  public Card addToHeader(Component... components) {
    getElement().add(HEADER_SLOT, components);
    return this;
  }

  /**
   * Adds components to the footer slot.
   *
   * @param components the components to add to the footer slot
   * @return this component
   */
  public Card addToFooter(Component... components) {
    getElement().add(FOOTER_SLOT, components);
    return this;
  }

  /**
   * Adds components to the image slot.
   *
   * @param components the components to add to the image slot
   * @return this component
   */
  public Card addToImage(Component... components) {
    getElement().add(IMAGE_SLOT, components);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
