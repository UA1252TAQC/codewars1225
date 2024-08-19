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
}

