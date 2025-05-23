package com.mentalfrostbyte.jello.command.impl;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.command.Command;
import com.mentalfrostbyte.jello.managers.util.command.ChatCommandArguments;
import com.mentalfrostbyte.jello.managers.util.command.ChatCommandExecutor;
import com.mentalfrostbyte.jello.managers.util.command.CommandException;
import net.minecraft.client.Minecraft;

public class HighDPI extends Command {
    public HighDPI() {
        super("highdpi", "Toggles macOS HiDPI, Needs mc restart.", "hidpi");
    }

    @Override
    public void run(String var1, ChatCommandArguments[] args, ChatCommandExecutor executor) throws CommandException {
        if (args.length <= 0) {
            if (Minecraft.IS_RUNNING_ON_MAC) {
                if (!Client.getInstance().guiManager.getHidpiCocoa()) {
                    executor.send("HighDPI was enabled!");
                } else {
                    executor.send("HighDPI was disabled!");
                }

                Client.getInstance().guiManager.setHidpiCocoa(!Client.getInstance().guiManager.getHidpiCocoa());
            } else {
                throw new CommandException("This feature is only available on macOS!");
            }
        } else {
            throw new CommandException("Too many arguments");
        }
    }
}