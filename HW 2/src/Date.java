/* Date.java */

class Date {

    private int month;
    private int day;
    private int year;

    /**
     * Constructs a date with the given month, day and year. If the date is not
     * valid, the entire program will halt with an error message.
     * 
     * @param month is a month, numbered in the range 1...12.
     * @param day   is between 1 and the number of days in the given month.
     * @param year  is the year in question, with no digits omitted.
     */
    public Date(int month, int day, int year) {
	this.month = month;
	this.day = day;
	this.year = year;

	if (!isValidDate(this.month, this.day, this.year)) {
	    System.out.println("The date " + this.toString() + " is not a valid date.");
	    System.exit(0);
	}
    }

    /**
     * Constructs a Date object corresponding to the given string.
     * 
     * @param s should be a string of the form "month/day/year" where month must be
     *          one or two digits, day must be one or two digits, and year must be
     *          between 1 and 4 digits. If s does not match these requirements or is
     *          not a valid date, the program halts with an error message.
     */
    public Date(String s) {

	// Try to parse string s into a date. Otherwise, it is invalid.
	try {
	    String[] dateStrings = s.split("/");
	    month = Integer.parseInt(dateStrings[0]);
	    day = Integer.parseInt(dateStrings[1]);
	    year = Integer.parseInt(dateStrings[2]);

	} catch (Exception e) {
	    System.out.println("The date \"" + s + "\" is not a valid date.");
	    System.exit(0);
	}

	if (!isValidDate(month, day, year)) {
	    System.out.println("The date \"" + s + "\" is not a valid date.");
	    System.exit(0);
	}
    }

    /**
     * Checks whether the given year is a leap year.
     * 
     * @return true if and only if the input year is a leap year.
     */
    public static boolean isLeapYear(int year) {

	boolean result = false;
	if (year % 400 == 0) {
	    result = true;
	} else if (year % 4 == 0 && year % 100 != 0) {
	    result = true;
	}
	return result;
    }

    /**
     * Returns the number of days in a given month.
     * 
     * @param month is a month, numbered in the range 1...12.
     * @param year  is the year in question, with no digits omitted.
     * @return the number of days in the given month.
     */
    public static int daysInMonth(int month, int year) {
	int days = 0;

	switch (month) {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	    days = 31;
	    break;
	case 4:
	case 6:
	case 9:
	case 11:
	    days = 30;
	    break;
	case 2:
	    boolean isLeap = isLeapYear(year);
	    if (isLeap) {
		days = 29;
	    } else {
		days = 28;
	    }
	    break;
	default:
	    // Return -1 if an invalid month is given.
	    days = -1;
	}

	return days;
    }

    /**
     * Checks whether the given date is valid.
     * 
     * @return true if and only if month/day/year constitute a valid date.
     *
     *         Years prior to A.D. 1 are NOT valid.
     */
    public static boolean isValidDate(int month, int day, int year) {

	if (year < 1) {
	    return false;
	}

	if (day <= daysInMonth(month, year)) {
	    return true;
	}

	return false;
    }

    /**
     * Returns a string representation of this date in the form month/day/year. The
     * month, day, and year are expressed in full as integers; for example,
     * 12/7/2006 or 3/21/407.
     * 
     * @return a String representation of this date.
     */
    public String toString() {
	return "" + month + "/" + day + "/" + year;
    }

    /**
     * Determines whether this Date is before the Date d.
     * 
     * @return true if and only if this Date is before d.
     */
    public boolean isBefore(Date d) {

	if (year < d.year) {
	    return true;
	} else if (month < d.month && year == d.year) {
	    return true;
	} else if (day < d.day && month == d.month) {
	    return true;
	}
	return false;
    }

    /**
     * Determines whether this Date is after the Date d.
     * 
     * @return true if and only if this Date is after d.
     */
    public boolean isAfter(Date d) {

	return (!(isBefore(d) || isSameDate(d)));
    }

    /**
     * Returns the number of this Date in the year.
     * 
     * @return a number n in the range 1...366, inclusive, such that this Date is
     *         the nth day of its year. (366 is used only for December 31 in a leap
     *         year.)
     */
    public int dayInYear() {

	int dayNum = 0;

	for (int m = 1; m < month; m++) {
	    dayNum += daysInMonth(m, year);
	}

	dayNum += day;

	return dayNum;
    }

    /**
     * Determines the difference in days between d and this Date. For example, if
     * this Date is 12/15/2012 and d is 12/14/2012, the difference is 1. If this
     * Date occurs before d, the result is negative.
     * 
     * @return the difference in days between d and this date.
     */
    public int difference(Date d) {

	if (year == d.year) {
	    return dayInYear() - d.dayInYear();
	}

	Date earlier;
	Date later;
	int multiplier = 1;

	if (isBefore(d)) {
	    earlier = this;
	    later = d;
	    multiplier = -1;
	} else {
	    earlier = d;
	    later = this;
	}

	int diff = 0;
	diff += later.dayInYear();
	for (int y = later.year - 1; y > earlier.year; y--) {
	    Date x = new Date(12, 31, y);
	    diff += x.dayInYear();
	}

	Date x = new Date(12, 31, earlier.year);
	diff += (x.dayInYear() - earlier.dayInYear());
	return diff * multiplier;

    }

    /**
     * Determines whether this Date is the same as the Date d.
     * 
     * @return true if and only if this Date is the same as d.
     */
    private boolean isSameDate(Date d) {
	return (month == d.month && day == d.day && year == d.year);
    }

    public static void main(String[] argv) {
	System.out.println("\nTesting constructors and toString.");
	Date d1 = new Date(1, 1, 1);
	System.out.println("Date should be 1/1/1: " + d1);
	d1 = new Date("2/4/2");
	System.out.println("Date should be 2/4/2: " + d1);
	d1 = new Date("2/29/2000");
	System.out.println("Date should be 2/29/2000: " + d1);
	d1 = new Date("2/29/1904");
	System.out.println("Date should be 2/29/1904: " + d1);

	d1 = new Date(12, 31, 1975);
	System.out.println("Date should be 12/31/1975: " + d1);
	Date d2 = new Date("1/1/1976");
	System.out.println("Date should be 1/1/1976: " + d2);
	Date d3 = new Date("1/2/1976");
	System.out.println("Date should be 1/2/1976: " + d3);

	Date d4 = new Date("2/27/1977");
	Date d5 = new Date("8/31/2110");

	Date d6 = new Date(7, 7, 1800);
	// Date d7 = new Date(2, 29, 1900); // Should be invalid.
	Date d8 = new Date(2, 29, 1600);
	Date d9 = new Date(11, 29, 2000);
	// Date d10 = new Date(4, 40, 1900); // Should be invalid.
	Date d11 = new Date(4, 10, 1900);

	// These dates should all be invalid and cause the program to halt.
	// Date d12 = new Date("11/31/2009");
	// Date d13 = new Date("12/4");
	// Date d14 = new Date("hey dude");
	// Date d15 = new Date(" 011/4/2010 AD");

	/* I recommend you write code to test the isLeapYear function! */

	System.out.println("\nTesting isLeapYear.");
	System.out.println(d1 + " should be false: " + Date.isLeapYear(d1.year));
	System.out.println(d2 + " should be true: " + Date.isLeapYear(d2.year));
	System.out.println(d5 + " should be false: " + Date.isLeapYear(d5.year));
	System.out.println(d6 + " should be false: " + Date.isLeapYear(d6.year));
	System.out.println(d8 + " should be true: " + Date.isLeapYear(d8.year));
	System.out.println(d9 + " should be true: " + Date.isLeapYear(d9.year));
	System.out.println(d11 + " should be false: " + Date.isLeapYear(d11.year));

	System.out.println("\nTesting before and after.");
	System.out.println(d2 + " after " + d1 + " should be true: " + d2.isAfter(d1));
	System.out.println(d3 + " after " + d2 + " should be true: " + d3.isAfter(d2));
	System.out.println(d1 + " after " + d1 + " should be false: " + d1.isAfter(d1));
	System.out.println(d1 + " after " + d2 + " should be false: " + d1.isAfter(d2));
	System.out.println(d2 + " after " + d3 + " should be false: " + d2.isAfter(d3));

	System.out.println(d1 + " before " + d2 + " should be true: " + d1.isBefore(d2));
	System.out.println(d2 + " before " + d3 + " should be true: " + d2.isBefore(d3));
	System.out.println(d1 + " before " + d1 + " should be false: " + d1.isBefore(d1));
	System.out.println(d2 + " before " + d1 + " should be false: " + d2.isBefore(d1));
	System.out.println(d3 + " before " + d2 + " should be false: " + d3.isBefore(d2));

	System.out.println("\nTesting difference.");
	System.out.println(d1 + " - " + d1 + " should be 0: " + d1.difference(d1));
	System.out.println(d2 + " - " + d1 + " should be 1: " + d2.difference(d1));
	System.out.println(d3 + " - " + d1 + " should be 2: " + d3.difference(d1));
	System.out.println(d3 + " - " + d4 + " should be -422: " + d3.difference(d4));
	System.out.println(d5 + " - " + d4 + " should be 48762: " + d5.difference(d4));
    }
}
