package C15_泛型.BorderOfGeneric.Demo2;

public class SuperHero<Power extends SuperPower> {
    private Power power;
    public SuperHero(Power power){
        this.power = power;
    }
    Power getPower(){
        return power;
    }
}
