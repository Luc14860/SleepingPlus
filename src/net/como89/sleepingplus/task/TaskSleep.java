package net.como89.sleepingplus.task;

import java.util.Collection;

import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import net.como89.sleepingplus.SleepingPlus;
import net.como89.sleepingplus.data.FileManager;
import net.como89.sleepingplus.data.ManageData;
import net.como89.sleepingplus.data.MsgLang;
import net.como89.sleepingplus.data.SleepPlayer;

/**
 * @author como89
 * #French - Cette classe g�re lorsqu'un joueur entre dans un lit. Il v�rifie s'il est toujours dans le lit avant d'enlever les effets de potions et de mettre � z�ro son taux de fatigue.
 * #English - This class handles when a player enters a bed. It checks if it is still in the bed before removing the effects of potions and to zero the rate of fatigue.
 */
public class TaskSleep extends BukkitRunnable {

	private SleepPlayer sleepPlayer;
	
	public TaskSleep(SleepPlayer sleepPlayer)
	{
		this.sleepPlayer = sleepPlayer;
	}
	
	@Override
	public void run() {
		if(sleepPlayer.isInBed() && sleepPlayer.getFatigueRate() > 0)
		{
			Collection<PotionEffect> listEffect = sleepPlayer.getPlayer().getActivePotionEffects();
			for(PotionEffect potionE : listEffect)
			{
				sleepPlayer.getPlayer().removePotionEffect(potionE.getType());
			}
			ManageData.actualiseTime(sleepPlayer, 0);
			new FileManager(sleepPlayer).saveData();
			sleepPlayer.getPlayer().sendMessage(ChatColor.GREEN + "[SleepingPlus] - " + MsgLang.getMsg(4, SleepingPlus.getLangage()));
		}
	}

}