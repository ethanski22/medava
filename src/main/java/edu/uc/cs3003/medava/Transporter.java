package edu.uc.cs3003.medava;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Transporter {
    private String mTransporterName;
    private double mLowTemperature, mHighTemperature;
    private List<Shippable> goods;

    public String getTransporterName() {
        return mTransporterName;
    }

    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    {
        goods = new ArrayList<Shippable>();
    }

    public void ship() {
        // Do some shipping!
    }

    // public boolean load(Object itemToLoad) {
    //     try {
    //         Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
    //                 Double.class, Double.class);
    //         boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
    //                 Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
    //         if (resultOfMethodCall) {
    //             goods.add(itemToLoad);
    //         }
    //         return resultOfMethodCall;
    //     } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
    //             | InvocationTargetException e) {
    //         return false;
    //     }
    // }

    // public Medicine unload() {
    // return goods.remove(0);
    // }

    public boolean isEmpty() {
        return goods.isEmpty();
    }

    public Shippable unload() {
        return goods.remove(0);
    }

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            return goods.add(itemToLoad);
        }
        return false;
    }
}