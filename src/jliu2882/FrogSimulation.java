package jliu2882;

public class FrogSimulation {
    private int goalDistance;
    private int maxHops;
    public int[] testHops;
    public int nextHopIndex;

    public FrogSimulation(int dist, int numHops){
        this.goalDistance = dist;
        this.maxHops = numHops;
    }

    private int hopDistance()
    {
        int hop = testHops[nextHopIndex];
        nextHopIndex++;
        if (nextHopIndex >= testHops.length)
            nextHopIndex = 0;

        return hop;
    }

    public boolean simulate(){
        int distance =  0;
        for(int i = 1; i <= maxHops;i++){
            if(distance>=0 && distance<goalDistance) {
                distance = distance + hopDistance();
            }
            else if(distance>=goalDistance){
                return true;
            }
            else{
                return false;
            }
        }
        if(distance>=goalDistance){
            return true;
        }
        return false;
    }

    public double runSimulations(int num){
        int success = 0;
        for(int i = 0; i < num; i++){
            if(simulate()){
                success++;
            }
        }
        return(double)success/num;
    }
}
