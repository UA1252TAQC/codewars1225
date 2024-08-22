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
             "1687.00\n160 Perfume;! 71.40?;\n126 Stamps;! 13.60?;\n132 Gasoline;! 54.00?;\n003 Hardware;! 93.50?;\n130 Gasoline;! 34.00?;\n123 Hairdresser;! 12.20?;",
             "Original Balance: 1687.00\\r\\n160 Perfume 71.40 Balance 1615.60\\r\\n126 Stamps 13.60 Balance 1602.00\\r\\n132 Gasoline 54.00 Balance 1548.00\\r\\n003 Hardware 93.50 Balance 1454.50\\r\\n130 Gasoline 34.00 Balance 1420.50\\r\\n123 Hairdresser 12.20 Balance 1408.30\\r\\nTotal expense  278.70\\r\\nAverage expense  46.45"
     });

     inputs.add(new Object[]{
             "963.00\n131 Books 12.20\n139 Gasoline 120.90\n002 Hardware;! 71.40?;",
             "Original Balance: 963.00\\r\\n131 Books 12.20 Balance 950.80\\r\\n139 Gasoline 120.90 Balance 829.90\\r\\n002 Hardware 71.40 Balance 758.50\\r\\nTotal expense  204.50\\r\\nAverage expense  68.17"
     });

     inputs.add(new Object[]{
             "1101.00\n001 Vegetables 54.00 \n002 Hardware 24.81 \n003 Picture 110.73 \n004 Hardware 12.00 \n005 Gasoline ;! 71.41 ?;\n006 Stamps ;! 11.00 ?;",
             "Original Balance: 1101.00\\r\\n001 Vegetables 54.00 Balance 1047.00\\r\\n002 Hardware 24.81 Balance 1022.19\\r\\n003 Picture 110.73 Balance 911.46\\r\\n004 Hardware 12.00 Balance 899.46\\r\\n005 Gasoline 71.41 Balance 828.05\\r\\n006 Stamps 11.00 Balance 817.05\\r\\nTotal expense  283.95\\r\\nAverage expense  47.33"
     });

     inputs.add(new Object[]{
             "1614.00\n001 Grocery ;! 13.10 ?;\n002 Video ;! 71.41 ?;\n003 Music 19.00\n004 Picture ;! 17.00 ?;\n005 Music ;! 110.73 ?;\n006 Beauty ;! 110.73 ?;\n007 Flowers ;! 20.00 ?;\n008 Fruits ;! 20.00 ?;\n009 Tyres ;! 128.00 ?;\n010 Tyres ;! 110.73 ?;",
             "Original Balance: 1614.00\\r\\n001 Grocery 13.10 Balance 1600.90\\r\\n002 Video 71.41 Balance 1529.49\\r\\n003 Music 19.00 Balance 1510.49\\r\\n004 Picture 17.00 Balance 1493.49\\r\\n005 Music 110.73 Balance 1382.76\\r\\n006 Beauty 110.73 Balance 1272.03\\r\\n007 Flowers 20.00 Balance 1252.03\\r\\n008 Fruits 20.00 Balance 1232.03\\r\\n009 Tyres 128.00 Balance 1104.03\\r\\n010 Tyres 110.73 Balance 993.30\\r\\nTotal expense  620.70\\r\\nAverage expense  62.07"
     });

     inputs.add(new Object[]{
             "1031.00\n001 Books ;! 54.00 ?;\n002 Fruits 12.22\n003 Books ;! 110.73 ?;\n004 Beauty ;! 71.41 ?;\n005 Fruits ;! 71.41 ?;\n006 Perfume 11.00\n007 Market 20.00\n008 Car ;! 13.10 ?;",
             "Original Balance: 1031.00\\r\\n001 Books 54.00 Balance 977.00\\r\\n002 Fruits 12.22 Balance 964.78\\r\\n003 Books 110.73 Balance 854.05\\r\\n004 Beauty 71.41 Balance 782.64\\r\\n005 Fruits 71.41 Balance 711.23\\r\\n006 Perfume 11.00 Balance 700.23\\r\\n007 Market 20.00 Balance 680.23\\r\\n008 Car 13.10 Balance 667.13\\r\\nTotal expense  363.87\\r\\nAverage expense  45.48"
     });

     inputs.add(new Object[]{
             "804.00\n001 Vegetables  93.50\n002 Picture  17.50\n003 Meat  12.22\n004 Grocery ;! 110.73 ?;\n005 Flowers ;! 11.00 ?;\n006 Market  120.30\n007 Stamps  24.81\n008 Car  110.73\n009 Stamps ;! 120.90 ?;",
             "Original Balance: 804.00\\r\\n001 Vegetables 93.50 Balance 710.50\\r\\n002 Picture 17.50 Balance 693.00\\r\\n003 Meat 12.22 Balance 680.78\\r\\n004 Grocery 110.73 Balance 570.05\\r\\n005 Flowers 11.00 Balance 559.05\\r\\n006 Market 120.30 Balance 438.75\\r\\n007 Stamps 24.81 Balance 413.94\\r\\n008 Car 110.73 Balance 303.21\\r\\n009 Stamps 120.90 Balance 182.31\\r\\nTotal expense  621.69\\r\\nAverage expense  69.08"
     });

     inputs.add(new Object[]{
             "822.00\n001 Music ;! 128.00 ?;\n002 Hardware  20.00\n003 Gasoline ;! 12.22 ?;\n004 Flowers ;! 20.00 ?;\n005 Stamps  17.50\n006 Hardware ;! 19.00 ?;\n007 Picture ;! 54.00 ?;\n008 Meat  20.00\n009 Vegetables ;! 128.00 ?;",
             "Original Balance: 822.00\\r\\n001 Music 128.00 Balance 694.00\\r\\n002 Hardware 20.00 Balance 674.00\\r\\n003 Gasoline 12.22 Balance 661.78\\r\\n004 Flowers 20.00 Balance 641.78\\r\\n005 Stamps 17.50 Balance 624.28\\r\\n006 Hardware 19.00 Balance 605.28\\r\\n007 Picture 54.00 Balance 551.28\\r\\n008 Meat 20.00 Balance 531.28\\r\\n009 Vegetables 128.00 Balance 403.28\\r\\nTotal expense  418.72\\r\\nAverage expense  46.52"
     });

     inputs.add(new Object[]{
             "1369.00\n001 Gasoline ;! 110.73 ?;\n002 Gasoline ;! 128.00 ?;\n003 Vegetables  17.00\n004 Tyres ;! 20.00 ?;\n005 Meat  19.00\n006 Car  110.73\n007 Gasoline  110.73",
             "Original Balance: 1369.00\\r\\n001 Gasoline 110.73 Balance 1258.27\\r\\n002 Gasoline 128.00 Balance 1130.27\\r\\n003 Vegetables 17.00 Balance 1113.27\\r\\n004 Tyres 20.00 Balance 1093.27\\r\\n005 Meat 19.00 Balance 1074.27\\r\\n006 Car 110.73 Balance 963.54\\r\\n007 Gasoline 110.73 Balance 852.81\\r\\nTotal expense  516.19\\r\\nAverage expense  73.74"
     });

     inputs.add(new Object[]{
             "1114.00\n001 Photos ;! 54.00 ?;\n002 Pen  3.20\n003 Photos ;! 3.20 ?;\n004 Music  11.00\n005 Video  19.00\n006 Gasoline  54.00",
             "Original Balance: 1114.00\\r\\n001 Photos 54.00 Balance 1060.00\\r\\n002 Pen 3.20 Balance 1056.80\\r\\n003 Photos 3.20 Balance 1053.60\\r\\n004 Music 11.00 Balance 1042.60\\r\\n005 Video 19.00 Balance 1023.60\\r\\n006 Gasoline 54.00 Balance 969.60\\r\\nTotal expense  144.40\\r\\nAverage expense  24.07"
     });

     inputs.add(new Object[]{
             "1389.00\n001 Car ;! 24.81 ?;\n002 Pen  11.00\n003 Hardware  93.50\n004 Hardware ;! 13.10 ?;\n005 Vegetables  11.00\n006 Tyres ;! 120.90 ?;\n007 Hardware ;! 17.50 ?;\n008 Meat ;! 93.50 ?;",
             "Original Balance: 1389.00\\r\\n001 Car 24.81 Balance 1364.19\\r\\n002 Pen 11.00 Balance 1353.19\\r\\n003 Hardware 93.50 Balance 1259.69\\r\\n004 Hardware 13.10 Balance 1246.59\\r\\n005 Vegetables 11.00 Balance 1235.59\\r\\n006 Tyres 120.90 Balance 1114.69\\r\\n007 Hardware 17.50 Balance 1097.19\\r\\n008 Meat 93.50 Balance 1003.69\\r\\nTotal expense  385.31\\r\\nAverage expense  48.16"
     });

     inputs.add(new Object[]{
             "1734.00\n001 Beauty ;! 93.50 ?;\n002 Fruits  19.00\n003 Tyres  24.81\n004 Meat ;! 20.00 ?;\n005 Photos  19.00\n006 Grocery  17.00\n007 Grocery ;! 12.00 ?;",
             "Original Balance: 1734.00\\r\\n001 Beauty 93.50 Balance 1640.50\\r\\n002 Fruits 19.00 Balance 1621.50\\r\\n003 Tyres 24.81 Balance 1596.69\\r\\n004 Meat 20.00 Balance 1576.69\\r\\n005 Photos 19.00 Balance 1557.69\\r\\n006 Grocery 17.00 Balance 1540.69\\r\\n007 Grocery 12.00 Balance 1528.69\\r\\nTotal expense  205.31\\r\\nAverage expense  29.33"
     });

     inputs.add(new Object[]{
             "1138.00\n001 Beauty ;! 17.00 ?;\n002 Market  13.10\n003 Pen  128.00\n004 Grocery  34.00\n005 Market  11.00\n006 Gasoline ;! 12.00 ?;\n007 Picture ;! 120.90 ?;",
             "Original Balance: 1138.00\\r\\n001 Beauty 17.00 Balance 1121.00\\r\\n002 Market 13.10 Balance 1107.90\\r\\n003 Pen 128.00 Balance 979.90\\r\\n004 Grocery 34.00 Balance 945.90\\r\\n005 Market 11.00 Balance 934.90\\r\\n006 Gasoline 12.00 Balance 922.90\\r\\n007 Picture 120.90 Balance 802.00\\r\\nTotal expense  336.00\\r\\nAverage expense  48.00"
     });

     inputs.add(new Object[]{
             "1170.00\n001 Music  71.41\n002 Tyres  11.00\n003 Fruits  3.20\n004 Hardware  13.10\n005 Pen  128.00\n006 Stamps ;! 12.22 ?;\n007 Grocery  11.00",
             "Original Balance: 1170.00\\r\\n001 Music 71.41 Balance 1098.59\\r\\n002 Tyres 11.00 Balance 1087.59\\r\\n003 Fruits 3.20 Balance 1084.39\\r\\n004 Hardware 13.10 Balance 1071.29\\r\\n005 Pen 128.00 Balance 943.29\\r\\n006 Stamps 12.22 Balance 931.07\\r\\n007 Grocery 11.00 Balance 920.07\\r\\nTotal expense  249.93\\r\\nAverage expense  35.70"
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

    String resultSheetDecimal = "New York Knicks 101.12 Atlanta Hawks 112";

    inputs.add(new Object[]{resultSheet, "Los Angeles Clippers", "Los Angeles Clippers:W=2;D=0;L=1;Scored=326;Conceded=304;Points=6"});
    inputs.add(new Object[]{resultSheet, "", ""});
    inputs.add(new Object[]{"", "", ""});
    inputs.add(new Object[]{resultSheet, "Soft Serve QA", "Soft Serve QA:This team didn't play!"});
    inputs.add(new Object[]{"", "Soft Serve QA", "Soft Serve QA:This team didn't play!"});
    inputs.add(new Object[]{resultSheetDecimal, "Atlanta Hawks", "Error(float number):New York Knicks 101.12 Atlanta Hawks 112"});

    return combineData(inputs, SIX);
  }
}

