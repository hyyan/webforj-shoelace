package com.webforj.shoelace.components.formatbytes;

import com.google.gson.annotations.SerializedName;

/**
 * The type of unit to display for the FormatBytes component.
 */
public enum ByteUnit {
  @SerializedName("byte")
  BYTE,

  @SerializedName("bit")
  BIT;
}
