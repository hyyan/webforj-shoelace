package com.webforj.shoelace.components.breadcrumb;

import com.webforj.component.Component;
import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace Breadcrumb component ({@code <sl-breadcrumb>}).
 *
 * <p>Breadcrumbs provide a group of links that help users navigate through a hierarchy of pages.
 * They accept breadcrumb items and an optional custom separator.</p>
 *
 * @see <a href="https://shoelace.style/components/breadcrumb">Shoelace Breadcrumb</a>
 */
@NodeName("sl-breadcrumb")
public final class Breadcrumb extends ElementCompositeContainer
    implements HasElementClickListener<Breadcrumb>, HasClassName<Breadcrumb>, HasStyle<Breadcrumb>, HasVisibility<Breadcrumb> {

  // Slot constants
  private static final String SEPARATOR_SLOT = "separator";

  // Property descriptors
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");

  /**
   * Creates a new Breadcrumb.
   */
  public Breadcrumb() {
    super();
  }

  /**
   * Gets the accessibility label for the breadcrumb control.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the label to use for the breadcrumb control. This will not be shown on the screen, but it
   * will be announced by screen readers and other assistive devices to provide more context for
   * users.
   *
   * @param label the accessibility label
   * @return this component
   */
  public Breadcrumb setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Adds components to the separator slot.
   *
   * @param components the components to use as the separator between breadcrumb items
   * @return this component
   */
  public Breadcrumb addToSeparator(Component... components) {
    getElement().add(SEPARATOR_SLOT, components);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
