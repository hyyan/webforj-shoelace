package com.webforj.shoelace.components.breadcrumbitem;

import com.google.gson.annotations.SerializedName;

/**
 * The target attribute for breadcrumb items rendered as links.
 */
public enum BreadcrumbItemTarget {
  @SerializedName("_blank")
  BLANK,

  @SerializedName("_parent")
  PARENT,

  @SerializedName("_self")
  SELF,

  @SerializedName("_top")
  TOP;
}
