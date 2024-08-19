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
}

