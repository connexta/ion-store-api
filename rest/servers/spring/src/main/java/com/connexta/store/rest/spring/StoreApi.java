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
package com.connexta.store.rest.spring;

import com.connexta.store.rest.models.AddMetadataRequest;
import com.connexta.store.rest.models.ErrorMessage;
import com.connexta.store.rest.models.QuarantineRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Provides mechanisms for operating on Datasets (files with associated metadata). */
@Validated
@Api(value = "Store")
public interface StoreApi {

  // See https://semver.org/#is-there-a-suggested-regular-expression-regex-to-check-a-semver-string
  String SEMANTIC_VERSION_REGEX =
      "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";

  @ApiOperation(
      value = "Add metadata to a Dataset.",
      nickname = "addMetadata",
      notes = "Clients send information about metadata to add to an existing Dataset.",
      tags = {
        "store, promote, addMetadata",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "The metadata was added to the Dataset."),
        @ApiResponse(
            code = 400,
            message =
                "The client message could not be understood by the server due to invalid format or syntax.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 401,
            message = "The client could not be authenticated.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 403,
            message = "The client is not authorized.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 404,
            message = "The requested Dataset could not be found.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 501,
            message = "The requested API version is not supported and therefore not implemented.",
            response = ErrorMessage.class)
      })
  @RequestMapping(
      value = "/dataset/{datasetId}",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.PUT)
  @ResponseHeader(
      name = "Content-Version",
      description =
          "The API version used by the server to produce the REST message. The server will accept messages for any minor versions prior to this one.",
      response = String.class)
  default ResponseEntity<Void> addMetadata(
      @ApiParam(
              value =
                  "The API version used by the client to produce the REST message. The client must accept responses marked with any minor versions after this one. This implies that all future minor versions of the message are backward compatible with all previous minor versions of the same message.",
              required = true)
          @RequestHeader(value = "Accept-Version", required = true)
          @NotNull
          @Pattern(regexp = SEMANTIC_VERSION_REGEX)
          String acceptVersion,
      @ApiParam(value = "The ID of the Dataset.", required = true)
          @PathVariable("datasetId")
          UUID datasetId,
      @ApiParam(value = "A request to add metadata to a Dataset.", required = true)
          @Valid
          @RequestBody
          AddMetadataRequest addMetadataRequest)
      throws Exception {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @ApiOperation(
      value = "Mark a Dataset as quarantined, making the data within the set inaccessible.",
      nickname = "quarantine",
      notes =
          "Clients send metadata information which will be quarantined in addition to the Dataset.",
      tags = {
        "store",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "The Dataset and additional metadata were successfully quarantined."),
        @ApiResponse(
            code = 400,
            message =
                "The client message could not be understood by the server due to invalid format or syntax.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 401,
            message = "The client could not be authenticated.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 403,
            message = "The client is not authorized.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 404,
            message = "The requested Dataset could not be found.",
            response = ErrorMessage.class),
        @ApiResponse(
            code = 501,
            message = "The requested API version is not supported and therefore not implemented.",
            response = ErrorMessage.class)
      })
  @RequestMapping(
      value = "/dataset/{datasetId}/quarantine",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST)
  @ResponseHeader(
      name = "Content-Version",
      description =
          "The API version used by the server to produce the REST message. The server will accept messages for any minor versions prior to this one.",
      response = String.class)
  default ResponseEntity<Void> quarantine(
      @ApiParam(
              value =
                  "The API version used by the client to produce the REST message. The client must accept responses marked with any minor versions after this one. This implies that all future minor versions of the message are backward compatible with all previous minor versions of the same message.",
              required = true)
          @RequestHeader(value = "Accept-Version", required = true)
          @NotNull
          @Pattern(regexp = SEMANTIC_VERSION_REGEX)
          String acceptVersion,
      @ApiParam(value = "The ID of the Dataset.", required = true)
          @PathVariable("datasetId")
          UUID datasetId,
      @ApiParam(
              value = "A request to quarantine a Dataset and any additional metadata.",
              required = true)
          @Valid
          @RequestBody
          QuarantineRequest quarantineRequest) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
