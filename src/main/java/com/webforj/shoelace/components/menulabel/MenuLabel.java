package com.webforj.shoelace.components.menulabel;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace MenuLabel component ({@code <sl-menu-label>}).
 *
 * <p>Menu labels are used to describe a group of menu items within a menu.</p>
 *
 * @see <a href="https://shoelace.style/components/menu-label">Shoelace Menu Label</a>
 */
@NodeName("sl-menu-label")
public final class MenuLabel extends ElementCompositeContainer
    implements HasElementClickListener<MenuLabel>, HasClassName<MenuLabel>, HasStyle<MenuLabel>, HasVisibility<MenuLabel> {

  /**
   * Creates a new MenuLabel.
   */
  public MenuLabel() {
    super();
  }

  /**
   * Creates a new MenuLabel with the given text.
   *
   * @param text the label text
   */
  public MenuLabel(String text) {
    this();
    setText(text);
  }

  /**
   * Sets the menu label's text content.
   *
   * @param text the text to display
   * @return this component
   */
  public MenuLabel setText(String text) {
    getElement().setHtml(text);
    return this;
  }

  /**
   * Gets the menu label's text content.
   *
   * @return the label text
   */
  public String getText() {
    return getElement().getHtml();
  }

  Element getOriginalElement() {
    return getElement();
  }
}
