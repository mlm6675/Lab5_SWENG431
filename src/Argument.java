public class Argument {
    public int lowerBound;
    public int upperBound;
    public int argumentNumber;

    public Argument()
    {
        this.lowerBound = 0;
        this.upperBound = 0;
    }
    public Argument(int lowerBound, int upperBound)
    {
         this.lowerBound = lowerBound;
         this.upperBound = upperBound;
    }


    public String toString()
    {
        return "Lower bound: " + lowerBound + " Upper bound:" + upperBound + "     Argument number: " + argumentNumber;
    }
}
