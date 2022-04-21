class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       HashMap<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;
        
        for(int[] flight : flights)
        {
            graph.computeIfAbsent(flight[0], o1 -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        queue.add(new int[]{src, 0, 0});
        
        while(!queue.isEmpty())
        {
            int[] flightDetails = queue.poll();
            int flightId = flightDetails[0];
            int flightCost = flightDetails[1];
            int flightStops = flightDetails[2];
            
            if(flightId == dst)
            {
                return flightCost;
            }
            
            if(flightStops <= k)
            {
                for(int[] nextFlight : graph.getOrDefault(flightId, new ArrayList<>()))
                {
                    int nextFlightId = nextFlight[0];
                    int nextFlightCost = nextFlight[1];
                    int totalCost = flightCost + nextFlightCost;
                    int nextStops = flightStops+1;
                    if(distance[nextFlightId] > totalCost)
                    {
                        if(nextStops <=k)
                        {
                            distance[nextFlightId] = totalCost;
                        }
                        stops[nextFlightId] = nextStops;
                        queue.add(new int[]{nextFlightId, totalCost, nextStops});
                    }
                    else if(stops[nextFlightId] > nextStops)
                    {
                        stops[nextFlightId] = nextStops;
                        queue.add(new int[]{nextFlightId, totalCost, nextStops});
                    }
                }
            }
        }
        
        return -1;
    }
}