// 
// Decompiled by Procyon v0.5.36
// 
package network;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.time.Instant;
import stpt.Client;
import stpt.ObjectData;
import stpt.Player;
import stpt.STPT;

public class GlobalMessageHalder {

    public static void onMessage(final Message msg, final Session_ME session) {
//        User user = null;
//        Char _char = null;
//        TileMap tileMap = null;
        if (msg != null) {
//            if (session.user != null) {
//                user = session.user;
//                if (session.user.player != null) {
//                    _char = session.user.player.getMyChar();
//                    tileMap = _char.tileMap;
//                }
//            }
            try {
                System.out.println("Send msg " + msg.getCommand());
                switch (msg.getCommand()) {
                    case -126:
                        byte type = msg.reader().readByte();
                        String nameP = msg.reader().readUTF();
                        byte cLass = msg.reader().readByte();
                        System.out.println("name Player " + nameP + " cLass " + cLass);

                        break;
                    case -10:
                        sendCheck_version_game_data(session);
                        break;
                    case -11:
                        byte data = msg.reader().readByte();

                        sendData(session, data);
                        System.out.println("-11 byte >>>>>> " + data);
                        break;
                    case -116:
                        byte zoomLevel = msg.reader().readByte();
                        byte device = msg.reader().readByte();
                        int ram = msg.reader().readInt();
                        String model = msg.reader().readUTF();
                        String imei = msg.reader().readUTF();
                        String version = msg.reader().readUTF();

                        System.out.println("Device Info:");
                        System.out.println("Zoom Level: " + zoomLevel);
                        System.out.println("Device: " + device);
                        System.out.println("RAM: " + ram);
                        System.out.println("Model: " + model);
                        System.out.println("IMEI: " + imei);
                        System.out.println("Version: " + version);
//                        sendMainCharInfo(session);
                        break;
                    case -118:
                        String name = msg.reader().readUTF();
                        String namsinh = msg.reader().readUTF();
                        String cmnd = msg.reader().readUTF();
                        String ngaycap = msg.reader().readUTF();
                        String noicap = msg.reader().readUTF();
                        String diachi = msg.reader().readUTF();
                        String sdt = msg.reader().readUTF();

                        // In ra các giá trị đã đọc
                        System.out.println("Name: " + name);
                        System.out.println("Nam Sinh: " + namsinh);
                        System.out.println("CMND: " + cmnd);
                        System.out.println("Ngay Cap: " + ngaycap);
                        System.out.println("Noi Cap: " + noicap);
                        System.out.println("Dia Chi: " + diachi);
                        System.out.println("SDT: " + sdt);
                        break;
                    case -119:
                        byte b = msg.reader().readByte();
                        if (b == 14 || b == 12 || b == 11 || b == 8 || b == 30 || b == 31 || b == 32 || b == 33) {
                            readLoadImageStr(msg, b, session);
                            break;
                        } else {
                            readLoadImage(msg, b, session);
                            break;
                        }
                    case 0:
                    case -122:
                        readLogin(msg, session);
                        break;
                    case -3:
                        message_SubCommand_Map(msg, session);
                        break;
                    case -2:
                        message_SubCommand_Global(msg, session);
                        break;

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (msg != null) {
                    msg.cleanup();
                }
            }
        }
    }

    private static void message_SubCommand_Map(final Message msg, final Session_ME session) {
        try {
            final byte b = msg.reader().readByte();
            Util.log("message_SubCommand_Map " + b);
            switch (b) {
                case 3:
                    short x = msg.reader().readShort();
                    short y = msg.reader().readShort();
                    short typeMove = msg.reader().readByte();
                    System.out.println("x "+x +" y "+ " typemove "+typeMove);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static void message_SubCommand_Global(final Message msg, final Session_ME session) {
        try {
            final byte b = msg.reader().readByte();
            System.err.println("message_SubCommand_Global " + b);
            switch (b) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    protected static void sendData(final Session_ME session, byte type) {
        Message msg = null;
        byte[] ab = null;
        try {
//             String filePath = "C:\\Users\\lapla\\Documents\\NetBeansProjects\\STPT\\data\\cache\\check_version_game_data";

            if (type != 21) {
                ab = STPT.getFile("C:\\Users\\lapla\\Documents\\NetBeansProjects\\STPT\\data\\getdata\\" + type);
            }

            if (session != null) {
//             FileInputStream fis = new FileInputStream(filePath);
//             DataInputStream dis = new DataInputStream(fis);
//             short x = dis.readShort();
//             short y = dis.readShort();
//             System.out.println("x>>>>>"+ x + " y >>>>> "+ y);

                msg = new Message((byte) -11);
                if (type == 21) {
                    System.out.println("vô đâyyyy nè");
                    msg.writer().writeByte(type);
                    msg.writer().writeLong(100);
                    session.sendMessage(msg);
                } else {
                    msg.writer().writeByte(type);
                    msg.writer().write(ab);
                    session.sendMessage(msg);
                }

//                msg.cleanup();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public static void sendMsg_Ao(final Session_ME session) {
        Message m = null;
        try {
            final byte[] data = STPT.getFile("data/update_menuNPC");
            m = new Message(-123);
            m.writer().write(data);
            session.sendMessage(m);
            m.cleanup();
            System.out.println("Send Message Ao>> " + -123);
        } catch (IOException ex) {
            System.err.println("Error reading load image: " + ex.toString());
        }
    }

    public static void sendMsg_SubCommand_Global(Session_ME session, byte b) {

        Message m = null;
        try {
            final byte[] data = STPT.getFile("data/msg-2/" + b);

            m = new Message(-2);
            m.writer().writeByte(b);
            m.writer().write(data);
            session.sendMessage(m);
            m.cleanup();
            System.out.println("Send Message Ao>> " + b);
        } catch (IOException ex) {
            System.err.println("Error reading load image: " + ex.toString());
        }
    }

    public static void sendMsg_SubCommand_Map(final Session_ME session, final byte b) {
        Message m = null;
        try {
            final byte[] data = STPT.getFile("data/msg-3/" + b);
            m = new Message(-3);
            m.writer().writeByte(b);
            m.writer().write(data);
            session.sendMessage(m);
            m.cleanup();
            System.out.println("Send Message Ao>> " + b);
        } catch (IOException ex) {
            System.err.println("Error reading load image: " + ex.toString());
        }
    }

    private static void sendKiemduyet(Session_ME session) {
        Message m = new Message(-118);
        try {
            m.writer().writeByte((byte) 0);
            session.sendMessage(m);

        } catch (IOException ex) {
            System.err.println("Error reading kiem duyet info: " + ex.toString());
        }

    }

    protected static void sendCheck_version_game_data(final Session_ME session) {
        Message msg = null;
        try {
//             String filePath = "C:\\Users\\lapla\\Documents\\NetBeansProjects\\STPT\\data\\cache\\check_version_game_data";
            final byte[] ab = STPT.getFile("C:\\Users\\lapla\\Documents\\NetBeansProjects\\STPT\\data\\cache\\check_version_game_data");
            if (ab != null) {
//             FileInputStream fis = new FileInputStream(filePath);
//             DataInputStream dis = new DataInputStream(fis);
//             short x = dis.readShort();
//             short y = dis.readShort();
//             System.out.println("x>>>>>"+ x + " y >>>>> "+ y);
                msg = new Message((byte) -10);
                STPT.writeByteArray(msg, ab);
                session.sendMessage(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static void sendNotify_mess(Session_ME session) {
        Message m = new Message(-120);
        try {
            m.writer().writeByte(2);
            m.writer().writeUTF("Chào admin Lee Fất Đẹp Troai Khoai Bự Ahihi");
            session.sendMessage(m);
        } catch (IOException ex) {
            System.err.println("Error reading notify info: " + ex.toString());
        }

    }

    private static void readLogin(Message m, Session_ME session) {
        try {
            String user = m.reader().readUTF();
            String pass = m.reader().readUTF();
//            m.cleanup();
            m = new Message(0);
            m.writer().writeBoolean(false);
            m.writer().writeByte(1);

            session.sendMessage(m);
            
            sendMainCharInfo(session);
            sendMsg_SubCommand_Global(session, (byte) 17);
            sendMsg_SubCommand_Global(session, (byte) 2);
            sendMsg_SubCommand_Global(session, (byte) 1);
            sendMsg_SubCommand_Global(session, (byte) 3);
            sendMsg_SubCommand_Global(session, (byte) 34);
            sendMsg_SubCommand_Map(session, (byte) 8);
            sendMsg_SubCommand_Global(session, (byte) 23);
            sendMsg_SubCommand_Map(session, (byte) 1);
            sendMsg_SubCommand_Map(session, (byte) 26);
            sendMsg_SubCommand_Map(session, (byte) 26);
            sendMsg_SubCommand_Map(session, (byte) 26);
            sendMsg_SubCommand_Map(session, (byte) 26);
            sendMsg_SubCommand_Map(session, (byte) 37);
            sendMsg_SubCommand_Map(session, (byte) 27);
            sendMsg_SubCommand_Global(session, (byte) 28);
            sendMsg_SubCommand_Global(session, (byte) 37);
            sendMsg_Ao(session);
            sendNotify_mess(session);
            System.out.println("Login:");
            System.out.println("User: " + user);
            System.out.println("Password: " + pass);

        } catch (IOException ex) {
            System.err.println("Error reading login info: " + ex.toString());
        }
    }
    

//    public static void sendMainCharInfo(Session_ME session) {
//        byte[] data = null;
//        Message m = null;
//        try {
//            data = STPT.getFile("data/mainCharInfo");
//            m = new Message(-124);
//            m.writer().write(data);
//            session.sendMessage(m);
//
//            System.out.println("Send Nhan Vat Oke");
//        } catch (IOException ex) {
//            System.err.println("Error reading load image: " + ex.toString());
//        }
//    }

    private static void readLoadImage(Message m, byte type, Session_ME session) {
        byte[] data = null;
        try {
            int id = m.reader().readShort();
            data = STPT.getFile("data/img/x2/typeImg_" + ObjectData.getIdImg(type) + id + ".png");
            m = new Message(-119);
            m.writer().writeByte(type);
            m.writer().writeShort(id);
            m.writer().write(data);
//        STPT.writeByteArray(m, data);
            session.sendMessage(m);
            System.out.println("Load Image:");
            System.out.println("Type: " + type + " id " + id);
        } catch (IOException ex) {
            System.err.println("Error reading load image: " + ex.toString());
        }

    }

    private static void readLoadImageStr(Message m, byte type, Session_ME session) {
        byte[] data = null;
        try {
            String patch = m.reader().readUTF();
            String numberStr = patch.replaceAll("\\D+", "");
            int id = Integer.parseInt(numberStr);
            data = STPT.getFile("data/img/x2/img_string/typeImg_" + ObjectData.getIdImg(type) + id + ".png");
            m = new Message(-119);
            m.writer().writeByte(type);
            m.writer().writeUTF(patch);
            m.writer().write(data);
//        STPT.writeByteArray(m, data);
            session.sendMessage(m);
            System.out.println("Load Image:");
            System.out.println("Type: " + type + " patch " + patch);
        } catch (IOException ex) {
            System.err.println("Error reading load image: " + ex.toString());
        }
    }

    public static void sendMainCharInfo(Session_ME session) {
        try {
            // Gửi thông tin của nhân vật chính\
            Player player = new Player(session,"admin",1);

            Message m = new Message(-124);
            m.writer().writeInt(player.getID());
            m.writer().writeUTF(player.getName());
            m.writer().writeByte(player.getIdClass());
            m.writer().writeShort(player.getX());
            m.writer().writeShort(player.getY());
            m.writer().writeByte(player.getGender());
            m.writer().writeShort(player.getHead());
            m.writer().writeShort(player.getHair());
            m.writer().writeShort(player.getHat());
            m.writer().writeShort(player.getBody());
            m.writer().writeShort(player.getCloak());
            m.writer().writeShort(player.getWeapon());
            m.writer().writeByte(player.effectPart.length);
            for (int i = 0; i < player.effectPart.length; i++) {
            m.writer().writeShort(player.effectPart[i]);
            }
            m.writer().writeShort(player.getLv());
            m.writer().writeShort(player.getPercent());
            m.writer().writeByte(player.getMili_lv());
            m.writer().writeInt(player.getHp());
            m.writer().writeInt(player.getMaxhp());
            m.writer().writeInt(player.getMp());
            m.writer().writeInt(player.getMaxmp());
            m.writer().writeByte(player.getTypePk());
            m.writer().writeShort(player.getPkPoint());
            m.writer().writeInt(player.getPvpPoint());
            m.writer().writeShort(player.getCooldownIncrease());
            m.writer().writeShort(player.getCooldownReduction_Skill());
            m.writer().writeShort(player.getOverpowerMax());
            m.writer().writeShort(player.getOverpowerPoint());
            m.writer().writeByte(player.getMaxInventory());
            m.writer().writeByte(player.getMaxChest());
            m.writer().writeShort(player.getHoatdongPoint());
            m.writer().writeByte(player.getLevelMainStory());

            // Gửi message đi
            session.sendMessage(m);
        } catch (Exception ex) {
            System.err.println("Error sending main char info: " + ex.toString());
        }
    }

    private static void messageNotLogin(final Message msg, final Session_ME session) {
        try {
            final byte b = msg.reader().readByte();
            Util.log("messageNotLogin " + b);
            switch (b) {
//                case -127: {
//                    if (!session.login) {
//                        Service.ClearCache(session);
//                        final String uname = msg.reader().readUTF();
//                        final String passw = msg.reader().readUTF();
//                        final String version = msg.reader().readUTF();
//                        final String t1 = msg.reader().readUTF();
//                        final String packages = msg.reader().readUTF();
//                        final String random = msg.reader().readUTF();
//                        final byte sv = msg.reader().readByte();
//                        msg.cleanup();
//                        final User user = User.Login(session, uname, passw);
//                        if (user != null) {
//                            session.user = user;
//                            session.login = true;
//                            Service.requestLogin(session);
//                            session.setDelayOut(120000, false);
//                            Util.log("Login Sucessfully " + uname + " passs " + passw);
//                        } else {
//                            Util.log("Login Faild " + uname + " passs " + passw);
//                        }
//                        session.versionNja = version;
//                        break;
//                    }
//                    Service.ClearCache(session);
//                    session.setDelayOut(10, true);
//                    break;
//                }
//                case -125: {
//                    if (!session.login) {
//                        session.client_type = msg.reader().readByte();
//                        session.zoomLevel = msg.reader().readByte();
//                        session.isGPS = msg.reader().readBoolean();
//                        session.width = msg.reader().readInt();
//                        session.height = msg.reader().readInt();
//                        session.isQwert = msg.reader().readBoolean();
//                        session.isTouch = msg.reader().readBoolean();
//                        session.plastfrom = msg.reader().readUTF();
//                        session.versionIp = msg.reader().readInt();
//                        msg.reader().readByte();
//                        session.languageId = msg.reader().readByte();
//                        session.provider = msg.reader().readInt();
//                        session.agent = msg.reader().readUTF();
//                        Util.log("Client type " + session.client_type + " zoomlevel " + session.zoomLevel + " width " + session.width + " height " + session.height);
//                        break;
//                    }
//                    break;
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static void messageNotMap(final Message msg) {
        try {
            final byte b = msg.reader().readByte();
            System.out.println("messageNotMap " + b);
            switch (b) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }
}
