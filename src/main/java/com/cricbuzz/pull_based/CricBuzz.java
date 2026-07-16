package com.cricbuzz.pull_based;

public class CricBuzz {
    private int runs;
    private int wickets;
    private int overs;
    private IccApiServices iccApiServices;

    public CricBuzz() {
        iccApiServices = new IccApiServices(0, 0, 0);
    }

    public void updateScore(int runs, int wickets, int overs) {
        while(true){
            iccApiServices.updateScore(runs,wickets,overs);
            if(this.overs!=iccApiServices.getOvers()){
                this.runs=iccApiServices.getRuns();
                this.wickets=iccApiServices.getWickets();
                this.overs=iccApiServices.getOvers();
                System.out.println("Runs: "+this.runs+" wickets: "+this.wickets+" overs: "+this.overs);
            }
        }
    }
}
