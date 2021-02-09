package ir.ac.kntu;

public class Time {


    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;

    public Time(int year, int month, int day,int hour, int minute) {
        checkAndSetDate(year, month, day,hour,minute);
    }

    public Time(Time date) {
        this.year = date.year;
        this.month = date.month;

        this.day = date.day;
        this.hour = date.hour;
        this.minute = date.minute;

    }


    private void checkAndSetDate(int year, int month, int day,int hour, int minute) {
        if (checkInputs(year, month, day,hour,minute)) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour=hour;
            this.minute=minute;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
            this.minute=0;
            this.hour=0;
        }
    }
    public boolean bigger(Time first ){
        if (first.year> year) {
            return true;
        }
        else if (first.year==year) {
            if (first.month >month) {
                return true;
            }
            else if (first.month ==month){

                if (first.day>day) {
                    return true;
                }
                else if (first.day==day){

                    if (first.hour>hour) {
                        return true;
                    }
                    else if (first.hour== hour) {

                        if (first.minute>minute) {

                            return true;
                        }
                        else {
                           return false;
                        }
                    }else {
                        return false;

                    }
                }else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }
    private boolean checkInputs(int year, int month, int day,int hour, int minute) {
        if (hour < 0 || hour > 23) {
            return false;
        }
        if (minute < 0 || minute> 59) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month > 6 && day == 31) {
            return false;
        }
        if (month == 12 && day == 30 && !isLeapYear(year)) {
            return false;
        }
        return true;
    }

    public void setDate(int year, int month, int day,int hour, int minute) {
        checkAndSetDate(year, month, day,hour,minute);
    }


    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day,this.hour , this.minute);
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day,this.hour,this.minute);
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day,this.hour,this.minute);
    }

    public int getDay() {
        return day;
    }

    public void setHour(int hour) {
        checkAndSetDate(this.year, this.month, this.day,hour , this.minute);
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        checkAndSetDate(this.year, this.month, this.day,this.hour , minute);
    }

    public int getMinute() {
        return minute;
    }
    public String toString() {
        return year + "-" + month + "-" + day + "  " + hour + ":"+ minute;
    }

    private void handleEsfand(Time curDate, Time nextDate) {
        int boundaryDay = 29;
        if (isLeapYear(curDate.year)) {
            boundaryDay = 30;
        }
        if (curDate.day == boundaryDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    private boolean isLeapYear(int year) {
        double a = 0.025;
        double b = 266;
        double leapDays0 = 0, leapDays1 = 0;
        int frac0 = 0, frac1 = 0;
        if (year > 0) {
            leapDays0 = ((year + 38) % 2820) * 0.24219 + a;  //0.24219 ~ extra days of one year
            leapDays1 = ((year + 39) % 2820) * 0.24219 + a;  //38 days is the difference of epoch to
            //2820-year cycle
        } else if (year < 0) {
            leapDays0 = ((year + 39) % 2820) * 0.24219 + a;
            leapDays1 = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }

        frac0 = (int) ((leapDays0 - (int) (leapDays0)) * 1000);
        frac1 = (int) ((leapDays1 - (int) (leapDays1)) * 1000);

        if (frac0 <= b && frac1 > b) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Time date) {
        if (this == date) {
            return true;
        }
        if (this.year == date.year &&
                this.month == date.month &&
                this.day == date.day && this.hour==date.hour && this.minute == date.minute) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        result = prime * result + hour;
        result = prime * result + minute;

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;

        if (minute != other.minute)
            return false;
        if (hour != other.hour)
            return false;
        return true;
    }

}
