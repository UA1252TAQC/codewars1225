package org.academy.kata.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SixDataProvider extends AbstractDataProvider {

  @DataProvider(name = "data-findNb")
  public static Iterator<Object[]> dpFindNb() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{1071225L, 45});
    inputs.add(new Object[]{91716553919377L, -1});
    inputs.add(new Object[]{135440716410000L, 4824});

    return combineData(inputs, SIX);
  }

  @DataProvider(name = "data-stockSummary")
  public static Iterator<Object[]> dpStockSummary() {
    List<Object[]> inputs = new ArrayList<>();

    inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                            new String[]{"A", "B", "C", "D"}, "(A : 200) - (B : 1140) - (C : 500) - (D : 600)"});
    inputs.add(new Object[]{new String[]{"XYZ 300", "LMN 400", "OPQ 100", "RST 500"},
                            new String[]{"X", "L", "O"}, "(X : 300) - (L : 400) - (O : 100)"});
    inputs.add(new Object[]{new String[]{"JKL 150", "MNO 250", "PQR 350"}, new String[]{"J", "M"},"(J : 150) - (M : 250)"});
    inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, new String[]{"X", "Y"}, "(X : 0) - (Y : 0)"});
    inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, new String[]{"X", "Y"}, "(X : 0) - (Y : 0)"});
    inputs.add(new Object[]{new String[]{"ABAR 200"}, new String[]{"B"}, "(B : 0)"});
    inputs.add(new Object[]{new String[]{"ABAR 200"}, new String[]{"A"}, "(A : 200)"});
    inputs.add(new Object[]{new String[]{}, new String[]{}, ""});
    inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, new String[]{}, ""});
    inputs.add(new Object[]{new String[]{"ABAR 200", "ABAR 300", "CDXE 500"}, new String[]{"A", "C"}, "(A : 500) - (C : 500)"});
    inputs.add(new Object[]{new String[]{"AAAAAAAAAAAAAA 200"}, new String[]{"A"}, "(A : 200)"});
    inputs.add(new Object[]{null, null, ""});
    inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, null, ""});
    inputs.add(new Object[]{null, new String[]{"A", "B"}, ""});


    return combineData(inputs, SIX);
  }

  @DataProvider(name = "data-f")
  public static Iterator<Object[]> dpF() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{1e-15, 4.99999999999999875e-16});
    inputs.add(new Object[]{1e-10, 4.99999999975000000e-11});
    inputs.add(new Object[]{1e-5, 4.99999997499999875e-6});

    return combineData(inputs, SIX);
  }

   @DataProvider(name = "data-balance")
  public static Iterator<Object[]> dpBalance() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{
            "1000.00\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10",
            "Original Balance: 1000.00\\r\\n125 Market 125.45 Balance 874.55\\r\\n126 Hardware 34.95 Balance 839.60\\r\\n127 Video 7.45 Balance 832.15\\r\\n128 Book 14.32 Balance 817.83\\r\\n129 Gasoline 16.10 Balance 801.73\\r\\nTotal expense  198.27\\r\\nAverage expense  39.65"
    });
    inputs.add(new Object[]{
            "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?",
            "Original Balance: 1233.00\\r\\n125 Hardware 24.80 Balance 1208.20\\r\\n123 Flowers 93.50 Balance 1114.70\\r\\n127 Meat 120.90 Balance 993.80\\r\\n120 Picture 34.00 Balance 959.80\\r\\n124 Gasoline 11.00 Balance 948.80\\r\\n123 Photos 71.40 Balance 877.40\\r\\n122 Picture 93.50 Balance 783.90\\r\\n132 Tyres 19.00 Balance 764.90\\r\\n129 Stamps 13.60 Balance 751.30\\r\\n129 Fruits 17.60 Balance 733.70\\r\\n129 Market 128.00 Balance 605.70\\r\\n121 Gasoline 13.60 Balance 592.10\\r\\nTotal expense  640.90\\r\\nAverage expense  53.41"
    });
    inputs.add(new Object[]{
            "1242.00\n122 Hardware;! 13.60\n127 Hairdresser 13.10\n123 Fruits 93.50?;\n132 Stamps;!{ 13.60?;\n160 Pen;! 17.60?;\n002 Car;! 34.00",
            "Original Balance: 1242.00\\r\\n122 Hardware 13.60 Balance 1228.40\\r\\n127 Hairdresser 13.10 Balance 1215.30\\r\\n123 Fruits 93.50 Balance 1121.80\\r\\n132 Stamps 13.60 Balance 1108.20\\r\\n160 Pen 17.60 Balance 1090.60\\r\\n002 Car 34.00 Balance 1056.60\\r\\nTotal expense  185.40\\r\\nAverage expense  30.90"
    });
    inputs.add(new Object[]{
            "0.00\n100 Food 10.00\n101 Drinks 5.00",
            "Original Balance: 0.00\\r\\n100 Food 10.00 Balance -10.00\\r\\n101 Drinks 5.00 Balance -15.00\\r\\nTotal expense  15.00\\r\\nAverage expense  7.50"
    });
    inputs.add(new Object[]{
            "10000.00\n200 Yacht 9000.00\n201 Car 500.00\n202 Watch 1500.00",
            "Original Balance: 10000.00\\r\\n200 Yacht 9000.00 Balance 1000.00\\r\\n201 Car 500.00 Balance 500.00\\r\\n202 Watch 1500.00 Balance -1000.00\\r\\nTotal expense  11000.00\\r\\nAverage expense  3666.67"
    });
    inputs.add(new Object[]{
            "800.00\n102 Snack 2.00\n103 Juice 1.50",
            "Original Balance: 800.00\\r\\n102 Snack 2.00 Balance 798.00\\r\\n103 Juice 1.50 Balance 796.50\\r\\nTotal expense  3.50\\r\\nAverage expense  1.75"
    });
    return combineData(inputs, SIX);
  }
  
  @DataProvider(name = "data-mean")
  public static Iterator<Object[]> dpMean() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{"London", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", 30.333333333333332});
    inputs.add(new Object[]{"Paris", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", 29.633333333333333});
    inputs.add(new Object[]{"Berlin", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", -1.0});

    return combineData(inputs, SIX);
  }

  @DataProvider(name = "data-variance")
  public static Iterator<Object[]> dpVariance() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{"London", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", 65.3436111111111});
    inputs.add(new Object[]{"Paris", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", 18.229333333333332});
    inputs.add(new Object[]{"Berlin", "London:Jan 20.5,Feb 30.2,Mar 40.3\nParis:Jan 25.2,Feb 28.3,Mar 35.4", -1.0});

    return combineData(inputs, SIX);
  }

    @DataProvider(name = "data-nbaCup")
    public static Iterator<Object[]> dpNbaCup() {
        List<Object[]> inputs = new ArrayList<>();

        String resultSheet = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                + "Los Angeles Clippers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105";

        String resultSheetDraw = "Los Angeles Clippers 104 Dallas Mavericks 88,"
                + "Los Angeles Clippers 111 Minnesota Timberwolves 111,"
                + "Sacramento Kings 112 Los Angeles Clippers 112";


        String resultSheetDecimalFirst = "New York Knicks 101.12 Atlanta Hawks 112";
        String resultSheetDecimalSecond = "New York Knicks 101 Atlanta Hawks 112.3";
        String resultSheetDecimalBoth = "New York Knicks 101.30 Atlanta Hawks 112.3";

        inputs.add(new Object[]{resultSheet, "Los Angeles Clippers", "Los Angeles Clippers:W=2;D=0;L=1;Scored=326;Conceded=304;Points=6"});
        inputs.add(new Object[]{resultSheet, "Soft Serve QA", "Soft Serve QA:This team didn't play!"});
        inputs.add(new Object[]{resultSheet, "", ""});
        inputs.add(new Object[]{resultSheetDraw, "Los Angeles Clippers", "Los Angeles Clippers:W=1;D=2;L=0;Scored=327;Conceded=311;Points=5"});
        inputs.add(new Object[]{resultSheetDecimalFirst, "Atlanta Hawks", "Error(float number):New York Knicks 101.12 Atlanta Hawks 112"});
        inputs.add(new Object[]{resultSheetDecimalSecond, "Atlanta Hawks", "Error(float number):New York Knicks 101 Atlanta Hawks 112.3"});
        inputs.add(new Object[]{resultSheetDecimalBoth, "Atlanta Hawks", "Error(float number):New York Knicks 101.30 Atlanta Hawks 112.3"});
        inputs.add(new Object[]{"", "", ""});
        inputs.add(new Object[]{"", "Soft Serve QA", "Soft Serve QA:This team didn't play!"});

        return combineData(inputs, SIX);
    }
}

