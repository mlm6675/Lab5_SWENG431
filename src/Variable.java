import java.util.ArrayList;

public class Variable {
    ArrayList<EquivalenceClass> regions;
    public Variable(String domain){
        regions = new ArrayList<>();
        String[] eqClasses = domain.split(";");
        for(int i = 0; i!= eqClasses.length; i++)
            regions.add(new EquivalenceClass(eqClasses[i], i+1));
    }
    public int check(int value){
        for (EquivalenceClass eq: regions) {
            if(eq.contains(value))
                return eq.getClassNumber();
        }
        return -1; //Value is outside of the domain
    }
    public int getNumberOfEqClasses(){
        return  regions.size();
    }
    public int getInputFromEqClassNumber(int eqNumber){
        EquivalenceClass eq = regions.get(eqNumber-1);
        return eq.getValueInRange();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("This variable contains "  + regions.size() + " equivalence classes\n");
        for (EquivalenceClass eq: regions) {
            result.append(eq.toString()+'\n');
        }
        return result.toString();
    }
}
