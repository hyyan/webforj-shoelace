package com.webforj.shoelace.components.qrcode;

import com.google.gson.annotations.SerializedName;

/**
 * Error correction levels for the QR code component.
 *
 * <p>Higher error correction levels make the QR code more resilient to damage but also increase
 * the size of the code.</p>
 */
public enum ErrorCorrectionLevel {
  @SerializedName("L")
  LOW,

  @SerializedName("M")
  MEDIUM,

  @SerializedName("Q")
  QUARTILE,

  @SerializedName("H")
  HIGH;
}
