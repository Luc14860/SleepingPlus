package net.como89.sleepingplus.data;

public class MsgLang {

	
	public static String [] french = {"Vous avez activer le plugin pour vous.","Vous avez d�sactiver le plugin pour vous.",
		"Vous n'avez pas la permission pour cette commande.","La config est maintenant reload.","Vous n'�tes moins fatigu� maintenant."};
	public static String [] english = {"You activate the plugin for you.","You have disabled the plugin for you.",
		"You do not have permission for this command.","The config is now reload.","You're less tired now."};
	
	public static String getMsg(int index,String lang)
	{
		if(lang.equals("French"))
		{
			return french[index];
		}
		if(lang.equals("English"))
		{
			return english[index];
		}
		return null;
	}
}
