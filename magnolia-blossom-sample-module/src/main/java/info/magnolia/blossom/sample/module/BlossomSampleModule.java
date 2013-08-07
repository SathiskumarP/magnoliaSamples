package info.magnolia.blossom.sample.module;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;
import info.magnolia.module.blossom.module.BlossomModuleSupport;

/**
 * This class manages the lifecycle of the blossomSampleModule module. It starts and stops Spring when Magnolia starts up and
 * shuts down. The dispatcher servlet we create here is a servlet but its managed internally and never exposed to the
 * outside world. A request will never reach this servlet directly. It is only accessed by Magnolia to render the
 * templates, areas and components and display the dialogs managed by the servlet.
 */
public class BlossomSampleModule extends BlossomModuleSupport implements ModuleLifecycle {

    public void start(ModuleLifecycleContext moduleLifecycleContext) {
        if (moduleLifecycleContext.getPhase() == ModuleLifecycleContext.PHASE_SYSTEM_STARTUP) {
            super.initRootWebApplicationContext("classpath:/applicationContext.xml");
            super.initBlossomDispatcherServlet("blossom", "classpath:/blossom-servlet.xml");
        }
    }

    public void stop(ModuleLifecycleContext moduleLifecycleContext) {
        if (moduleLifecycleContext.getPhase() == ModuleLifecycleContext.PHASE_SYSTEM_SHUTDOWN) {
            super.destroyDispatcherServlets();
            super.closeRootWebApplicationContext();
        }
    }
}
