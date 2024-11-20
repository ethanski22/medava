package edu.uc.cs3003.medava;

public class SupplyChain {
    public static void main(String args[]) {
        System.out.println("Hello there");
        HospitalRunner.run();
        Transporter semiTruck = new Transporter("LaserShip", 30.0, 80.0);
    }
}
