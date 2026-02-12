package com.webforj.shoelace.components.formatdate;

import com.google.gson.annotations.SerializedName;

/**
 * The hour format for the FormatDate component.
 */
public enum HourFormat {
  @SerializedName("auto")
  AUTO,

  @SerializedName("12")
  TWELVE,

  @SerializedName("24")
  TWENTY_FOUR;
}
