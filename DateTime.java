package EventBookingProgramV2;

import java.time.LocalDate;
import java.time.LocalTime;


public class DateTime extends Event {
    private int year;
    private int month;
    private int day;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    int currentYear;
    int currentMonth;
    int currentDay;
    int currentHour;
    int currentMinute;

    LocalDate date;
    LocalTime time;

    //create object with current Date and time
    public DateTime() {
        date = LocalDate.now();
        time = LocalTime.now();

        currentYear = date.getYear();
        currentMonth = date.getMonthValue();
        currentDay = date.getDayOfMonth();
        currentHour = time.getHour();
        currentMinute = time.getMinute();
    }

    protected int getYear() {
        return year;
    }

    protected int getMonth() {
        return month;
    }

    protected int getDay() {
        return day;
    }

    protected int getStartHour() {
        return startHour;
    }

    protected int getStartMinute() {
        return startMinute;
    }

    protected int getEndHour() {
        return endHour;
    }

    protected int getEndMinute() {
        return endMinute;
    }

    protected String getDate() {
        String date = getYear() + "-" + getMonth() + "-" + getDay();
        return date;
    }

    protected String getStartTime() {
        String time = getStartHour() + ":" + getStartMinute();
        return time;
    }

    protected String getEndTime() {
        String time = getEndHour() + ":" + getEndMinute();
        return time;
    }

    // checks if current date equal to created date
    private boolean isCurrentDate() {
        return (currentYear + currentMonth + currentDay) == (getYear() + getMonth() + getDay());
    }

    //year must be equal or higher than the current year, lower than the max returns true if valid
    protected boolean setYear(int newYear) {
        int maxYear = 2100;
        if (newYear >= currentYear && year < maxYear) {
            year = newYear;
            return true;
        } else System.out.println("Not a valid year!");
        return false;
    }

    protected boolean setMonth(int newMonth) {
        // if current year, month must be higher or equal to current month and lower than 13,plus logical limits, returns true if valid
        if (year == currentYear && newMonth >= currentMonth && (newMonth > 0 && newMonth <= 12)) {
            month = newMonth;
            return true;
        }
        //if not current year, month must be higher than 0 and lower than 13,plus logical limits, returns true if valid
        else if (year > currentYear && (newMonth > 0 && newMonth <= 12)) {
            month = newMonth;
            return true;
        } else {
            System.out.println("Not a valid month!");
            return false;
        }

    }

    protected boolean setDay(int newDay) {
        // if current year and month, newDay has to be higher than currentDay, lower than newDay, returns true if valid
        if (year == currentYear && month == currentMonth && newDay >= currentDay && newDay <= 31) {
            day = newDay;
            return true;
        } else if (year >= currentYear && month > currentMonth && newDay < 31) {
            day = newDay;
            return true;
        } else System.out.println("not a valid day!");
        return false;
    }

    protected boolean setStartHour(int newHour) {
        // if current date, newHour must be greater than or equal to current hour, plus logical limits, returns true if valid
        if (isCurrentDate() && newHour >= currentHour && newHour < 24 && newHour >= 0) {
            startHour = newHour;
            return true;
        }
        // if future date, newHour has logical limits, returns true if valid
        else if (!isCurrentDate() && newHour < 24 && newHour >= 0) {
            startHour = newHour;
            return true;
        } else {
            System.out.println("Not a valid starting hour!");
            return false;
        }
    }

    protected boolean setStartMinute(int newMinute) {
        // if current hour of current date, minute must be higher than current minute, plus logical limits, returns true if valid
        if (isCurrentDate() && getStartHour() == currentHour && newMinute > currentMinute && newMinute < 60 && newMinute >= 0) {
            startMinute = newMinute;
            return true;
        }
        // if not current date plus logical limits, returns true if valid
        if (!isCurrentDate() && newMinute < 60 && newMinute >= 0) {
            startMinute = newMinute;
            return true;
        } else {
            System.out.println("Not a valid starting minute!");
            return false;
        }
    }

    protected boolean setEndHour(int newHour) {
        // if current date, end hour has to be greater than or equal to starting hour,plus logical limits, returns true if valid
        if (isCurrentDate() && newHour >= getStartHour() && newHour >= 0 && newHour < 24) {
            endHour = newHour;
            return true;
        }
        // if not current date,  end hour has logical limits, returns true if valid
        else if (!isCurrentDate() && newHour >= 0 && newHour < 24) {
            endHour = newHour;
            return true;
        } else {
            System.out.println("Not a valid ending hour!");
            return false;
        }
    }

    protected boolean setEndMinute(int newMinute) {
        // if current date and endHour is equal to starting hour, ending minute has to be greater than starting minute, plus logical limits, returns true if valid
        if (isCurrentDate() && getEndHour() >= getStartHour() && newMinute > getStartMinute() && newMinute <= 60 && newMinute >= 0) {
            endMinute = newMinute;
            return true;
        }
        // if not current date, ending hour must  be greater than or equal to starting hour, plus logical limits, returns true if valid
        else if (!isCurrentDate() && endHour == startHour && newMinute >= startMinute && newMinute <= 60 && newMinute >= 0) {
            endMinute = newMinute;
            return true;
        }
        // if not current date and not current hour, plus logical limits, returns true if valid
        else if (!isCurrentDate() && endHour > startHour && newMinute <= 60 && newMinute >= 0) {
            endMinute = newMinute;
            return true;
        } else {
            System.out.println("Not a valid ending minute!");
            return false;
        }
    }
}
