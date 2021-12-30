import java.util.ArrayList;


public class AGAT {
    ArrayList<process_modified> arrived_process = new ArrayList<> (  );
    ArrayList<process_modified> ready_queue = new ArrayList<> (  );
    double v1;
    double v2;

    public AGAT ( ArrayList<process_modified> ready_queue ) {
        this.ready_queue = ready_queue;
    }
    void get_arrived_process(int time )
    {
        for ( process_modified x :ready_queue )
        {
            if(x.getArrival_Time () <=time)
            {
                arrived_process.add ( x );
            }
        }
    }

    private void generate_v1()
    {
        float best = 1 ;
        for ( process_modified x :ready_queue )
        {
            best = Math.max(best , x.getArrival_Time ());
        }
        if(best<10){v1 = 1; return;}
        v1 = best/10;
    }

    private void generate_v2()
    {
        float best = 1 ;
        for ( Process x :ready_queue )
        {
            best = Math.max(best , x.getBurst_Time ());
        }
        if(best<10){v2 = 1; return;}
        v2 = best/10;
    }

    private double Factor(process_modified p)
    {
        generate_v2 ();
        return (10 - p.getPriority_Number ()) + Math.ceil ( p.Arrival_Time / v1 ) + Math.ceil ( p.getBurst_Time () / v2 );
    }

    private double round_40 (process_modified p)
    {
        return Math.round ((0.4) * p.getQuantum ())  ;
    }

    private process_modified best()
    {
        double best_factor = Factor ( arrived_process.get ( 0 ) ) ;
        process_modified fi  = arrived_process.get ( 0 );
        for ( process_modified x :arrived_process )
        {
            System.out.println ( "factor :" + Factor ( x ) );
            if(Factor ( x )< best_factor)
            {
                best_factor = Factor ( x );
                fi = x;
            }
        }
        return fi;

    }

    private int get_index_in_ready(process_modified p)
    {
        int ind = 0;
        for (int i = 0 ; i<ready_queue.size () ; i++ )
        {
            if(ready_queue.get ( i ) ==p){return i;}

        }
        return 0;
    }


    void execute()
    {
        int time = 0 ;
        generate_v1 ();
        while ( !ready_queue.isEmpty () )
        {
            get_arrived_process ( time );
            if(arrived_process.isEmpty ()){time++;}
            else {
                process_modified curr = best ();
                double ro = round_40 ( curr );
                while (!ready_queue.isEmpty () &&ro>0  && curr.Burst_Time>0 && best ()==curr  )
                {
                    System.out.println ( time +" " +curr.Name );
                    ready_queue.remove ( get_index_in_ready ( curr ) );
                    ro--;
                    time++;
                    curr.Burst_Time--;
                    if(curr.Burst_Time>0) {
                        ready_queue.add ( curr );
                    }
                    arrived_process.clear ();
                    get_arrived_process ( time );
                }
                if(!ready_queue.isEmpty () && ro==0 && best ()!=curr && curr.Burst_Time>0) {
                    ready_queue.remove ( get_index_in_ready ( curr ) );
                    curr.quantum += 2;
                    ready_queue.add ( curr );
                }
                else if (!ready_queue.isEmpty () && ro>0 && curr.Burst_Time>0)
                {
                    ready_queue.remove ( get_index_in_ready ( curr ) );
                    curr.quantum += ro;
                    ready_queue.add ( curr );
                }
                arrived_process.clear ();
            }
        }
    }
}
