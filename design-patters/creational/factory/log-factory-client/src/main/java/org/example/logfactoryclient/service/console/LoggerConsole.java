package org.example.logfactoryclient.service.console;

import org.example.logfactorylib.service.LogPrinter;
import org.example.logfactorylib.service.Logger;

public class LoggerConsole extends Logger {

    @Override
    protected LogPrinter createLoggerPrinter() {
        return new LogPrinterConsole();
    }
}
