import java.util.ArrayList;

public class Priority_Scheduling
{
    ArrayList<Process> arrived_process = new ArrayList<> (  );
    ArrayList<Process> ready_queue = new ArrayList<> (  );
    ArrayList<Process> max_priority_process = new ArrayList<> (  );

    public Priority_Scheduling ( ArrayList<Process> Ready_queue ) {
        this.ready_queue = Ready_queue;
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

    void get_max_priority( )
    {
        int max_priority = arrived_process.get ( 0 ).getPriority_Number ();
        for ( Process x : arrived_process )
        {
            if(x.getPriority_Number () < max_priority)
            {
                max_priority = x.Priority_Number;
            }
        }

        for ( Process x : arrived_process )
        {
            if(x.getPriority_Number () == max_priority)
            {
                max_priority_process.add ( x );
            }
        }
    }



    Process get_min_brust_time()
    {
        Process cur_process = new Process() ;
        int min_burst_time = max_priority_process.get(0).getBurst_Time ();

        cur_process = max_priority_process.get(0);

        for ( Process x : max_priority_process )
        {
            if(x.getBurst_Time () < min_burst_time)
            {
                min_burst_time = x.getBurst_Time ();
                cur_process = x;
            }
        }
        int min_arrived_time = cur_process.getArrival_Time ();

        for ( Process x : max_priority_process )
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
                get_max_priority ( );
                Process current_process = get_min_brust_time ( );
                System.out.println ( "name: " + current_process.Name + " color" + current_process.Color );
                System.out.println ( "Priority_Number: " + current_process.Priority_Number + " arrival time: " + current_process.Arrival_Time );
                System.out.println ( "Burst Time: " + current_process.Burst_Time );
                int indx = 0 ;
                for ( int i = 0 ; i<ready_queue.size () ; ++i )
                {
                    if(current_process==ready_queue.get ( i )){indx = i; break;}
                }
                ready_queue.remove ( indx );
                arrived_process.clear ();
                max_priority_process.clear ();
                //time++;
            }
        }
    }









}
