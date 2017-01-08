public class SFDataPt
{
    private int x;
    private int y;
    // Delete me and add more instance variables here
    private String borough;
    private String race;
    private int perStop;
    private String arrestMade;
    private String summIssue;
    private boolean forceUsed;
    private String precinct;
    private int datestop;
    private int timestop;
    private int age;
    private String gender;
    /**
     * Constructor for a SFDataPt.
     * 
     * @param row An array of Strings that represents a SINGLE row of the 
     * Stop and Frisk Data Set. Each String in the array is the value of a
     * single column. See the Stop and Frisk Data Specification to
     * determine which index in the String corresponds to which column in
     * the data.
     */
    public SFDataPt(String[] row)
    {
        x = Integer.parseInt(row[107]);
        y = Integer.parseInt(row[108]);
        borough = row[100];
        race = row[81];
        if (!(row[10].indexOf("*") >= 0)){
            perStop = Integer.parseInt(row[10]);
        }
        else{
            perStop = 0;
        }
        arrestMade = row[14];
        summIssue = row[16];
        forceUsed = false;
        for (int i = 32; i <= 40; i++)
        {
                if(row[i].equals("Y")) 
                {   
                    forceUsed = true;
                }
            }
            // Continue storing instance varaibles
           // Be sure to convert to appropriate type
        
        precinct = row[1];
        datestop= Integer.parseInt(row[3]);
        timestop = Integer.parseInt(row[4]);
        if(row[83].equals( " "))
        {
            age = 0;
        }
        else{
           age = Integer.parseInt(row[83]);
        }
   
        gender = row[80];
    }
    
    /**
     * Accessor for xcoord.
     * 
     * Returns the x-coordinate of the stop and Frisk data point.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Accessor for ycoord.
     * 
     * Returns the y-coordinate of the Stop and Frisk data point.
     */
    public int getY()
    {
        return y;
    }
    
    public String getRace(){
        return race.trim();
    }
    
    public boolean isRace(String str){
        return str.indexOf(getRace()) >= 0;
        
    }
    
    public String getBorough(){
        return borough;
    }
    
    public boolean isBorough(String str){
        return getBorough().equals(str);
    }
    
    public int getPerStop(){
        return perStop;
    }
    
    public boolean isCharged(){
        return arrestMade.equals("Y") || summIssue.equals("Y");
    }
    
    public boolean isForceUsed(){
        return forceUsed;
    }
    public int getPct(){
        return Integer.parseInt(precinct);
    }
    public boolean isPct(int p){
        return getPct() == p;
    }
    public int getDate(){
        return datestop;
    }
    public boolean isDate(int date){
        return getDate() == date;
    }
    public int getTime(){
        return timestop;
    }
    public boolean isTime(int time){
        return getTime() == time;
    }
    public int getAge(){
        return age;
    }
    public boolean isAge(int a){
        return getAge() == a;
    }
    public String getGender(){
        return gender;
    }
    public boolean isGender(String a){
        return gender.equals(a);
    }
    /**
     * Returns a String representation of Stop and Frisk data point. 
     */
    public String toString()
    {
        return "x-coordiante: " + x + "\n" +
               "y-coordinate: " + y + "\n" +
               "borough: " + borough + "\n"+
               "race: " + race + "\n";
    }
    
    /**
     * Quick test of SFDataPt
     */
    public static void main(String[] args)
    {
        System.out.println("\n\n\n\b---------- Start of Tests \b-----------");
        String[] exInputData = new String[109];
        exInputData[107] = "35";
        exInputData[108] = "57";
        exInputData[100] = "MANHATTAN";
        exInputData[81] = "PQ";
        for (int i = 32; i <= 40; i++)
        {
           exInputData[i] = "Y";
        }
        
        
        SFDataPt testPt = new SFDataPt(exInputData);
        
        System.out.println("y = " + testPt.isForceUsed());
        System.out.println("x = " + testPt.getX());
        System.out.println("borough = " + testPt.getBorough());
        System.out.println(testPt);
        System.out.println( "stop = " + testPt.getPerStop());
        
        System.out.println("\b---------- End of Tests \b-----------");
        //SFFactFinder testFF = new SFFactfinder()
    }
}
