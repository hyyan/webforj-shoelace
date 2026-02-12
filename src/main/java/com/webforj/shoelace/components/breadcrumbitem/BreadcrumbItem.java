package com.webforj.shoelace.components.breadcrumbitem;

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
 * Shoelace BreadcrumbItem component ({@code <sl-breadcrumb-item>}).
 *
 * <p>Breadcrumb items are used inside breadcrumbs to represent individual links in the navigation
 * hierarchy. They can be configured with an href to navigate the user when activated, and support
 * prefix and suffix icons as well as custom separators.</p>
 *
 * @see <a href="https://shoelace.style/components/breadcrumb-item">Shoelace Breadcrumb Item</a>
 */
@NodeName("sl-breadcrumb-item")
public final class BreadcrumbItem extends ElementCompositeContainer
    implements HasElementClickListener<BreadcrumbItem>, HasClassName<BreadcrumbItem>, HasStyle<BreadcrumbItem>,
    HasVisibility<BreadcrumbItem> {

  // Slot constants
  private static final String PREFIX_SLOT = "prefix";
  private static final String SUFFIX_SLOT = "suffix";
  private static final String SEPARATOR_SLOT = "separator";

  // Property descriptors
  private final PropertyDescriptor<String> hrefProp =
      PropertyDescriptor.property("href", "");
  private final PropertyDescriptor<BreadcrumbItemTarget> targetProp =
      PropertyDescriptor.property("target", BreadcrumbItemTarget.SELF);
  private final PropertyDescriptor<String> relProp =
      PropertyDescriptor.property("rel", "noreferrer noopener");

  /**
   * Creates a new BreadcrumbItem.
   */
  public BreadcrumbItem() {
    super();
  }

  /**
   * Creates a new BreadcrumbItem with the given text.
   *
   * @param text the breadcrumb item label text
   */
  public BreadcrumbItem(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a new BreadcrumbItem with the given text and href.
   *
   * @param text the breadcrumb item label text
   * @param href the URL to navigate to
   */
  public BreadcrumbItem(String text, String href) {
    this();
    setText(text);
    setHref(href);
  }

  /**
   * Gets the href URL.
   *
   * @return the href URL
   */
  public String getHref() {
    return get(hrefProp);
  }

  /**
   * Sets an optional URL to direct the user to when the breadcrumb item is activated. When set, a
   * link will be rendered internally. When unset, a button will be rendered instead.
   *
   * @param href the href URL
   * @return this component
   */
  public BreadcrumbItem setHref(String href) {
    set(hrefProp, href);
    return this;
  }

  /**
   * Gets the link target.
   *
   * @return the target
   */
  public BreadcrumbItemTarget getTarget() {
    return get(targetProp);
  }

  /**
   * Sets the link target. Tells the browser where to open the link. Only used when {@code href} is
   * set.
   *
   * @param target the target
   * @return this component
   */
  public BreadcrumbItem setTarget(BreadcrumbItemTarget target) {
    set(targetProp, target);
    return this;
  }

  /**
   * Gets the rel attribute.
   *
   * @return the rel attribute value
   */
  public String getRel() {
    return get(relProp);
  }

  /**
   * Sets the rel attribute to use on the link. Only used when {@code href} is set.
   *
   * @param rel the rel attribute value
   * @return this component
   */
  public BreadcrumbItem setRel(String rel) {
    set(relProp, rel);
    return this;
  }

  /**
   * Sets the breadcrumb item's text content.
   *
   * @param text the text to display
   * @return this component
   */
  public BreadcrumbItem setText(String text) {
    getElement().setHtml(text);
    return this;
  }

  /**
   * Gets the breadcrumb item's text content.
   *
   * @return the breadcrumb item text
   */
  public String getText() {
    return getElement().getHtml();
  }

  /**
   * Adds components to the prefix slot.
   *
   * @param components the components to add to the prefix slot
   * @return this component
   */
  public BreadcrumbItem addToPrefix(Component... components) {
    getElement().add(PREFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the suffix slot.
   *
   * @param components the components to add to the suffix slot
   * @return this component
   */
  public BreadcrumbItem addToSuffix(Component... components) {
    getElement().add(SUFFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the separator slot.
   *
   * @param components the components to use as the separator for this item
   * @return this component
   */
  public BreadcrumbItem addToSeparator(Component... components) {
    getElement().add(SEPARATOR_SLOT, components);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
