package ca.ubc.cs.cpsc210.mindthegap.TfL;

/*
 * Copyright 2015-2016 Department of Computer Science UBC
 */

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    //private static final String ARRIVALS_API_BASE = "https://api.tfl.gov.uk";              // for TfL data
    private static final String ARRIVALS_API_BASE = "http://kunghit.ugrad.cs.ubc.ca:6060";   // for simulated data (3pm to midnight)

    private Station stn;
    String lineId;
    String Arrivals_URL;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    protected URL getURL() throws MalformedURLException {

        for(Line line : stn.getLines()){
            lineId = line.getId();
        }

        Arrivals_URL = ARRIVALS_API_BASE + "/Line/" + lineId + "/Arrivals?stopPointId=" + stn.getID();

        return new URL(Arrivals_URL);
    }
}
