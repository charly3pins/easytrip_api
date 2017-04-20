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
package com.easytrip.rest.models.plans.entities.notifications;

import com.easytrip.rest.models.plans.FoursquareEntity;
import com.easytrip.rest.models.plans.entities.Badge;

/**
 * Entity representing "Badge" notification
 *
 * @author Antti Leppä
 */
public class BadgeNotification implements FoursquareEntity {

    private static final long serialVersionUID = 2152749838200069020L;

    /**
     * Returns Badge entity
     *
     * @return Badge entity
     */
    public Badge getBadge() {
        return badge;
    }

    private Badge badge;
}
