/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 (midnight) to 11:59 (one minute before 
 * midnight).
 * 
 * The clock maintains the hour time internally as values from 1-12, not 0-23
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Joseph Truelove
 * @version 2018.09.24
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String am = "AM";
    private String pm = "PM";
    private boolean indicators;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean indicator)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        
        setTime(hour, minute, indicator);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            if(hours.getValue() == 0) {
                if(indicators = true) {
                    indicators = false;
                }
                else if(indicators = false) {
                    indicators = true;
                }
            }
            hours.increment();
            
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, boolean indicator)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        indicators =(indicator);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if(hours.getValue() == 0 ) {
            if(indicators = true) {
        displayString = "12:" + 
                        minutes.getDisplayValue() + am;
                    }
        else if(indicators = false) {
        displayString = "12:" + 
                        minutes.getDisplayValue() + pm;
                    }
        }
     
        else if(indicators = true) {
        displayString = hours.getValue() + ":" + 
                        minutes.getDisplayValue() + am;
                    }
        else if(indicators = false) {
        displayString = hours.getValue() + ":" + 
                        minutes.getDisplayValue() + pm;
                    }
                    
        
    }
}
