package edu.uc.cs3003.medava;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


private List<Medicine> goods;

public class Transporter {
    private String mTransporterName;
    public String getTransporterName() {
        return mTransporterName;
    }

    private double mLowTemperature, mHighTemperature;

    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    public boolean load(Medicine itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            System.out.println(String.format("Adding a %s to the transporter.", itemToLoad.getMedicineName()));
            goods.add(itemToLoad);
            return true;
        }
        return false;
    }

    // public boolean load(Object itemToLoad) {
    //     if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
    //         System.out.println(String.format("Adding a %s to the transporter.", itemToLoad.getMedicineName()));
    //         goods.add(itemToLoad);
    //         return true;
    //     }
    //     return false;
    // }

    public boolean load(Object itemToLoad) {
        try {
            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
                    Double.class, Double.class);
            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
            if (resultOfMethodCall) {
                goods.add(itemToLoad);
            }
            return resultOfMethodCall;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            return false;
        }
    }

    public Medicine unload() {
        return goods.remove(0);
    }

    public Object unload() {
        return goods.remove(0);
    }

    public boolean isEmpty() {
        return goods.isEmpty();
    }
```
}

private List<Medicine> goods;

{
    goods = new List<Medicine>();
  }

  {
    goods = new ArrayList<Medicine>();
  }

  public List<Medicine> goods;

  public void ship() {
    // Do some shipping!
  }
  private List<Object> goods;
  goods = new ArrayList<Object>();

  private List<Shippable> goods;
  goods = new ArrayList<Shippable>();

  public Shippable unload() {
    return goods.remove(0);
}

public boolean load(Shippable itemToLoad) {
    if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
        return goods.add(itemToLoad);
    }
    return false;
}