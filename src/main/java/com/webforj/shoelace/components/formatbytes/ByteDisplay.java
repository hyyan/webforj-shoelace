package com.webforj.shoelace.components.formatbytes;

import com.google.gson.annotations.SerializedName;

/**
 * Determines how to display the formatted byte result.
 */
public enum ByteDisplay {
  @SerializedName("long")
  LONG,

  @SerializedName("short")
  SHORT,

  @SerializedName("narrow")
  NARROW;
}
