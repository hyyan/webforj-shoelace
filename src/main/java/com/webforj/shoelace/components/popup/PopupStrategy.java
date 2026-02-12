package com.webforj.shoelace.components.popup;

import com.google.gson.annotations.SerializedName;

/**
 * Positioning strategy options for the Popup component.
 */
public enum PopupStrategy {
  @SerializedName("absolute")
  ABSOLUTE,

  @SerializedName("fixed")
  FIXED;
}
