package default_set.bot_settings;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import support_classes.Support;

import java.nio.charset.StandardCharsets;

public class Command {
    protected final String commandName;
    protected String buttonText;
    protected String commandResultText;
    protected final String parentCommand;

    public Command(String commandName, String buttonText, String commandResultText, String parentCommand) {
        this.commandName = commandName;
//        this.buttonText = buttonText;
        this.buttonText = new String(buttonText.getBytes(), StandardCharsets.UTF_8);
        this.commandResultText = commandResultText;
        this.parentCommand = parentCommand;
    }

    public String getCommandName() {
        return commandName;
    }
    public String getParentCommand() {
        return parentCommand;
    }


//USELESSPART
//    public void setButtonText(String buttonText) {
//        this.buttonText = buttonText;
//    }
//
//    public void setCommandResultText(String commandResultText) {
//        this.commandResultText = commandResultText;
//    }

    public boolean canExecute (String commandName) {
        return  this.commandName.equalsIgnoreCase(commandName);
    }

    public  InlineKeyboardButton getButton () {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(commandName);
        return button;
    }

}
