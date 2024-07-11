/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stpt;

import java.io.DataInputStream;
import java.io.FileInputStream;
import network.Message;
import network.Session_ME;
import sun.applet.Main;

/**
 *
 * @author lapla
 */
public class loadData {
    private static short[] readArrEffectPart(DataInputStream iss)
    {
        try {
        short[] array = new short[] { -1, -1, -1, -1, -1, -1 };
	byte b = iss.readByte();
	array = new short[b];
	for (int i = 0; i < b; i++)
	{
		array[i] = iss.readShort();
	}
	return array;    
        } catch (Exception e) {
        }
        return null;
	
    }
    protected static void sendData(byte type, Player player) {
        Message msg = null;
        try {
            String filePath = "data/mainCharInfo";
//            final byte[] ab = STPT.getFile("C:\\Users\\lapla\\Documents\\NetBeansProjects\\STPT\\data\\getdata\\"+type);
//            if (ab != null) {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream iss = new DataInputStream(fis);
                int iD = iss.readInt();
                String text = iss.readUTF();
                byte idClass = iss.readByte();
                short num = iss.readShort();
                short num2 = iss.readShort();
                byte gender = iss.readByte();
                short head = iss.readShort();
                short hair = iss.readShort();
                short hat = iss.readShort();
                short body = iss.readShort();
                short cloak = iss.readShort();
                short weapon = iss.readShort();
                short[] effectPart = readArrEffectPart(iss);
                short lv = iss.readShort();
                short percent = iss.readShort();
                byte mili_lv = iss.readByte();
                int hp = iss.readInt();
                int maxhp = iss.readInt();
                int mp = iss.readInt();
                int maxmp = iss.readInt();
                byte typePk = iss.readByte();
                short pkPoint = iss.readShort();
                int pvpPoint = iss.readInt();
                short cooldownIncrease = iss.readShort();
                short cooldownReduction_Skill = iss.readShort();
                short overpowerMax = iss.readShort();
                short overpowerPoint = iss.readShort();
                byte maxInventory = iss.readByte();
                byte maxChest = iss.readByte();
                short hoatdongPoint = iss.readShort();
                byte levelMainStory = iss.readByte();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public static void main(final String[] args) {
//        GameScr.init();
       
    }
}
