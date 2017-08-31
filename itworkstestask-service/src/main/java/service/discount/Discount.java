package service.discount;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class Discount {
    private static final double OTHER_DISCOUNT=0.05;
    private static final double INPUT_DEVICE_DISCOUNT=0.4;

    public static List<Component> componentsWithDiscount(List<Component> components){
        List<Component> componentList=new ArrayList<Component>(components);
        double discount=1;
        if(isDiscounted(1,3)) discount-=OTHER_DISCOUNT;
        for(Component c:componentList){
            c.setCost(round2SecondDec(c.getCost()*discount));
        }
        return componentList;
    }

    public static Component componentWithDiscount(Component component){
        double discount=1;
        if(isDiscounted(1,3)) discount-=OTHER_DISCOUNT;
        component.setCost(round2SecondDec(component.getCost()*discount));
        return component;
    }

    public static List<PeripheralDevice> peripheralDevicesWithDiscount(List<PeripheralDevice> peripherals){
        List<PeripheralDevice> peripheralDeviceList =new ArrayList<PeripheralDevice>(peripherals);
        double discount=1;
        if(isDiscounted(4,7)) discount-=OTHER_DISCOUNT;
        for(PeripheralDevice p: peripheralDeviceList){
            p.setCost(round2SecondDec(p.getCost()*discount));
        }
        return peripheralDeviceList;
    }

    public static PeripheralDevice peripheralDeviceWithDiscount(PeripheralDevice peripheralDevice){
        double discount=1;
        if(isDiscounted(4,7)) discount-=OTHER_DISCOUNT;
        peripheralDevice.setCost(round2SecondDec(peripheralDevice.getCost()*discount));
        return peripheralDevice;
    }

    public static List<Monitor> monitorsWithDiscount(List<Monitor> monitors){
        List<Monitor> monitorList=new ArrayList<Monitor>(monitors);
        if(isDiscounted(4,7)){
            for(Monitor m:monitorList){
                double discount=(1-m.getSize()/100);
                m.setCost(round2SecondDec(m.getCost()*discount));
            }
        }
        return monitorList;
    }

    public static Monitor monitorWithDiscount(Monitor monitor){
        if(isDiscounted(4,7)){
            double discount=(1-monitor.getSize()/100);
            monitor.setCost(round2SecondDec(monitor.getCost()*discount));
        }
        return monitor;
    }

    public static List<InputDevice> inputDevicesWithDiscount(List<InputDevice> inputDevices){
        List<InputDevice> inputDeviceList =new ArrayList<InputDevice>(inputDevices);
        if(isDiscounted(5,7)){
            for (InputDevice i: inputDeviceList){
                double discount=1-INPUT_DEVICE_DISCOUNT;
                i.setCost(round2SecondDec(i.getCost()*discount));
            }
        }
        return inputDeviceList;
    }

    public static InputDevice inputDeviceWithDiscount(InputDevice inputDevice){
        if(isDiscounted(5,7)){
            double discount=1-INPUT_DEVICE_DISCOUNT;
            inputDevice.setCost(round2SecondDec(inputDevice.getCost()*discount));
        }
        return inputDevice;
    }

    public static List<StorageDevice> storageDevicesWithDiscount(List<StorageDevice> storageDevices){
        List<StorageDevice> storageDeviceList =new ArrayList<StorageDevice>(storageDevices);
        if(isDiscounted(4,5)){
            for(StorageDevice s: storageDeviceList){
                double discountRatio=1;
                String brand=s.getBrand();
                if(brand.equalsIgnoreCase("seagate")) discountRatio=1;
                else if(brand.equalsIgnoreCase("kingston")) discountRatio=2;
                else if(brand.equalsIgnoreCase("samsung")) discountRatio=3;
                double discount=1-0.1/discountRatio;
                s.setCost(round2SecondDec(s.getCost()*discount));
            }
        }
        return storageDeviceList;
    }

    public static StorageDevice storageDeviceWithDiscount(StorageDevice storageDevice){
        if(isDiscounted(4,5)){
            double discountRatio=1;
            String brand= storageDevice.getBrand();
            if(brand.equalsIgnoreCase("seagate")) discountRatio=1;
            else if(brand.equalsIgnoreCase("kingston")) discountRatio=2;
            else if(brand.equalsIgnoreCase("samsung")) discountRatio=3;
            double discount=1-0.1/discountRatio;
            storageDevice.setCost(round2SecondDec(storageDevice.getCost()*discount));
        }
        return storageDevice;
    }

    private static boolean isDiscounted(int min,int max){
        int dayOfWeek=LocalDate.now().getDayOfWeek().getValue();
        return dayOfWeek>=min && dayOfWeek<=max;
    }

    private static double round2SecondDec(double num){
        return Double.valueOf(Math.round(num*100))/100;
    }
}
