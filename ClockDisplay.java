
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes and an indicator for AM/PM. The 
 * range of the clock is 12:00AM (midnight) to 11:59PM (one minute before 
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
    public String pm = "PM";
    public String am = "AM";
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            
        }
       
        updateDisplay();
        }
    
    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        
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
     * Updates the internal depending on the hour for am or pm
     */
    private void updateDisplay()
    {
        if(hours.getValue() == 0) {
            displayString = "12:" + minutes.getDisplayValue() + am;
        }
        else if(hours.getValue() <= 13) {
            
        displayString = hours.getValue() + ":" + 
                        minutes.getDisplayValue() + am;
                    }
        else if (hours.getValue() >= 12) {
        displayString = hours.getValue()-12 + ":" + 
                        minutes.getDisplayValue() + pm;}
    }
}
