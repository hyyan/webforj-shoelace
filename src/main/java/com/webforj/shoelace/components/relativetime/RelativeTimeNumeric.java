package com.webforj.shoelace.components.relativetime;

import com.google.gson.annotations.SerializedName;

/**
 * The numeric display mode for the RelativeTime component.
 */
public enum RelativeTimeNumeric {
  @SerializedName("always")
  ALWAYS,

  @SerializedName("auto")
  AUTO;
}
