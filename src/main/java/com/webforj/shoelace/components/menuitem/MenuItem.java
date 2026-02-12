package com.webforj.shoelace.components.menuitem;

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
 * Shoelace MenuItem component ({@code <sl-menu-item>}).
 *
 * <p>Menu items are used inside menus to represent individual options the user can select. They can
 * be configured as normal items or checkboxes, and support prefix and suffix icons as well as
 * nested submenus.</p>
 *
 * @see <a href="https://shoelace.style/components/menu-item">Shoelace Menu Item</a>
 */
@NodeName("sl-menu-item")
public final class MenuItem extends ElementCompositeContainer
    implements HasElementClickListener<MenuItem>, HasClassName<MenuItem>, HasStyle<MenuItem>, HasVisibility<MenuItem> {

  // Slot constants
  private static final String PREFIX_SLOT = "prefix";
  private static final String SUFFIX_SLOT = "suffix";
  private static final String SUBMENU_SLOT = "submenu";

  // Property descriptors
  private final PropertyDescriptor<MenuItemType> typeProp =
      PropertyDescriptor.property("type", MenuItemType.NORMAL);
  private final PropertyDescriptor<Boolean> checkedProp =
      PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Boolean> loadingProp =
      PropertyDescriptor.property("loading", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> hrefProp =
      PropertyDescriptor.property("href", "");
  private final PropertyDescriptor<String> targetProp =
      PropertyDescriptor.property("target", "");
  private final PropertyDescriptor<String> relProp =
      PropertyDescriptor.property("rel", "");
  private final PropertyDescriptor<String> downloadProp =
      PropertyDescriptor.property("download", "");

  /**
   * Creates a new MenuItem.
   */
  public MenuItem() {
    super();
  }

  /**
   * Creates a new MenuItem with the given text.
   *
   * @param text the menu item label text
   */
  public MenuItem(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a new MenuItem with the given text and value.
   *
   * @param text the menu item label text
   * @param value the value to associate with this item
   */
  public MenuItem(String text, String value) {
    this();
    setText(text);
    setValue(value);
  }

  /**
   * Gets the type of menu item.
   *
   * @return the menu item type
   */
  public MenuItemType getType() {
    return get(typeProp);
  }

  /**
   * Sets the type of menu item to render. To use {@code checked}, this value must be set to
   * {@code checkbox}.
   *
   * @param type the menu item type
   * @return this component
   */
  public MenuItem setType(MenuItemType type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Returns whether the item is in a checked state.
   *
   * @return {@code true} if the item is checked
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Sets whether to draw the item in a checked state.
   *
   * @param checked {@code true} to check the item
   * @return this component
   */
  public MenuItem setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Gets the value of the menu item.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets a unique value to store in the menu item. This can be used as a way to identify menu
   * items when selected.
   *
   * @param value the value
   * @return this component
   */
  public MenuItem setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Returns whether the menu item is in a loading state.
   *
   * @return {@code true} if the item is loading
   */
  public boolean isLoading() {
    return get(loadingProp);
  }

  /**
   * Sets whether to draw the menu item in a loading state.
   *
   * @param loading {@code true} to show loading state
   * @return this component
   */
  public MenuItem setLoading(boolean loading) {
    set(loadingProp, loading);
    return this;
  }

  /**
   * Returns whether the menu item is disabled.
   *
   * @return {@code true} if the item is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether to draw the menu item in a disabled state, preventing selection.
   *
   * @param disabled {@code true} to disable the item
   * @return this component
   */
  public MenuItem setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
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
   * Sets the href URL. When set, the menu item will be rendered as a link.
   *
   * @param href the href URL
   * @return this component
   */
  public MenuItem setHref(String href) {
    set(hrefProp, href);
    return this;
  }

  /**
   * Gets the link target.
   *
   * @return the target
   */
  public String getTarget() {
    return get(targetProp);
  }

  /**
   * Sets the link target. Tells the browser where to open the link. Only used when {@code href} is
   * present.
   *
   * @param target the target
   * @return this component
   */
  public MenuItem setTarget(String target) {
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
   * Sets the rel attribute for the underlying link. Only used when {@code href} is present.
   *
   * @param rel the rel attribute value
   * @return this component
   */
  public MenuItem setRel(String rel) {
    set(relProp, rel);
    return this;
  }

  /**
   * Gets the download filename.
   *
   * @return the download filename
   */
  public String getDownload() {
    return get(downloadProp);
  }

  /**
   * Sets the download filename. Tells the browser to download the linked file as this filename.
   * Only used when {@code href} is present.
   *
   * @param download the download filename
   * @return this component
   */
  public MenuItem setDownload(String download) {
    set(downloadProp, download);
    return this;
  }

  /**
   * Sets the menu item's text content.
   *
   * @param text the text to display
   * @return this component
   */
  public MenuItem setText(String text) {
    getElement().setHtml(text);
    return this;
  }

  /**
   * Gets the menu item's text content.
   *
   * @return the menu item text
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
  public MenuItem addToPrefix(Component... components) {
    getElement().add(PREFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the suffix slot.
   *
   * @param components the components to add to the suffix slot
   * @return this component
   */
  public MenuItem addToSuffix(Component... components) {
    getElement().add(SUFFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the submenu slot.
   *
   * @param components the components to add to the submenu slot
   * @return this component
   */
  public MenuItem addToSubmenu(Component... components) {
    getElement().add(SUBMENU_SLOT, components);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
