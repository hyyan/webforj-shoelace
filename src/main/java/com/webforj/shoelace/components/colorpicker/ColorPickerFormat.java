package com.webforj.shoelace.components.colorpicker;

import com.google.gson.annotations.SerializedName;

/**
 * Color format options for the ColorPicker component.
 *
 * <p>If opacity is enabled, these will translate to HEXA, RGBA, HSLA, and HSVA respectively.</p>
 */
public enum ColorPickerFormat {
  @SerializedName("hex")
  HEX,

  @SerializedName("rgb")
  RGB,

  @SerializedName("hsl")
  HSL,

  @SerializedName("hsv")
  HSV;
}
