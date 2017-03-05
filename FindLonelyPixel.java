public class Solution {
    public int findLonelyPixel(char[][] picture) {
        
        int lonelyBlackPixels = 0 ;
        int rLength = 0 ;
        int cLength = 0;
        if(picture !=null)
        {
        rLength = picture[0].length;
        cLength = picture.length;
        System.out.println(rLength);
        System.out.println(cLength);
        }
        int[] lonelyBlackRowCount = new int[rLength];
        int[] lonelyBlackColCount = new int[cLength];
        //col
        for(int i=0 ; i < cLength ; i++)
        {
            //row
          for(int j=0 ; j < rLength; j++)
             {
                if(picture[i][j] == 'B')
                {
                    lonelyBlackRowCount[j]++;
                    lonelyBlackColCount[i]++;
                }
            }
        }
        for(int i=0 ; i < cLength ; i++)
        {
            for(int j =0 ; j < rLength ; j++)
            {
              
                if(picture[i][j] == 'B' && lonelyBlackRowCount[j] ==1 && lonelyBlackColCount[i] ==1 ) 
                    {
                        //current pixel is lonely
                        lonelyBlackPixels++;
                    }
                }
        }
        return lonelyBlackPixels;
    }
}
