package com.webforj.shoelace.components.dropdown;

import com.google.gson.annotations.SerializedName;

/**
 * Sync options for the Dropdown component. Controls whether the popup width or height is synced to
 * the trigger element.
 */
public enum DropdownSync {
  @SerializedName("width")
  WIDTH,

  @SerializedName("height")
  HEIGHT,

  @SerializedName("both")
  BOTH;
}
