/**
 * 
 */
package org.rtevo.main;

import org.rtevo.common.Configuration;
import org.rtevo.gui.RobotEvolutionWindow;
import org.rtevo.simulation.Generation;
import org.rtevo.simulation.Simulation;

/* MEMO Weight is a property of all objects, joints and body have weights, make them
 * extend something, evolve this weight
 * 
 * Think about: no legs or anything like that, just random polygons with weight
 * and joints
 */

/**
 * main application class
 * 
 */
public class RobotEvolution {
    private RobotEvolutionWindow window;

    private Configuration c;

    public RobotEvolution(Configuration config) {
        c = config;

        Generation.configureWorkerPool(c.parallelSimulations);
    }

    public void start() {
        window = new RobotEvolutionWindow(c.windowWidth, c.windowHeight);

        // Initialize GA:
        Generation generation = new Generation(c.robotMilliseconds,
                c.robotsPerGeneration, c.gravity);

        // Main algorithm
        for (int i = 0; i < c.generations; ++i) {
            long wait = 5000;
            int FPS = 60;
            int waitTime = 1000 / FPS;
            long started = System.currentTimeMillis();

            // Create all the simulations and start them in their separate
            // threads
            generation.computeAll();

            // Create a simulation for a single chromosome
            Simulation presentationSimulation = generation.getSample();
            presentationSimulation.setTimeStep(0.01f);
            presentationSimulation.setup();

            // Submit it to the renderer
            window.setSimulation(presentationSimulation);

            // Simulate and render the presentation simulation while real
            // computation is being done in the backend

            while (!generation.isDone()
                    || started + wait > System.currentTimeMillis()) {
                presentationSimulation.update();
                window.updateDisplay();

                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Evolve
            generation = generation.nextGeneration();

            System.out.println("generation #" + (i + 1) + " done, took "
                    + (System.currentTimeMillis() - started) + " milliseconds");
        }

        exit();
    }

    public void exit() {
        // window.destroy();

        // TODO convert to log
        System.out.println("Program done.");

        System.exit(0);
    }

}
