package com.ada.githubthirdparty.customes;

import org.zalando.logbook.*;
import org.zalando.logbook.core.DefaultHttpLogWriter;

import java.io.IOException;

public class CustomSink implements Sink {


    private final HttpLogFormatter formatter = new CustomLogFormatter();
    private final HttpLogWriter writer = new DefaultHttpLogWriter();
    @Override
    public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
        writer.write(precorrelation, formatter.format(precorrelation, request));
    }

    @Override
    public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
        writer.write(correlation, formatter.format(correlation, response));
    }
}
