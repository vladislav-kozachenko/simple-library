package javaclasses.library.impl.user;

public enum UserRole {
    VISITOR,
    LIBRARIAN,
    ADMIN;

    private UserPermission[] permissions;

    private UserRole(UserPermission... permissions){
        this.permissions = permissions;
    }

    public UserPermission[] getPermissions() {
        return permissions;
    }
}
