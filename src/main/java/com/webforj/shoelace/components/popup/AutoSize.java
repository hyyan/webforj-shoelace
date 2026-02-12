package com.webforj.shoelace.components.popup;

import com.google.gson.annotations.SerializedName;

/**
 * Auto-size options for the Popup component. Controls whether the popup automatically resizes
 * itself to prevent overflowing.
 */
public enum AutoSize {
  @SerializedName("horizontal")
  HORIZONTAL,

  @SerializedName("vertical")
  VERTICAL,

  @SerializedName("both")
  BOTH;
}
