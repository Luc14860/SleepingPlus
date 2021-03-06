package net.como89.sleepingplus.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.como89.sleepingplus.data.ManageData;
import net.como89.sleepingplus.data.SleepPlayer;


/**
 * @author como89
 * #French - Cette classe est appeller � toutes les secondes pour changer le taux de fatigue de tous les joueurs sur le serveur.
 * #English - This class is call every second to change the fatigue rate of all players on the server.
 */
public class TaskTimeNoSleep extends BukkitRunnable {

	private static boolean running = false;
	
	public TaskTimeNoSleep()
	{
	}

	@Override
	public void run() {
		if(!running)
		{
			running = true;
			for(Player player : Bukkit.getOnlinePlayers()){
				SleepPlayer sleepPlayer = ManageData.getSleepPlayer(player);
				if(sleepPlayer != null){
					if(sleepPlayer.isActive()){
					ManageData.addFatigue(sleepPlayer, false);
					}
				}
			}
			running = false;
		}
	}
	
	
}
