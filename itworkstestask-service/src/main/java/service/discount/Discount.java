package service.discount;

import model.Component;
import model.Inputdevice;
import model.Monitor;
import model.Peripheria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class Discount {
    private static final double OTHER_DISCOUNT=0.05;
    private static final double INPUT_DEVICE_DISCOUNT=0.4;

    public List<Component> componentsWithDiscount(List<Component> components){
        List<Component> componentList=new ArrayList<Component>(components);
        double discount=1;
        if(isDiscounted(1,3)) discount-=OTHER_DISCOUNT;
        for(Component c:componentList){
            c.setCost(c.getCost()*discount);
        }
        return componentList;
    }

    public List<Peripheria> peripheralsWithDiscount(List<Peripheria> peripherals){
        List<Peripheria> peripheriaList=new ArrayList<Peripheria>(peripherals);
        double discount=1;
        if(isDiscounted(4,7)) discount-=OTHER_DISCOUNT;
        for(Peripheria p:peripheriaList){
            p.setCost(p.getCost()*discount);
        }
        return peripheriaList;
    }

    public List<Monitor> monitorsWithDiscount(List<Monitor> monitors){
        List<Monitor> monitorList=new ArrayList<Monitor>(monitors);
        if(isDiscounted(4,7)){
            for(Monitor m:monitorList){
                double discount=(1-m.getSize()/100);
                m.setCost(m.getCost()*discount);
            }
        }
        return monitorList;
    }

    public List<Inputdevice> inputdevicesWithDiscount(List<Inputdevice> inputdevices){
        List<Inputdevice> inputdeviceList=new ArrayList<Inputdevice>(inputdevices);
        if(isDiscounted(5,7)){
            for (Inputdevice i:inputdeviceList){
                double discount=1-INPUT_DEVICE_DISCOUNT;
                i.setCost(i.getCost()*discount);
            }
        }
        return inputdeviceList;
    }

    private boolean isDiscounted(int min,int max){
        return isBetween(LocalDate.now().getDayOfWeek().getValue(),min,max);
    }
    private boolean isBetween(int val,int min, int max){
        return val>=min && val<=max;
    }
}
