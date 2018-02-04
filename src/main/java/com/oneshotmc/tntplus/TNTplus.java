package main.java.com.oneshotmc.tntplus;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import main.java.com.oneshotmc.tntplus.commands.TntClear;
import main.java.com.oneshotmc.tntplus.listeners.DispenseListener;
import main.java.com.oneshotmc.tntplus.listeners.DispenserBreakListener;
import main.java.com.oneshotmc.tntplus.tntfiller.TNTfiller;
import main.java.com.oneshotmc.tntrecorder.RecordManager;
import main.java.com.oneshotmc.tntrecorder.TntRecorder;

public class TNTplus extends JavaPlugin{
	public ProtocolManager protocolManager;
	@Override
	public void onEnable(){
		TntRecorder.setMainPlugin(this);
		protocolManager = ProtocolLibrary.getProtocolManager();
		this.getCommand("tntfill").setExecutor(new TNTfiller(this));
		getLogger().info("TNTplus has been enabled");
		new DispenserBreakListener(this);
		new DispenseListener(this);
		this.getCommand("tntclear").setExecutor(new TntClear(this));
		RecordManager.addNessassaryPlayers();
	}
	@Override
	public void onDisable(){
		getLogger().info("TNTplus has been disabled");
	}
}
