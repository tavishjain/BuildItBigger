package com.jain.tavish.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.tavish.jain.com",
                ownerName = "backend.builditbigger.tavish.jain.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "putJoke")
    public MyBean putJoke() {
        return new MyBean();
    }

}
