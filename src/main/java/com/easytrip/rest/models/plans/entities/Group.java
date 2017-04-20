/*
 * FoursquareAPI - Foursquare API for Java
 * Copyright (C) 2008 - 2011 Antti Leppä / Foyt
 * http://www.foyt.fi
 * 
 * License: 
 * 
 * Licensed under GNU Lesser General Public License Version 3 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html
 */
package com.easytrip.rest.models.plans.entities;

import com.easytrip.rest.models.plans.FoursquareEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base class for all groups
 *
 * @param <T> type of entities group contains
 *
 * @author Antti Leppä
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Group<T extends FoursquareEntity> extends Count {

    private static final long serialVersionUID = -3156890964170514232L;

    /**
     * Returns type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns group items
     *
     * @return group items
     */
    public abstract T[] getItems();

    private String type;
    private String name;
}
