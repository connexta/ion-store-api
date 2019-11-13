/**
 * Copyright (c) Connexta
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.connexta.store.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request
 */
public class QuarantineRequest {

  @JsonProperty("metadataInfos")
  @Valid
  private List<MetadataInfo> metadataInfos = new ArrayList<>();

  public QuarantineRequest metadataInfos(List<MetadataInfo> metadataInfos) {
    this.metadataInfos = metadataInfos;
    return this;
  }

  public QuarantineRequest addMetadataInfo(MetadataInfo metadataInfo) {
    this.metadataInfos.add(metadataInfo);
    return this;
  }

  /**
   * An array of the information for each metadata type that will be quarantined.
   *
   * @return metadataInfos
   */
  @ApiModelProperty(
      required = true,
      value = "An array of the information for each metadata type that will be quarantined.")
  @NotNull
  @Valid
  @Size
  public List<MetadataInfo> getMetadataInfos() {
    return List.copyOf(metadataInfos);
  }

  public void setMetadataInformations(List<MetadataInfo> metadataInfos) {
    this.metadataInfos = metadataInfos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuarantineRequest quarantineRequest = (QuarantineRequest) o;
    return Objects.equals(this.metadataInfos, quarantineRequest.metadataInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataInfos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuarantineRequest {\n");
    sb.append("    metadataInfos: ").append(toIndentedString(metadataInfos)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
