package org.example.logfactorylib.service;

public abstract class Logger {

    protected abstract LogPrinter createLoggerPrinter();

    public void log(String msg) {
        createLoggerPrinter().print(msg);
    }

}
