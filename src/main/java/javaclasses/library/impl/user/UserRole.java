package javaclasses.library.impl.user;

import static javaclasses.library.impl.user.UserPermission.*;

public enum UserRole {
    VISITOR,
    LIBRARIAN(CREATE_AUTHOR),
    ADMIN(CREATE_USER);

    private UserPermission[] permissions;

    UserRole(UserPermission... permissions){
        this.permissions = permissions;
    }

    public UserPermission[] getPermissions() {
        return permissions;
    }
}
