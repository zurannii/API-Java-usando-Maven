package br.com.dio.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record SaveSchedukeRequest(
        @NotNull
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @NotNull
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @NotNull
        @JsonProperty("clientId")
        Long clientId
) {}
