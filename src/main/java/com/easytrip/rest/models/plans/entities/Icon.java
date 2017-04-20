package com.easytrip.rest.models.plans.entities;

import com.easytrip.rest.models.plans.FoursquareEntity;

public class Icon implements FoursquareEntity {

    /**
     *
     */
    private static final long serialVersionUID = -6661365522571579781L;

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    private String prefix;
    private String suffix;
}
