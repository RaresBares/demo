package de.revace.network.cloudsystem.cloudapi.player;

import java.util.UUID;

public class CloudPlayer {

    protected UUID uniqueId;

    protected String playerName;

    protected Boolean sessionVerified;

    protected Boolean onlineState;

    protected String permissionGroup;

    public CloudPlayer(UUID uniqueId, String playerName, Boolean sessionVerified, Boolean onlineState, String permissionGroup) {
        this.uniqueId = uniqueId;
        this.playerName = playerName;
        this.sessionVerified = sessionVerified;
        this.onlineState = onlineState;
        this.permissionGroup = permissionGroup;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setPermissionGroup(String permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setOnlineState(Boolean onlineState) {
        this.onlineState = onlineState;
    }

    public void setSessionVerified(Boolean sessionVerified) {
        this.sessionVerified = sessionVerified;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getPermissionGroup() {
        return permissionGroup;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getOnlineState() {
        return onlineState;
    }

    public Boolean getSessionVerified() {
        return sessionVerified;
    }
}
