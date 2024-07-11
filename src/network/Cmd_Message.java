package network;

import java.io.IOException;

public class Cmd_Message
{
	

	protected Message m;

	public byte GET_SESSION_ID = -27;

	public byte DISCONNECT_WHY = -127;

	public byte CREATE_CHAR = -126;

	public byte SELECT_CHAR = -125;

	public byte ME_LOAD_INFO = -124;

	public byte UPDATE_MENU_NPC = -123;

	public byte REGISTER_TEMP = -122;

	public byte LOAD_MONSTER_DATA = -121;

	public byte NOTIFY_MESSAGE = -120;

	public byte LOAD_IMAGE = -119;

	public byte KIEM_DUYET = -118;

	public byte INPUT_DIALOG = -117;

	public byte DEVICE_INFO = -116;

	public byte SHOW_MENU = -115;

	public byte ME_UPDATE_INFO = -114;

	public byte LOAD_IMAGE_BIG = -113;

	public byte NHANQUAHANGNGAY = -112;

	public byte UPGRADE = -111;

	public byte CHAR_LIST = -12;

	public byte GET_DATA = -11;

	public byte CHECK_VERSION_GAME_DATA = -10;

	public byte DIALOG_SERVER = -9;

	public byte SUB_COMMAND_MAP = -3;

	public byte SUB_COMMAND_GLOBAL = -2;

	public byte SUBCOMMAND = -1;

	public byte LOGIN = 0;

	public byte REGISTER = 6;

	public byte CMD_GET_TEMPLATE = 7;

	public byte GPS = 8;

	public byte PURCHASE_MESSAGE = 9;

	public byte EFFECT_AUTO = 10;

	public byte CHANGE_MAP = 1;

	public byte OTHER_PLAYER_INFO = 2;

	public byte OBJ_MOVE = 3;

	public byte OBJ_REMOVE = 4;

	public byte ACCEP_CHANGE_MAP = 5;

	public byte ATTACK = 6;

	public byte PLAYER_CHAT = 7;

	public byte PLAYER_UPDATE_PART = 8;

	public byte DROP_ITEM = 12;

	public byte PLAYER_RESET_POINT = 21;

	public byte OBJ_DIE = 22;

	public byte NOTIFY_RESPAWN = 23;

	public byte PLAYER_FLAG = 25;

	public byte PLAYER_SKILL_BUFF = 26;

	public byte ADD_OBJECT_IN_MAP = 27;

	public byte PLAYER_PICK_OBJ = 28;

	public byte PLAYER_JOIN_MAP_XEPHU = 29;

	public byte PLAYER_DIE = 30;

	public byte ELITE_MON = 31;

	public byte COLOR_HP_MON = 32;

	public byte ATTACK_SPEC = 33;

	public byte MONSTER_INFO = 34;

	public byte LUCKYJAR = 35;

	public byte BENTAU = 36;

	public byte MOUNT = 37;

	public byte GLOBAL_PLAYER_SKILL_INFO = 1;

	public byte GLOBAL_PLAYER_INVENTORY = 2;

	public byte GLOBAL_PLAYER_ALL_ATTRIBUTE = 3;

	public byte GLOBAL_SELL_ITEM = 4;

	public byte GLOBAL_SERVER_REWARD = 7;

	public byte GLOBAL_UPGRADE_SKILL = 8;

	public byte GLOBAL_OPEN_SHOP = 11;

	public byte GLOBAL_JOIN_MAP = 12;

	public byte GLOBAL_LIST_MAP = 13;

	public byte GLOBAL_CAPTCHA = 14;

	public byte GLOBAL_QUEST = 17;

	public byte GLOBAL_DIALOG_NPC = 20;

	public byte GLOBAL_INTERACT_NPC = 21;

	public byte GLOBAL_UPDATE_MONEY = 22;

	public byte GLOBAL_UPDATE_HP_MP = 23;

	public byte GLOBAL_UPDATE_XP = 24;

	public byte GLOBAL_PVP = 25;

	public byte GLOBAL_UPDATE_PVP = 26;

	public byte GLOBAL_UPDATE_MAX_MP_HP = 27;

	public byte GLOBAL_CLAN = 28;

	public byte GLOBAL_CLAN_INVEN = 29;

	public byte GLOBAL_PLAYER_OVERPOWER = 30;

	public byte GLOBAL_ENCHANT_STONE = 31;

	public byte GLOBAL_LIST_PLAYER_DIALOG = 32;

	public byte GLOBAL_PLAYER_INFO_DIALOG = 33;

	public byte GLOBAL_CHATSELL = 34;

	public byte GLOBAL_PHUBANG_INFO = 35;

	public byte GLOBAL_PLAYER_CHEST = 36;

	public byte GLOBAL_LIST_FRIEND = 37;

	public byte GLOBAL_SERVER_BUFF = 38;

	public byte GLOBAL_CHAT_SYSTEM = 40;

	public byte GLOBAL_SAOTHAN = 41;

	
}
