package com.riakhin.entity;

import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public enum Features {

    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Features(String value) {
        this.value = value;
    }

    public static Features getFeaturesByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }

        for (Features feature : Features.values()) {
            if (feature.getValue().equals(value)) {
                return feature;
            }
        }
        return null;
    }
}
