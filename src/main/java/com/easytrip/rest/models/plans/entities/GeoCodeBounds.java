package com.easytrip.rest.models.plans.entities;

import com.easytrip.rest.models.plans.FoursquareEntity;

/**
 * A bounding box
 *
 * @author rmangi
 *
 */
public class GeoCodeBounds implements FoursquareEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1815047069331054906L;

    GeoCodeGeoPt ne; // northeast
    GeoCodeGeoPt sw; // southwest

    public GeoCodeBounds() {
        super();
    }

    public GeoCodeBounds(GeoCodeGeoPt ne, GeoCodeGeoPt sw) {
        super();
        this.ne = ne;
        this.sw = sw;
    }

    public GeoCodeGeoPt getNe() {
        return ne;
    }

    public void setNe(GeoCodeGeoPt ne) {
        this.ne = ne;
    }

    public GeoCodeGeoPt getSw() {
        return sw;
    }

    public void setSw(GeoCodeGeoPt sw) {
        this.sw = sw;
    }

}
