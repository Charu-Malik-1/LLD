package bms.demo.lld.services;

import bms.demo.lld.models.Auditorium;
import bms.demo.lld.models.Show;
import bms.demo.lld.models.Theater;

import java.util.Map;

public class ShowAuditoriumManager {

    // 1. adding show to auditorium
    // 2. initialise show seat for every show
    public void mapAuditoriumToShow(Auditorium auditorum, Show show){
        auditorum.addShow(show);
        show.addShowSeat(auditorum.getSeatMetrix());
    }
}
