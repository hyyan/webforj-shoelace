package com.webforj.shoelace.components.formatdate;

import com.google.gson.annotations.SerializedName;

/**
 * Display format options for the month in the FormatDate component.
 */
public enum MonthFormat {
  @SerializedName("numeric")
  NUMERIC,

  @SerializedName("2-digit")
  TWO_DIGIT,

  @SerializedName("narrow")
  NARROW,

  @SerializedName("short")
  SHORT,

  @SerializedName("long")
  LONG;
}
