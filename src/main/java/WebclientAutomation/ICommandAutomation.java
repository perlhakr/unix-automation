package WebclientAutomation;

import java.util.ArrayList;
import java.io.*;

public interface ICommandAutomation {
	public ArrayList<String> GetCommandResponses();
	public Boolean RunCommand(String commandText);
}
