package com.webforj.shoelace.components.formatdate;

import com.google.gson.annotations.SerializedName;

/**
 * Display format options for year, day, hour, minute, and second in the FormatDate component.
 */
public enum NumericTwoDigit {
  @SerializedName("numeric")
  NUMERIC,

  @SerializedName("2-digit")
  TWO_DIGIT;
}
