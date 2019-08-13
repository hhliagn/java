package C15_泛型.BorderOfGeneric.Demo2;

public class SuperSleuth<Power extends XRayVision> extends SuperHero<Power> {
    public SuperSleuth(Power power) {
        super(power);
    }
    public void see(){
        getPower().seeThuWalls();
    }
}
