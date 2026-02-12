package com.webforj.shoelace.components.relativetime;

import com.google.gson.annotations.SerializedName;

/**
 * The formatting style for the RelativeTime component.
 */
public enum RelativeTimeFormat {
  @SerializedName("long")
  LONG,

  @SerializedName("short")
  SHORT,

  @SerializedName("narrow")
  NARROW;
}
