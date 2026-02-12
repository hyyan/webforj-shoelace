package com.webforj.shoelace.components.include;

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
 * Shoelace Include component ({@code <sl-include>}).
 *
 * <p>Includes give you the power to embed external HTML files into the page. Be sure you trust
 * the content you are including as it will be executed as code and can result in XSS attacks.</p>
 *
 * @see <a href="https://shoelace.style/components/include">Shoelace Include</a>
 */
@NodeName("sl-include")
public final class Include extends ElementComposite
    implements HasElementClickListener<Include>, HasClassName<Include>, HasStyle<Include>, HasVisibility<Include> {

  private final PropertyDescriptor<String> srcProp =
      PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<IncludeMode> modeProp =
      PropertyDescriptor.property("mode", IncludeMode.CORS);
  private final PropertyDescriptor<Boolean> allowScriptsProp =
      PropertyDescriptor.property("allowScripts", false);

  /**
   * Creates a new Include.
   */
  public Include() {
    super();
  }

  /**
   * Creates a new Include with the given source URL.
   *
   * @param src the location of the HTML file to include
   */
  public Include(String src) {
    this();
    setSrc(src);
  }

  /**
   * Gets the source URL of the HTML file to include.
   *
   * @return the source URL
   */
  public String getSrc() {
    return get(srcProp);
  }

  /**
   * Sets the location of the HTML file to include. Be sure you trust the content you are
   * including as it will be executed as code and can result in XSS attacks.
   *
   * @param src the source URL
   * @return this component
   */
  public Include setSrc(String src) {
    set(srcProp, src);
    return this;
  }

  /**
   * Gets the fetch mode.
   *
   * @return the fetch mode
   */
  public IncludeMode getMode() {
    return get(modeProp);
  }

  /**
   * Sets the fetch mode to use.
   *
   * @param mode the fetch mode
   * @return this component
   */
  public Include setMode(IncludeMode mode) {
    set(modeProp, mode);
    return this;
  }

  /**
   * Returns whether included scripts are allowed to be executed.
   *
   * @return {@code true} if scripts are allowed
   */
  public boolean isAllowScripts() {
    return get(allowScriptsProp);
  }

  /**
   * Sets whether included scripts are allowed to be executed. Be sure you trust the content you
   * are including as it will be executed as code and can result in XSS attacks.
   *
   * @param allowScripts {@code true} to allow script execution
   * @return this component
   */
  public Include setAllowScripts(boolean allowScripts) {
    set(allowScriptsProp, allowScripts);
    return this;
  }

  /**
   * Adds a listener for the load event, fired when the included file is loaded.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<Include>> addLoadListener(EventListener<LoadEvent<Include>> listener) {
    return addEventListener(LoadEvent.class, listener);
  }

  /**
   * Adds a listener for the load event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<Include>> onLoad(EventListener<LoadEvent<Include>> listener) {
    return addLoadListener(listener);
  }

  /**
   * Adds a listener for the error event, fired when the included file fails to load.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Include>> addErrorListener(EventListener<ErrorEvent<Include>> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }

  /**
   * Adds a listener for the error event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<Include>> onError(EventListener<ErrorEvent<Include>> listener) {
    return addErrorListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
