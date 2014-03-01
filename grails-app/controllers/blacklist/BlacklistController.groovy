package blacklist

import org.apache.shiro.authz.annotation.RequiresRoles

@RequiresRoles('ROLE_ADMIN')
class BlacklistController {
    static scaffold = true
}
