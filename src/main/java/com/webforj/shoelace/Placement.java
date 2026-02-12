package com.webforj.shoelace;

import com.google.gson.annotations.SerializedName;

/**
 * Shared placement options used by multiple Shoelace components such as Dropdown, Popup, and
 * Tooltip.
 */
public enum Placement {
  @SerializedName("top")
  TOP,

  @SerializedName("top-start")
  TOP_START,

  @SerializedName("top-end")
  TOP_END,

  @SerializedName("bottom")
  BOTTOM,

  @SerializedName("bottom-start")
  BOTTOM_START,

  @SerializedName("bottom-end")
  BOTTOM_END,

  @SerializedName("right")
  RIGHT,

  @SerializedName("right-start")
  RIGHT_START,

  @SerializedName("right-end")
  RIGHT_END,

  @SerializedName("left")
  LEFT,

  @SerializedName("left-start")
  LEFT_START,

  @SerializedName("left-end")
  LEFT_END;
}
