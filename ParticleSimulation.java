/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw_lab9;
import java.util.ArrayList;
import java.util.Scanner;

public class ParticleSimulation {
    private ArrayList<Integer> particles;
    private int totalEnergy;
    
    public ParticleSimulation(ArrayList<Integer> particles) {
        this.particles = particles;
        this.totalEnergy = 0;
    }
    
    public int simulate() {
        while (particles.size() > 1) {
            int maxEnergy = -1;
            int targetIndex = -1;

            for (int i = 0; i < particles.size() - 1; i++) {
                int energyGain = Math.abs(particles.get(i) - particles.get(i + 1));
                
                if (energyGain > maxEnergy) {
                    maxEnergy = energyGain;
                    targetIndex = i;
                }
            }

            totalEnergy += maxEnergy;

            particles.remove(targetIndex);
            particles.remove(targetIndex);
        }

        return totalEnergy;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        ArrayList<Integer> particlesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            particlesList.add(sc.nextInt());
        }
        ParticleSimulation sim = new ParticleSimulation(particlesList);
        int result = sim.simulate();
        System.out.println(result);

        sc.close();
    }
}