public class Process {
    String Name ;
    String Color;
    int Arrival_Time;
    int Burst_Time;
    int  Priority_Number;

    public Process () {
    }

    public Process ( String name, String color, int arrival_Time, int burst_Time, int priority_Number )
    {
        Name = name;
        Color = color;
        Arrival_Time = arrival_Time;
        Burst_Time = burst_Time;
        Priority_Number = priority_Number;
    }

    public String getName () {
        return Name;
    }

    public void setName ( String name ) {
        Name = name;
    }

    public String getColor () {
        return Color;
    }

    public void setColor ( String color ) {
        Color = color;
    }

    public int getArrival_Time () {
        return Arrival_Time;
    }

    public void setArrival_Time ( int arrival_Time ) {
        Arrival_Time = arrival_Time;
    }

    public int getBurst_Time () {
        return Burst_Time;
    }

    public void setBurst_Time ( int burst_Time ) {
        Burst_Time = burst_Time;
    }

    public int getPriority_Number () {
        return Priority_Number;
    }

    public void setPriority_Number ( int priority_Number ) {
        Priority_Number = priority_Number;
    }


}
