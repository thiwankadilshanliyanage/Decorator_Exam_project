/**
 *
 * @author Thiwanka
 */
public class Test {

    public static void main(String[] args) {

          IceCream i1 = new VanillaIceCream();
                   i1 = new ChocolateSauce(i1);//chocolate sause IS-A Iceceam
                   System.out.println(i1.getDes());
                   System.out.println(i1.getPrice());
    }
    
}
interface  IceCream{//Component
    public abstract double getPrice();
    public abstract String getDes();
    
}
class VanillaIceCream implements IceCream{//SubComponent (IS-A)
    @Override
    public double getPrice(){
        return 50;
    }
    @Override
    public String getDes(){
        return "Vanila Icecream";
    }
}
abstract class IceCreamDecorator implements IceCream{//Decorator (IS-A)
    private final IceCream iceCream;    //HAS_A

    public IceCreamDecorator(IceCream iceCream) {//Decorator must has a icecream therefor we create constructor in decorator class (Because before add chocolate sause must has a icecream)
        this.iceCream = iceCream;
    }
    @Override
    public double getPrice(){
        return iceCream.getPrice();
    }
    @Override
    public String getDes(){
        return iceCream.getDes();
    }
    
}
 class ChocolateSauce extends IceCreamDecorator{//SubDecorator (IS-A)
    
     public ChocolateSauce(IceCream iceCream) {//child class must inherit super class everythings,Therefor it must has constructor
         super(iceCream);//child class call supper class
     }

    @Override
    public double getPrice() {
        return super.getPrice()+10;
    }
     @Override
    public String getDes(){
        return super.getDes()+" With Chocolate Sauce" ;
    }
    
}
   