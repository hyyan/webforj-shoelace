package com.webforj.shoelace.components.iconbutton;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.components.button.Target;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;

/**
 * Shoelace IconButton component ({@code <sl-icon-button>}).
 *
 * <p>Icon buttons are simple, icon-only buttons that can be used for actions and in toolbars.
 * For optimal accessibility, a label should always be provided that describes what the icon button
 * does.</p>
 *
 * @see <a href="https://shoelace.style/components/icon-button">Shoelace Icon Button</a>
 */
@NodeName("sl-icon-button")
public final class IconButton extends ElementComposite
    implements HasElementClickListener<IconButton>, HasClassName<IconButton>, HasStyle<IconButton>, HasVisibility<IconButton> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> libraryProp =
      PropertyDescriptor.property("library", "");
  private final PropertyDescriptor<String> srcProp =
      PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<String> hrefProp =
      PropertyDescriptor.property("href", "");
  private final PropertyDescriptor<Target> targetProp =
      PropertyDescriptor.property("target", Target.SELF);
  private final PropertyDescriptor<String> downloadProp =
      PropertyDescriptor.property("download", "");
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new IconButton.
   */
  public IconButton() {
    super();
  }

  /**
   * Creates a new IconButton with the given icon name.
   *
   * @param name the icon name from the registered icon library
   */
  public IconButton(String name) {
    this();
    setName(name);
  }

  /**
   * Creates a new IconButton with the given icon name and label.
   *
   * @param name the icon name
   * @param label the accessibility label
   */
  public IconButton(String name, String label) {
    this();
    setName(name);
    setLabel(label);
  }

  /**
   * Gets the icon name.
   *
   * @return the icon name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the icon to draw. Available names depend on the icon library being used.
   *
   * @param name the icon name
   * @return this component
   */
  public IconButton setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the icon library name.
   *
   * @return the library name
   */
  public String getLibrary() {
    return get(libraryProp);
  }

  /**
   * Sets the name of a registered custom icon library.
   *
   * @param library the library name
   * @return this component
   */
  public IconButton setLibrary(String library) {
    set(libraryProp, library);
    return this;
  }

  /**
   * Gets the external SVG source URL.
   *
   * @return the source URL
   */
  public String getSrc() {
    return get(srcProp);
  }

  /**
   * Sets an external URL of an SVG file to use as the icon. Be sure you trust the content you are
   * including, as it will be executed as code and can result in XSS attacks.
   *
   * @param src the SVG source URL
   * @return this component
   */
  public IconButton setSrc(String src) {
    set(srcProp, src);
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
   * Sets the href URL. When set, the underlying button will be rendered as an {@code <a>} with
   * this href instead of a {@code <button>}.
   *
   * @param href the href URL
   * @return this component
   */
  public IconButton setHref(String href) {
    set(hrefProp, href);
    return this;
  }

  /**
   * Gets the link target.
   *
   * @return the target
   */
  public Target getTarget() {
    return get(targetProp);
  }

  /**
   * Sets the link target. Tells the browser where to open the link. Only used when {@code href} is
   * set.
   *
   * @param target the target
   * @return this component
   */
  public IconButton setTarget(Target target) {
    set(targetProp, target);
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
   * Only used when {@code href} is set.
   *
   * @param download the download filename
   * @return this component
   */
  public IconButton setDownload(String download) {
    set(downloadProp, download);
    return this;
  }

  /**
   * Gets the accessibility label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the accessibility label. For optimal accessibility, you should always include a label that
   * describes what the icon button does.
   *
   * @param label the accessibility label
   * @return this component
   */
  public IconButton setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets whether the button is disabled.
   *
   * @return {@code true} if the button is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the button is disabled.
   *
   * @param disabled {@code true} to disable the button
   * @return this component
   */
  public IconButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Sets focus on the icon button.
   */
  public void focus() {
    getElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the icon button.
   */
  public void blur() {
    getElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Simulates a click on the icon button.
   */
  public void click() {
    getElement().callJsFunctionVoidAsync("click");
  }

  /**
   * Adds a listener for the blur event, fired when the icon button loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<IconButton>> addBlurListener(EventListener<BlurEvent<IconButton>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<IconButton>> onBlur(EventListener<BlurEvent<IconButton>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the icon button gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<IconButton>> addFocusListener(EventListener<FocusEvent<IconButton>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<IconButton>> onFocus(EventListener<FocusEvent<IconButton>> listener) {
    return addFocusListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
