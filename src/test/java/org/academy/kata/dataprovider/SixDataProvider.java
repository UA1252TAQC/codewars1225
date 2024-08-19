package org.academy.kata.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;


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
            "Original Balance: 1000,00\\r\\n125 Market 125.45 Balance 874,55\\r\\n126 Hardware 34.95 Balance 839,60\\r\\n127 Video 7.45 Balance 832,15\\r\\n128 Book 14.32 Balance 817,83\\r\\n129 Gasoline 16.10 Balance 801,73\\r\\nTotal expense  198,27\\r\\nAverage expense  39,65"
    });
    inputs.add(new Object[]{
            "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?",
            "Original Balance: 1233,00\\r\\n125 Hardware 24.80 Balance 1208,20\\r\\n123 Flowers 93.50 Balance 1114,70\\r\\n127 Meat 120.90 Balance 993,80\\r\\n120 Picture 34.00 Balance 959,80\\r\\n124 Gasoline 11.00 Balance 948,80\\r\\n123 Photos 71.40 Balance 877,40\\r\\n122 Picture 93.50 Balance 783,90\\r\\n132 Tyres 19.00 Balance 764,90\\r\\n129 Stamps 13.60 Balance 751,30\\r\\n129 Fruits 17.60 Balance 733,70\\r\\n129 Market 128.00 Balance 605,70\\r\\n121 Gasoline 13.60 Balance 592,10\\r\\nTotal expense  640,90\\r\\nAverage expense  53,41"
    });
    inputs.add(new Object[]{
            "1242.00\n122 Hardware;! 13.60\n127 Hairdresser 13.10\n123 Fruits 93.50?;\n132 Stamps;!{ 13.60?;\n160 Pen;! 17.60?;\n002 Car;! 34.00",
            "Original Balance: 1242,00\\r\\n122 Hardware 13.60 Balance 1228,40\\r\\n127 Hairdresser 13.10 Balance 1215,30\\r\\n123 Fruits 93.50 Balance 1121,80\\r\\n132 Stamps 13.60 Balance 1108,20\\r\\n160 Pen 17.60 Balance 1090,60\\r\\n002 Car 34.00 Balance 1056,60\\r\\nTotal expense  185,40\\r\\nAverage expense  30,90"
    });
    return combineData(inputs, SIX);
  }
}

