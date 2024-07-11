package stpt;

import network.Session_ME;

public class Player {

    public int ID;
    public String name;
    public byte idClass;
    public short x;
    public short y;
    public byte gender;
    public short head;
    public short hair;
    public short hat;
    public short body;
    public short cloak;
    public short weapon;
    public short[] effectPart;
    public short level;
    public short percent;
    public byte mili_lv;
    public int hp;
    public int maxhp;
    public int mp;
    public int maxmp;
    public byte typePk;
    public short pkPoint;
    public int pvpPoint;
    public short cooldownIncrease;
    public short cooldownReduction_Skill;
    public short overpowerMax;
    public short overpowerPoint;
    public byte maxInventory;
    public byte maxChest;
    public short hoatdongPoint;
    public byte levelMainStory;
    public String userName;

    public Player(Session_ME session, String name, int id) {
        this.name = name;
        this.ID = id;
        this.x = 26;
        this.y = 208;
        this.gender = 0;
        this.head = 0;
        this.hair = 2;
        this.hat = -1;
        this.body = 212;
        this.cloak = -1;
        this.weapon = 9;
        this.effectPart = new short[]{-1, -1, -1, -1, -1, -1};
        this.level = 0;
        this.percent = 0;
        this.mili_lv = 0;
        this.hp = 360;
        this.maxhp = 388;
        this.mp = 100;
        this.maxmp = 120;
        this.typePk = -1;
        this.typePk = -1;
        this.pkPoint = 0;
        this.pvpPoint = 0;
        this.cooldownIncrease = 0;
        this.cooldownReduction_Skill = 0;
        this.overpowerMax = 10000;
        this.overpowerPoint = 0;
        this.maxInventory = 30;
        this.maxChest = 30;
        this.hoatdongPoint = 0;
        this.levelMainStory = 1;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getIdClass() {
        return idClass;
    }

    public void setIdClass(byte idClass) {
        this.idClass = idClass;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public short getHead() {
        return head;
    }

    public void setHead(short head) {
        this.head = head;
    }

    public short getHair() {
        return hair;
    }

    public void setHair(short hair) {
        this.hair = hair;
    }

    public short getHat() {
        return hat;
    }

    public void setHat(short hat) {
        this.hat = hat;
    }

    public short getBody() {
        return body;
    }

    public void setBody(short body) {
        this.body = body;
    }

    public short getCloak() {
        return cloak;
    }

    public void setCloak(short cloak) {
        this.cloak = cloak;
    }

    public short getWeapon() {
        return weapon;
    }

    public void setWeapon(short weapon) {
        this.weapon = weapon;
    }

    public short[] getEffectPart() {
        return effectPart;
    }

    public void setEffectPart(short[] effectPart) {
        this.effectPart = effectPart;
    }

    public short getLv() {
        return level;
    }

    public void setLv(short lv) {
        this.level = lv;
    }

    public short getPercent() {
        return percent;
    }

    public void setPercent(short percent) {
        this.percent = percent;
    }

    public byte getMili_lv() {
        return mili_lv;
    }

    public void setMili_lv(byte mili_lv) {
        this.mili_lv = mili_lv;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxmp() {
        return maxmp;
    }

    public void setMaxmp(int maxmp) {
        this.maxmp = maxmp;
    }

    public byte getTypePk() {
        return typePk;
    }

    public void setTypePk(byte typePk) {
        this.typePk = typePk;
    }

    public short getPkPoint() {
        return pkPoint;
    }

    public void setPkPoint(short pkPoint) {
        this.pkPoint = pkPoint;
    }

    public int getPvpPoint() {
        return pvpPoint;
    }

    public void setPvpPoint(int pvpPoint) {
        this.pvpPoint = pvpPoint;
    }

    public short getCooldownIncrease() {
        return cooldownIncrease;
    }

    public void setCooldownIncrease(short cooldownIncrease) {
        this.cooldownIncrease = cooldownIncrease;
    }

    public short getCooldownReduction_Skill() {
        return cooldownReduction_Skill;
    }

    public void setCooldownReduction_Skill(short cooldownReduction_Skill) {
        this.cooldownReduction_Skill = cooldownReduction_Skill;
    }

    public short getOverpowerMax() {
        return overpowerMax;
    }

    public void setOverpowerMax(short overpowerMax) {
        this.overpowerMax = overpowerMax;
    }

    public short getOverpowerPoint() {
        return overpowerPoint;
    }

    public void setOverpowerPoint(short overpowerPoint) {
        this.overpowerPoint = overpowerPoint;
    }

    public byte getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(byte maxInventory) {
        this.maxInventory = maxInventory;
    }

    public byte getMaxChest() {
        return maxChest;
    }

    public void setMaxChest(byte maxChest) {
        this.maxChest = maxChest;
    }

    public short getHoatdongPoint() {
        return hoatdongPoint;
    }

    public void setHoatdongPoint(short hoatdongPoint) {
        this.hoatdongPoint = hoatdongPoint;
    }

    public byte getLevelMainStory() {
        return levelMainStory;
    }

    public void setLevelMainStory(byte levelMainStory) {
        this.levelMainStory = levelMainStory;
    }

}
