public class EquivalenceClass {
    public int lowerBound;
    public int upperBound;
    public int classNumber;

    public EquivalenceClass(String range, int classNumber)
    {
        String[] bounds = range.split(",");
        this.lowerBound = Integer.parseInt(bounds[0].trim());
        this.upperBound = Integer.parseInt(bounds[1].trim());
        this.classNumber = classNumber;
    }
    public int getLowerBound(){
        return lowerBound;
    }
    public int getUpperBound(){
        return upperBound;
    }
    public int getClassNumber(){
        return classNumber;
    }
    public int getValueInRange(){
        return lowerBound + (int)((upperBound-lowerBound)*Math.random());
    }
    public String toString()
    {
        return "Lower bound: " + lowerBound + " Upper bound:" + upperBound + " Eq. Class number: " + classNumber;
    }

    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }
}
