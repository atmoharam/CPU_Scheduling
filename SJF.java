import java.util.ArrayList;

public class SJF {
    ArrayList<Process> arrived_process = new ArrayList<> (  );
    ArrayList<Process> ready_queue = new ArrayList<> (  );

    public SJF ( ArrayList<Process> ready_queue ) {
        this.ready_queue = ready_queue;
    }

    void get_arrived_process(int time )
    {
        for ( Process x :ready_queue )
        {
            if(x.getArrival_Time () <=time)
            {
                arrived_process.add ( x );
            }
        }
    }

    Process get_min_brust_time()
    {
        Process cur_process = new Process() ;
        int min_burst_time = arrived_process.get(0).getBurst_Time ();

        cur_process = arrived_process.get(0);

        for ( Process x : arrived_process )
        {
            if(x.getBurst_Time () < min_burst_time)
            {
                min_burst_time = x.getBurst_Time ();
                cur_process = x;
            }
        }
        int min_arrived_time = cur_process.getArrival_Time ();

        for ( Process x : arrived_process )
        {
            if(x.getArrival_Time () < min_arrived_time && x.getBurst_Time ()== cur_process.getBurst_Time ())
            {
                min_arrived_time = x.getArrival_Time ();
                cur_process = x;
            }
        }
        return cur_process;
    }

    void execute ()
    {
        int time = 0 ;
        while ( !ready_queue.isEmpty () )
        {
            get_arrived_process ( time );
            if(arrived_process.isEmpty ()){time++;}
            else {
                Process current_process = get_min_brust_time ( );
                System.out.println ( "name: " + current_process.Name + " color" + current_process.Color );
                System.out.println (  " arrival time: " + current_process.Arrival_Time );
                System.out.println ( "Burst Time: " + current_process.Burst_Time );
                int indx = 0 ;
                for ( int i = 0 ; i<ready_queue.size () ; ++i )
                {
                    if(current_process==ready_queue.get ( i )){indx = i; break;}
                }
                time+=current_process.getBurst_Time ();
                ready_queue.remove ( indx );
                arrived_process.clear ();
            }
        }
    }


}
