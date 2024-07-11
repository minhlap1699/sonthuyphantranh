// 
// Decompiled by Procyon v0.5.36
// 

package stpt;

import network.Message;
import java.util.ArrayList;
import network.Session_ME;
import network.Util;

public class Client
{
    protected static int sizeClients;
    protected static final ArrayList<Session_ME> clients;
    protected static final Object LOCK;
    
    protected static void chatServer(final String whochat, final String chat) {
        try {
            final Message msg = new Message((byte)(-21));
            try {
                msg.writer().writeUTF(whochat);
                msg.writer().writeUTF(chat);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).player != null && Client.clients.get(i).player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void alertServer(final String str) {
        try {
            final Message msg = new Message((byte)(-25));
            try {
                msg.writer().writeUTF(str);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).player != null && Client.clients.get(i).player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void startOKDlgServer(final String info) {
        try {
            final Message msg = new Message((byte)(-26));
            try {
                msg.writer().writeUTF(info);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).player != null && Client.clients.get(i).player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void joinClient(final Session_ME cl) {
        synchronized (Client.LOCK) {
            if (!Client.clients.contains(cl)) {
                Client.clients.add(cl);
                ++Client.sizeClients;
            }
        }
    }
    
    public static void removeClinet(final Session_ME cl) {
        synchronized (Client.LOCK) {
            if (Client.clients.contains(cl)) {
                Client.clients.remove(cl);
                --Client.sizeClients;
                Util.log("Disconnect client: " + cl);
            }
        }
    }
    
    protected static int sizeUser() {
        int size = 0;
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).player != null) {
                    ++size;
                }
            }
        }
        return size;
    }
    
    protected static Player getPlayer(final String cName) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).player != null && Client.clients.get(i).player != null && Client.clients.get(i).player != null && Client.clients.get(i).player.name.equals(cName)) {
                    return Client.clients.get(i).player;
                }
            }
        }
        return null;
    }
    
    protected static Player getPlayer(final int charID) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).player != null && Client.clients.get(i).player != null && Client.clients.get(i).player != null && Client.clients.get(i).player.ID == charID) {
                    return Client.clients.get(i).player;
                }
            }
        }
        return null;
    }
    
    protected static Player getUser(final String uname) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).player != null && Client.clients.get(i).player.userName.equals(uname)) {
                    return Client.clients.get(i).player;
                }
            }
        }
        return null;
    }
    
    static {
        clients = new ArrayList<Session_ME>();
        LOCK = new Object();
    }
}
