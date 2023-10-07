package de.tramotech;

import java.time.LocalDateTime;

public class DateAndTimeKatas {
    /**
     * checks whether the date is on weekdays (Monday-Friday) and within the hours of 9:00 AM and 5:00 PM
     * @param date
     * @return returns true if it represents a weekday and is within the allowed hours for appointments, and false otherwise.
     */
    public boolean isValidAppointmentDate(LocalDateTime date) {
        if(date == null) {
            return false;
        }

        if(date.getDayOfWeek().getValue() > 5) {
            return false;
        }

        int hour = date.getHour();
        return hour >= 9 && hour < 17;
    }
}
