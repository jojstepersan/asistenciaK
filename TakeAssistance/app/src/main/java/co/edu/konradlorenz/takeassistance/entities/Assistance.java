package co.edu.konradlorenz.takeassistance.entities;

import java.util.Date;

/**
 * Created by Valentina on 03/10/2017.
 */

public class Assistance {

    private Date date;
    private boolean gone;

    public Assistance(Date date, boolean gone) {
        this.date = date;
        this.gone = gone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isGone() {
        return gone;
    }

    public void setGone(boolean gone) {
        this.gone = gone;
    }
}
