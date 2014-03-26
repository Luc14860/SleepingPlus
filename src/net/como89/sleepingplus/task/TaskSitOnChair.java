package net.como89.sleepingplus.task;

import java.util.Collection;

import net.como89.sleepingplus.data.FileManager;
import net.como89.sleepingplus.data.ManageData;
import net.como89.sleepingplus.data.MsgLang;
import net.como89.sleepingplus.data.SleepPlayer;

import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author como89
 * #French - Cette classe g�re lorsqu'un joueur s'assit sur une chaise. Il v�rifie s'il est toujours sur la chaise avant d'enlever les effets de potions et de mettre � z�ro son taux de fatigue.
 * #English - This class handles when a player sat on a chair. It checks if it is still on the chair before removing the effects of potions and to zero the rate of fatigue.
 */
public class TaskSitOnChair extends BukkitRunnable{

	private SleepPlayer sleepPlayer;
	
	public TaskSitOnChair(SleepPlayer sleepPlayer){
		this.sleepPlayer = sleepPlayer;
	}
	
	@Override
	public void run() {
		if(sleepPlayer.isSitOnChair() && sleepPlayer.getFatigueRate() > 0){
			Collection<PotionEffect> listEffect = sleepPlayer.getPlayer().getActivePotionEffects();
			for(PotionEffect potionE : listEffect)
			{
				sleepPlayer.getPlayer().removePotionEffect(potionE.getType());
			}
			ManageData.actualiseTime(sleepPlayer, 0);
			new FileManager(sleepPlayer).saveData();
			sleepPlayer.getPlayer().sendMessage(ChatColor.GREEN + "[SleepingPlus] - " + MsgLang.getMsg(4));
		}
	}

}
