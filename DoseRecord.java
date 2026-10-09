package com.mycompany.oop_midterm;

import java.time.LocalDateTime;

public class DoseRecord {
    private LocalDateTime scheduledDateTime;
    private boolean statusTaken;
    private LocalDateTime actualTimeTaken;

    public DoseRecord(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
        this.statusTaken = false;
        this.actualTimeTaken = null;
    }

    public void markAsTaken(LocalDateTime time) {
        this.statusTaken = true;
        this.actualTimeTaken = time;
    }

    public boolean isMissed() {
        return !statusTaken && LocalDateTime.now().isAfter(scheduledDateTime);
    }

    public LocalDateTime getScheduledDateTime() { return scheduledDateTime; }
}