package com.lexach.netcracker.spring.ripper.quoters;

public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}