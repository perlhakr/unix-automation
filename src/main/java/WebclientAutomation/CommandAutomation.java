package WebclientAutomation;
import java.io.*;
import java.util.*;

public class CommandAutomation implements ICommandAutomation {
	private ArrayList<String> _cmdResponses;
	private String _cmdPath;
	private ArrayList<String> _cmdArguments;
	private Boolean _validCommand = false;
	
	
	public CommandAutomation()
	{
        //
        // set up or clear command response buffer.
        //
        _cmdResponses = new ArrayList<String>();		
	}
	
	public ArrayList<String> GetCommandResponses()
	{
		return _cmdResponses;
	}
	
	public Boolean RunCommand(String commandText)
	{
		Boolean blnRet = true;
		try
		{
			_cmdResponses = RunExternalCommand(commandText);
		}
		catch(Exception ex)
		{
			blnRet = false;
		}
		return blnRet;
	}
	
	public Boolean RunCommand(String commandText, List<String> _arguments)
	{
		return false;
	}
	
	private ArrayList<String> RunExternalCommand(String commandText) throws IOException
	{
        Process proc = null;
        //
        // set up or clear command response buffer.
        //
        _cmdResponses.clear();
        //
        // perform execution.
        //
        try {
            proc = Runtime.getRuntime().exec(commandText);
        } catch (IOException e1) {
            System.out.println( "IOException thrown on command execute" );
            throw e1;
        }
        //
        // pull response text.
        //
        BufferedInputStream buffer = new BufferedInputStream( proc.getInputStream() );
        BufferedReader commandOutput= new BufferedReader( new InputStreamReader( buffer ) );
        String line = null;
        try {
            while ( ( line = commandOutput.readLine() ) != null ) {
                System.out.println( line );
            }
            commandOutput.close(); 
        } catch ( IOException e) {
            System.out.println( "IOException thrown on read input" );
            throw e;
        }		
        //
        // return true if no exceptions.
        //
        return _cmdResponses;
	}
}
