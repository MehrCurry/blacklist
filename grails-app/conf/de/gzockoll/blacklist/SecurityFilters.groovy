package de.gzockoll.blacklist

import org.apache.shiro.authz.AuthorizationException
import org.apache.shiro.authz.UnauthenticatedException

class SecurityFilters {
    def filters = {
        all(uri: "/**") {
            before = {
                // Ignore direct views (e.g. the default main index page).
                if (!controllerName) return true
                // Access control by convention.
                // accessControl()
            }
            afterView = { e ->
                while (e && !(e instanceof AuthorizationException)) {
                    e = e.cause
                }


                if (e instanceof AuthorizationException) {
                    if (e instanceof UnauthenticatedException) {
                        // User is not authenticated, so redirect to the login page.
                        flash.message = "You need to be logged in to continue."
                        redirect(
                                controller: 'auth',
                                action: 'login',
                                params: [targetUri: request.forwardURI - request.contextPath])
                    } else {
                        redirect(controller: 'auth', action: 'unauthorized')
                    }
                } else {
                    log.debug("All seems to be fine")
                }
            }
        }
    }
}