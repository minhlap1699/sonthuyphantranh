// 
// Decompiled by Procyon v0.5.36
// 

package network;

public interface ISession
{
    boolean isConnected();
    
    void sendMessage(final Message p0);
    
    void close();
}
