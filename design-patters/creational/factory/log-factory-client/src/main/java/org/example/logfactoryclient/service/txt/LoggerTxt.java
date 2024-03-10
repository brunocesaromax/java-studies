package org.example.logfactoryclient.service.txt;

import org.example.logfactorylib.service.LogPrinter;
import org.example.logfactorylib.service.Logger;

public class LoggerTxt extends Logger {

    @Override
    protected LogPrinter createLoggerPrinter() {
        return new LogPrinterTxt();
    }
}
