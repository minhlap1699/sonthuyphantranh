/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stpt;

/**
 *
 * @author lapla
 */
public class ObjectData {
    public static String getIdImg(byte type){
        switch(type){
            case 0:
            return "0_/";
            case 1:
            return "1_monster/";
            case 2:
            return "2_potion/";
            case 3:
            return "3_item/";
            case 4:
            return "4_skill_active/";
            case 5:
            return "5_skill_active_focus/";
            case 6:
            return "6_skill_passive/";
            case 7:
            return "7_npc/";
            case 8:
            return "8_animate/";
            case 9:
            return "9_questitem/";
            case 13:
            return "13_charpart/";
            case 15:
            return "15_misc/";
        }
        return null;
    }
}
