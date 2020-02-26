package com.web_kabinet.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;


public enum Operation implements Serializable {
    @Enumerated(EnumType.STRING)
    COMING, CONSUMPTION, DRYING, CLEANING_DRYING;
}
