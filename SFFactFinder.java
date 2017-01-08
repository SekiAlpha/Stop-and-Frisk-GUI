//Import to show errors with files
import java.io.IOException;
// WRITE OTHER CODE. RACES
public class SFFactFinder
{   
    /**
     * Reads in a Stop and Frisk data set from a file and prints out
     * facts exracted from the data set.
     */
    public static void printFacts() throws IOException
    {
        SFDataPt[] dataSet = SFFileParser.parseFile("2013_cleaned.csv");
        
        // First, filter by borough
        SFDataPt[] boroughDataSet = 
            SFFactFinder.filterByBorough(dataSet, "MANHATTAN");
        
        // Next, filter the borough data by race
        SFDataPt[] asianPacIslData =
            SFFactFinder.filterByRaceEnc(boroughDataSet, "A");
        SFDataPt[] hispData =
            SFFactFinder.filterByRaceEnc(boroughDataSet, "PQ");
        SFDataPt[] blackData =
            SFFactFinder.filterByRaceEnc(boroughDataSet, "B");
        SFDataPt[] amIndAkNatData =
            SFFactFinder.filterByRaceEnc(boroughDataSet, "I");
        SFDataPt[] whiteData =
            SFFactFinder.filterByRaceEnc(boroughDataSet, "W");
        
        System.out.println("\n\n\n\b---------- Start of Tests \b-----------");
        // Find out how many stops (by race)
        System.out.println("Number of Stops (by Race)");
        System.out.println("Asian/Pacific Islander: " + asianPacIslData.length);
        System.out.println("Hispanic: " + hispData.length);
        System.out.println("Black: " + blackData.length);
        System.out.println("American Indian/Alaskan Native: " + amIndAkNatData.length);
        System.out.println("White: " + whiteData.length + "\n");
        
        // Find out average period of stop (by race)
        System.out.println("Average Period of Stop (by Race)");
        System.out.println("Asian/Pacific Islander: " + 
                            SFFactFinder.getAvgPerStop(asianPacIslData));
        System.out.println("Hispanic: " + SFFactFinder.getAvgPerStop(hispData));
        System.out.println("Black: " + SFFactFinder.getAvgPerStop(blackData));
        System.out.println("American Indian/Alaskan Native: " + SFFactFinder.getAvgPerStop(amIndAkNatData));
        System.out.println("White: " + SFFactFinder.getAvgPerStop(whiteData) + "\n");
        
        // Find out percentage of time a stop resulted in a charge s(by race)
        System.out.println("Percentage of Time a Stop Resulted in a Charge(by Race)");
        System.out.println("Asian/Pacific Islander: " + SFFactFinder.getPctCharged(asianPacIslData));
        System.out.println("Hispanic: " + SFFactFinder.getPctCharged(hispData));
        System.out.println("Black: " + SFFactFinder.getPctCharged(blackData));
        System.out.println("American Indian/Alaskan Native: " + SFFactFinder.getPctCharged(amIndAkNatData));
        System.out.println("White: " + SFFactFinder.getPctCharged(whiteData) + "\n");
        // Find out percentage of time physical force was used (by race)
        System.out.println("percentage of time physical force was used(by Race)");
        System.out.println("Asian/Pacific Islander: " + 
                            SFFactFinder.getPctPhysForce(asianPacIslData));
        System.out.println("Hispanic: " + SFFactFinder.getPctPhysForce(hispData));
        System.out.println("Black: " + SFFactFinder.getPctPhysForce(blackData));
        System.out.println("American Indian/Alaskan Native: " + SFFactFinder.getPctPhysForce(amIndAkNatData));
        System.out.println("White: " + SFFactFinder.getPctPhysForce(whiteData) + "\n");
        
        System.out.println(SFFactFinder.males(dataSet) + "\n");
        System.out.println("\b---------- End of Tests \b-----------");
    }
    
    /**
     * Given an array of SFDataPts and a borough, returns an array of only the
     * SFDataPts that occurred in that boroguh.
     * 
     * @param dataSet an array of SFDataPts
     * @param borough the filtering borough
     *   Precondition: borough should be "BRONX", "BROOKLYN", "MANHATTAN",
     *   "QUEENS", or "STATEN ISLAND"
     */
    public static SFDataPt[] filterByBorough(SFDataPt[] dataSet, String borough)
    {
        // Replace this code
        int count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].isBorough(borough)){
                count++;
            }
        }
        SFDataPt[] output = new SFDataPt[count];
        count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if(dataSet[i].isBorough(borough)){
                output[count] = dataSet[i];
                count++;
            }
        }
        return output;
    }
    //here
    /**
     * Given an array of SFDataPts and a String containing one or more race
     * encodings, returns an array of only the SFDataPts whose race property
     * matches ONE of the race encodings.
     * 
     * @param dataSet an array of SFDataPts
     * @param raceEnc the filtering race encodings
     *   Precondition: raceEnc contains ONLY one or more of the capital letters
     *   each of the following capital letters: A, B, I, P, Q, W, X, Z
     */
    public static SFDataPt[] filterByRaceEnc(SFDataPt[] dataSet, String raceEncodings)
    {
        int count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].isRace(raceEncodings)){
                count++;
            }
        }
        SFDataPt[] output = new SFDataPt[count];
        count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if(dataSet[i].isRace(raceEncodings)){
                output[count] = dataSet[i];
                count++;
            }
        }
        return output;
    }
    
    /**
     * Given an array of SFDataPts, return the average period of a stop.
     * 
     * @param dataSet an array of SFDataPts
     */
    public static double getAvgPerStop(SFDataPt[] dataSet)
    {
        int sum = 0;
        for(int i = 0; i < dataSet.length; i++)
        {
            sum += dataSet[i].getPerStop();
        }
        if(sum > 0)
        {
            return (double)sum / dataSet.length;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Given an array of SFDataPts, return the percentage of the time that
     * the police charged the suspect with a crime. When police charge 
     * suspects with a crime, they issue a SUMMMONS or ARREST the suspect.
     * 
     * @param dataSet an array of SFDataPts
     */
    public static double getPctCharged(SFDataPt[] dataSet)
    {
        // Replace this code
        int count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].isCharged()){
                count++;
            }
        }
        if( count > 0) {
            return(double)count / dataSet.length * 100;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Given an array of SFDataPts, return the percentage of the time that
     * physical force was used.
     */
    public static double getPctPhysForce(SFDataPt[] dataSet)
    {
        int count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].isForceUsed()){
                count++;
            }
        }
        if( count > 0) {
            return(double)count / dataSet.length * 100;
        }
        else
        {
            return 0;
        }
    }
    /**
     * Given an array of SFDataPts, return the 
     */
     public static SFDataPt[] filterByPct(SFDataPt[] dataSet, int pct){
        int count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].isPct(pct)){
                count++;
            }
        }
        SFDataPt[] output = new SFDataPt[count];
        count = 0;
        for (int i = 0; i < dataSet.length; i++){
            if(dataSet[i].isPct(pct)){
                output[count] = dataSet[i];
                count++;
            }
        }
        return output;
    }
    
    public static int males(SFDataPt[] dataSet)
    {
        int count = 0;
        for(int i = 0; i < dataSet.length; i++){
            if(dataSet[i].isPct(14) && dataSet[i].isGender("M") && dataSet[i].getAge() > 21 && 
            dataSet[i].isDate(12312013))
            {
                count++;
            }
        }
        return count;
    }
}