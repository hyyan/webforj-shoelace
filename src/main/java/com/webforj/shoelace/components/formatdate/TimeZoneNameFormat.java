package com.webforj.shoelace.components.formatdate;

import com.google.gson.annotations.SerializedName;

/**
 * Display format options for the time zone name in the FormatDate component.
 */
public enum TimeZoneNameFormat {
  @SerializedName("short")
  SHORT,

  @SerializedName("long")
  LONG;
}
