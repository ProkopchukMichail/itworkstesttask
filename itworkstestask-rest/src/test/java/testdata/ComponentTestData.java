package testdata;

import model.Component;

/**
 * Created by comp on 24.08.2017.
 */
public abstract class ComponentTestData {
    public static final Component COMPONENT1=new Component(1,"component1",2,3,
            "china",15,"intel",250);
    public static final Component COMPONENT2=new Component(2,"component2",2,3,
            "china",15,"intel",250);
    public static final Component COMPONENT3=new Component(3,"component3",2,30,
            "china",35,"nvidia",150);
    public static final Component COMPONENT_UPDATE=new Component(3,"component_update",2,30,
            "china",35,"nvidia",150);
}
