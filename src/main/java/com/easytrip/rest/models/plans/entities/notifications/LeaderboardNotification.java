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
import com.easytrip.rest.models.plans.entities.LeaderboardItem;
import com.easytrip.rest.models.plans.entities.LeaderboardScore;

/**
 * Entity representing "Leaderboard" notification
 *
 * @author Antti Leppä
 */
public class LeaderboardNotification implements FoursquareEntity {

    private static final long serialVersionUID = 8919261709842197077L;

    /**
     * Returns array of LeaderboardItem entities
     *
     * @return array of LeaderboardItem entities
     */
    public LeaderboardItem[] getLeaderboard() {
        return leaderboard;
    }

    /**
     * Returns message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns array of LeaderboardScore entities
     *
     * @return array of LeaderboardScore entities
     */
    public LeaderboardScore[] getScores() {
        return scores;
    }

    /**
     * Returns total
     *
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    private LeaderboardItem[] leaderboard;
    private String message;
    private LeaderboardScore[] scores;
    private Long total;
}
