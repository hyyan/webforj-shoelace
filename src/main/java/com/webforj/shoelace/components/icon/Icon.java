package com.webforj.shoelace.components.icon;

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
import com.webforj.shoelace.event.ErrorEvent;
import com.webforj.shoelace.event.LoadEvent;

/**
 * Shoelace Icon component ({@code <sl-icon>}).
 *
 * <p>Icons are symbols that can be used to represent various options within an application. Shoelace
 * bundles Bootstrap Icons by default but supports custom icon libraries as well.</p>
 *
 * @see <a href="https://shoelace.style/components/icon">Shoelace Icon</a>
 */
@NodeName("sl-icon")
public final class Icon extends ElementComposite
    implements HasElementClickListener<Icon>, HasClassName<Icon>, HasStyle<Icon>, HasVisibility<Icon> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> srcProp =
      PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> libraryProp =
      PropertyDescriptor.property("library", "default");

  /**
   * Creates a new Icon.
   */
  public Icon() {
    super();
  }

  /**
   * Creates a new Icon with the given name.
   *
   * @param name the icon name from the registered icon library
   */
  public Icon(String name) {
    this();
    setName(name);
  }

  /**
   * Creates a new Icon with the given name and library.
   *
   * @param name the icon name
   * @param library the icon library to use
   */
  public Icon(String name, String library) {
    this();
    setName(name);
    setLibrary(library);
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
   * Sets the icon name from the registered icon library.
   *
   * @param name the icon name
   * @return this component
   */
  public Icon setName(String name) {
    set(nameProp, name);
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
   * Sets an external URL of an SVG file to use as the icon.
   *
   * @param src the SVG source URL
   * @return this component
   */
  public Icon setSrc(String src) {
    set(srcProp, src);
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
   * Sets an alternate description for assistive devices. If omitted, the icon will be considered
   * presentational and ignored by assistive devices.
   *
   * @param label the accessibility label
   * @return this component
   */
  public Icon setLabel(String label) {
    set(labelProp, label);
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
  public Icon setLibrary(String library) {
    set(libraryProp, library);
    return this;
  }

  /**
   * Adds a listener for the load event, fired when the icon has loaded successfully.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<Icon>> addLoadListener(EventListener<LoadEvent<Icon>> listener) {
    return addEventListener(LoadEvent.class, listener);
  }

  /**
   * Adds a listener for the load event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<Icon>> onLoad(EventListener<LoadEvent<Icon>> listener) {
    return addLoadListener(listener);
  }

  /**
   * Adds a listener for the error event, fired when the icon fails to load.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Icon>> addErrorListener(EventListener<ErrorEvent<Icon>> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }

  /**
   * Adds a listener for the error event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Icon>> onError(EventListener<ErrorEvent<Icon>> listener) {
    return addErrorListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
