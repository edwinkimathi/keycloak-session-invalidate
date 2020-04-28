## Preparations

### Keycloak

The Project is configured to use a local keycloak 9.0.3 with a port offset of 100

    ./standalone.sh -Djboss.socket.binding.port-offset=100

After the initial setup, import the Provided demo realm (data/realm-export-demo.json)
or create one with a client called 'demo'

- Access Type confidential
- Valid Redirect URL: * // for convenience 
- Admin URL: http://localhost:8080

Copy the credentials Secret to the application.yml

Create a new user for this realm


### Redis

Configure a REDIS Server. (TODO: example for docker container) 


## The actual Problem

The example Project contains a single REST Controller returning the current session ID.
This endpoint is secured by Keycloak (See com.example.config.SecurityConfig)

In an incognito Browser window to ensure there are no lingering session-ids,
call: http://localhost:8080/session.

You will be redirected to the keycloak login screen as expected. 
After a successful login the session ID will be displayed.

In another tab, go to the keycloak account sessions page 
http://localhost:8180/auth/realms/demo/account/sessions
and logout all sessions.

You will see a log-output from the CatalinaUserSessionManagement with the session ID  from the first request

    logoutHttpSession: b0dd2e00-3ab3-4044-b3f3-769c0f771452
    
The admin-url callback worked. 

Now, if we reload the session page I would expect to be redirected to the login-page again,
but the same session-id is displayed.
