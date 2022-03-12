package com.study.dp.creational.factorymethod;

public abstract class Plan {
    protected double rate;
    abstract String getPlan();

    public void calculateBill(int units) {
        System.out.println(rate * units);
    }
}

class DomesticPlan extends Plan {

    @Override
    public String getPlan() {
        rate = 0.3;
        return "Domestic plan";
    }
}
class IndustrialPlan extends Plan {

    @Override
    public String getPlan() {
        rate = 0.4;
        return "Industrial plan";
    }
}

class CommercialPlan extends Plan {

    @Override
    public String getPlan() {
        rate = 0.5;
        return "Domestic plan";
    }
}

class PlanFactory {

    public Plan getBillingPlan(String planType) {
        if(planType.equals("DOMESTIC")) {
            return new DomesticPlan();
        } else if(planType.equals("COMMERCIAL")) {
            return new CommercialPlan();
        } else if(planType.equals("INDUSTRIAL")) {
            return new IndustrialPlan();
        }
        return null;
    }
}


class Demo {
    public static void main(String[] args) {
        PlanFactory factory = new PlanFactory();
        Plan domestic = factory.getBillingPlan("DOMESTIC");
        System.out.println(domestic.getPlan());
        domestic.calculateBill(10);

        Plan commercial = factory.getBillingPlan("COMMERCIAL");
        System.out.println(commercial.getPlan());
        commercial.calculateBill(10);

        Plan industrial = factory.getBillingPlan("INDUSTRIAL");
        System.out.println(industrial.getPlan());
        industrial.calculateBill(10);
    }
}
