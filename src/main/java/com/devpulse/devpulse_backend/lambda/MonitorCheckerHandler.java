package com.devpulse.devpulse_backend.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MonitorCheckerHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {

        context.getLogger().log("DevPulse Monitor Checker Started");

        return "Monitor check completed";
    }
}