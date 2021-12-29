import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        int n = sc.nextInt ();
        ArrayList<Process> data = new ArrayList<> (  );
        for ( int i = 0 ; i< n ; i++ )
        {
            String Name = sc.next ();
            String Color= sc.next ();
            int Arrival_Time = sc.nextInt ();
            int Burst_Time = sc.nextInt ();
            int  Priority_Number = sc.nextInt ();
            Process temp = new Process ( Name ,Color,Arrival_Time,Burst_Time,Priority_Number );
            data.add ( temp );
        }
        Priority_Scheduling test1 = new Priority_Scheduling ( data );
        test1.execute ();

    }
}
