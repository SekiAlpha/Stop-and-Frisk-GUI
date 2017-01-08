    //Import to show errors with files
import java.io.IOException;
//Import to draw Colors
import java.awt.Color;

public class SFVisualizer
{
    /**
     * Reads in a Stop and Frisk data set from a file and visualizes
     * the data set.
     */
    public static void visualizeData() throws IOException
    {
        // Get all the data from the file
        SFDataPt[] dataSet = SFFileParser.parseFile("2013_cleaned.csv");
        
        // Get ONLY the data for the appropriate borough
        SFDataPt[] boroughDataSet = 
            SFVisualizer.filterByBorough(dataSet, "MANHATTAN");

        int minX = SFVisualizer.getMinXCoord(boroughDataSet);
        int maxX = SFVisualizer.getMaxXCoord(boroughDataSet);
        int minY = SFVisualizer.getMinYCoord(boroughDataSet);
        int maxY = SFVisualizer.getMaxYCoord(boroughDataSet);
        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);
        
        SFDataPt[] asianPacIslData = SFFactFinder.filterByRaceEnc(boroughDataSet, "A");
        SFDataPt[] hispData = SFFactFinder.filterByRaceEnc(boroughDataSet, "PQ");
        SFDataPt[] blackData = SFFactFinder.filterByRaceEnc(boroughDataSet, "B");
        SFDataPt[] amIndAkNatData = SFFactFinder.filterByRaceEnc(boroughDataSet, "I");
        SFDataPt[] whiteData = SFFactFinder.filterByRaceEnc(boroughDataSet, "W");
        SFDataPt[] otherData = SFFactFinder.filterByRaceEnc(boroughDataSet, "UXZ");
        
        SFDataPt[] pct14 = SFFactFinder.filterByPct(boroughDataSet, 14);
        while(true)
        {
           
            //SFVisualizer.drawData(pct14, StdDraw.BLACK, 1000);
            SFVisualizer.drawData(boroughDataSet, StdDraw.BLACK, 2000);
            //SFVisualizer.drawData(asianPacIslData, StdDraw.PINK, 1000);
            //SFVisualizer.drawData(blackData, StdDraw.BLUE, 1000);
            //SFVisualizer.drawData(hispData, StdDraw.RED, 1000);
            //SFVisualizer.drawData(whiteData, StdDraw.GREEN, 1000);
            //SFVisualizer.drawData(otherData, StdDraw.MAGENTA, 1000);
        }
    }
    
    /**
     * Given an array of SFDataPts, a color, and a time (measured in
     * milliseconds), draw the points on the cavnas.
     */
    public static void drawData(SFDataPt[] dataSet, Color c, int timeMil)
    {
        StdDraw.show(0);
        StdDraw.clear();
        StdDraw.setPenColor(c);
        for(int i = 0; i < dataSet.length; i++)
        {
            StdDraw.point(dataSet[i].getX(), dataSet[i].getY());
        }
        StdDraw.show(timeMil);
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
        //SFFactFinder test = new SFFactFinder();
        return SFFactFinder.filterByBorough(dataSet, borough);
    }
    
    public static SFDataPt[] filterByRace(SFDataPt[] dataSet, String race){
        return SFFactFinder.filterByBorough(dataSet, race);
    }
    
    /**
     * Returns the minimum x-coordinate contained in the dataSet.
     * 
     * @param dataSet An array of SFDataPts
     */
    public static int getMinXCoord(SFDataPt[] dataSet)
    {
        // Replace this code
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].getX() > max){
                max = dataSet[i].getX();
            }
        }
        return max;
    }
    
    /**
     * Returns the minimum y-coordinate contained in the dataSet.
     * 
     * @param dataSet An array of SFDataPts
     */
    public static int getMinYCoord(SFDataPt[] dataSet)
    {
        // Replace this code
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].getY() > max){
                max = dataSet[i].getY();
            }
        }
        return max;
    }
    
    /**
     * Returns the maximum x-coordinate contained in the dataSet.
     * 
     * @param dataSet An array of SFDataPts
     */
    public static int getMaxXCoord(SFDataPt[] dataSet)
    {
        // Replace this code
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].getX() < min){
                min = dataSet[i].getX();
            }
        }
        return min;
    }
    
    /**
     * Returns the maximum y-coordinate contained in the dataSet.
     * 
     * @param dataSet An array of SFDataPts
     */
    public static int getMaxYCoord(SFDataPt[] dataSet)
    {
        // Replace this code
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dataSet.length; i++){
            if (dataSet[i].getY() < min){
                min = dataSet[i].getY();
            }
        }
        return min;
    }

    public static void main(String[]args) throws IOException{
 	visualizeData();
    }
}