public class Test {
    public static void main(String[] args) {
        FruitJuice fj = new Pomegranate();
        System.out.println(fj.getPrice());
        
        FruitJuice fj2 = new Orange();
        fj2= new VanillaCream(fj2);
        System.out.println(fj2.getPrice());
        
        FruitJuice fj3 = new Strawberry();
        fj3 = new VanillaCream(fj3);
        fj3 = new WhippingCream(fj3);
        System.out.println(fj3.getPrice());
        
        FruitJuice fj4 = new Avacado();
        fj4 = new VanillaCream(fj4);
        fj4 = new WhippingCream(fj4);
        fj4 = new CashewNuts(fj4);
        System.out.println(fj4.getPrice());
            
    }
       }

interface FruitJuice{
    public abstract double getPrice();
    
}
class Orange implements FruitJuice{
    @Override
    public double getPrice(){
        return 100;
    }
}
class Avacado implements FruitJuice{
    @Override
    public double  getPrice(){
        return 120;
    }
}
class Strawberry implements FruitJuice{
    @Override
    public double  getPrice(){
        return 200;
    }
}
class Pomegranate implements FruitJuice{
    @Override
    public double  getPrice(){
        return 250;
    }
}
abstract class Toppings implements FruitJuice{
   private final FruitJuice fruitJuice;
    
    public Toppings(FruitJuice fruitJuice){
        this.fruitJuice = fruitJuice;
    }
    @Override
    public double getPrice(){
        return fruitJuice.getPrice();
    }
}
class WhippingCream extends Toppings{
    public WhippingCream(FruitJuice fruitJuice){
        super(fruitJuice);
    }
    @Override
    public double getPrice(){
        return super.getPrice()+20;
    }
}
class VanillaCream extends Toppings{
    public VanillaCream(FruitJuice fruitJuice){
        super(fruitJuice);
    }
    @Override
     public double getPrice(){
        return super.getPrice()+50;
    }
}
class CashewNuts extends Toppings{
    public CashewNuts(FruitJuice fruitJuice){
        super(fruitJuice);
    }
    @Override
     public double getPrice(){
        return super.getPrice()+10;
    }
}
