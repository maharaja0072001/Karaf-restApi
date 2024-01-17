package org.abc.launcher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.abc.launcher.Launcher;

public class Activator implements BundleActivator {

    public void start(BundleContext context) {
        System.out.println("Starting the bundle-Launcher");
    }
    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}