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

    public static List<Peripheria> peripheralsWithDiscount(List<Peripheria> peripherals){
        List<Peripheria> peripheriaList=new ArrayList<Peripheria>(peripherals);
        double discount=1;
        if(isDiscounted(4,7)) discount-=OTHER_DISCOUNT;
        for(Peripheria p:peripheriaList){
            p.setCost(round2SecondDec(p.getCost()*discount));
        }
        return peripheriaList;
    }

    public static Peripheria peripheralWithDiscount(Peripheria peripheria){
        double discount=1;
        if(isDiscounted(4,7)) discount-=OTHER_DISCOUNT;
        peripheria.setCost(round2SecondDec(peripheria.getCost()*discount));
        return peripheria;
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

    public static List<Inputdevice> inputdevicesWithDiscount(List<Inputdevice> inputdevices){
        List<Inputdevice> inputdeviceList=new ArrayList<Inputdevice>(inputdevices);
        if(isDiscounted(5,7)){
            for (Inputdevice i:inputdeviceList){
                double discount=1-INPUT_DEVICE_DISCOUNT;
                i.setCost(round2SecondDec(i.getCost()*discount));
            }
        }
        return inputdeviceList;
    }

    public static Inputdevice inputdeviceWithDiscount(Inputdevice inputdevice){
        if(isDiscounted(5,7)){
            double discount=1-INPUT_DEVICE_DISCOUNT;
            inputdevice.setCost(round2SecondDec(inputdevice.getCost()*discount));
        }
        return inputdevice;
    }

    public static List<Storagedevice> storagedevicesWithDiscount(List<Storagedevice> storagedevices){
        List<Storagedevice> storagedeviceList=new ArrayList<Storagedevice>(storagedevices);
        if(isDiscounted(4,5)){
            for(Storagedevice s:storagedeviceList){
                double discountRatio=1;
                String brand=s.getBrand();
                if(brand.equalsIgnoreCase("seagate")) discountRatio=1;
                else if(brand.equalsIgnoreCase("kingston")) discountRatio=2;
                else if(brand.equalsIgnoreCase("samsung")) discountRatio=3;
                double discount=1-0.1/discountRatio;
                s.setCost(round2SecondDec(s.getCost()*discount));
            }
        }
        return storagedeviceList;
    }

    public static Storagedevice storagedeviceWithDiscount(Storagedevice storagedevice){
        if(isDiscounted(4,5)){
            double discountRatio=1;
            String brand=storagedevice.getBrand();
            if(brand.equalsIgnoreCase("seagate")) discountRatio=1;
            else if(brand.equalsIgnoreCase("kingston")) discountRatio=2;
            else if(brand.equalsIgnoreCase("samsung")) discountRatio=3;
            double discount=1-0.1/discountRatio;
            storagedevice.setCost(round2SecondDec(storagedevice.getCost()*discount));
        }
        return storagedevice;
    }

    private static boolean isDiscounted(int min,int max){
        int dayOfWeek=LocalDate.now().getDayOfWeek().getValue();
        return dayOfWeek>=min && dayOfWeek<=max;
    }

    private static double round2SecondDec(double num){
        return Double.valueOf(Math.round(num*100))/100;
    }
}
