package com.webforj.shoelace.components.formatdate;

import com.google.gson.annotations.SerializedName;

/**
 * Display format options for weekday and era in the FormatDate component.
 */
public enum NarrowShortLong {
  @SerializedName("narrow")
  NARROW,

  @SerializedName("short")
  SHORT,

  @SerializedName("long")
  LONG;
}
