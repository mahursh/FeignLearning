package com.ada.githubthirdparty.customes;

import org.zalando.logbook.*;

import java.io.IOException;

public class CustomLogFormatter implements HttpLogFormatter{


    @Override
    public String format(Precorrelation precorrelation, HttpRequest request) throws IOException {
        return String.format(
                "\033[1;34mREQUEST:\033[0m\n" +
                        "\033[1;33m\tURL:\033[0m %s\n" +
                        "\033[1;33m\tHTTP METHOD:\033[0m %s\n" +
                        "\033[1;33m\tHEADERS:\033[0m %s\n",
                request.getRequestUri(),
                request.getMethod(),
                request.getHeaders()
        );
    }

    @Override
    public String format(Correlation correlation, HttpResponse response) throws IOException {
        return String.format(
                "\033[1;34mRESPONSE:\033[0m\n" +
                        "\033[1;33m\tHTTP STATUS:\033[0m %d\n" +
                        "\033[1;33m\tHEADERS:\033[0m %s\n" +
                        "\033[1;33m\tDURATION:\033[0m %d ms\n",
                response.getStatus(),
                response.getHeaders(),
                correlation.getDuration().toMillis()
        );
    }
}
