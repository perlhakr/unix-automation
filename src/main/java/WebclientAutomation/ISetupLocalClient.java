package WebclientAutomation;

public interface ISetupLocalClient {
	public Boolean CreateClientPGPKeys();
	public Boolean GenerateRsyncCryptoKeys();
	public Boolean SetupLocalUser();
	public Boolean SetupSshLoginKeys();
	public Boolean SetupRsyncServer();
	public Boolean RunAptGetAutomationForClientSetup();
}
