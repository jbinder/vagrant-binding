package com.guigarage.vagrant.configuration.builder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.guigarage.vagrant.configuration.PuppetProvisionerConfig;
import com.guigarage.vagrant.configuration.VagrantPortForwarding;
import com.guigarage.vagrant.configuration.VagrantVmConfig;
import com.guigarage.vagrant.configuration.builder.util.VagrantBuilderException;

public class VagrantVmConfigBuilder {

private List<VagrantPortForwarding> portForwardings;
	
	private PuppetProvisionerConfig puppetProvisionerConfig;
	
	private String name;

	private String ip;
	
	private String boxName;
	
	private String boxUrl;
	
	private String hostName;
	
	private boolean guiMode;

    private String additionalConfig;

    public VagrantVmConfigBuilder() {
		portForwardings = new ArrayList<>();
	}
	
	public static VagrantVmConfigBuilder create() {
		return new VagrantVmConfigBuilder();
	}
	
	public VagrantVmConfigBuilder withPuppetProvisionerConfig(PuppetProvisionerConfig puppetProvisionerConfig) {
		this.puppetProvisionerConfig = puppetProvisionerConfig;
		return this;
	}
	
	public VagrantVmConfigBuilder withVagrantPortForwarding(VagrantPortForwarding portForwarding) {
		this.portForwardings.add(portForwarding);
		return this;
	}
	
	public VagrantVmConfigBuilder withHostName(String hostName) {
		this.hostName = hostName;
		return this;
	}
	
	public VagrantVmConfigBuilder withGuiMode(boolean guiMode) {
		this.guiMode = guiMode;
		return this;
	}
	
	public VagrantVmConfigBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public VagrantVmConfigBuilder withHostOnlyIp(String ip) {
		this.ip = ip;
		return this;
	}
	
	public VagrantVmConfigBuilder withLucid32Box() {
		this.boxName = "lucid32";
        this.boxUrl = "http://files.vagrantup.com/lucid32.box";
        return this;
	}
	
	public VagrantVmConfigBuilder withLucid64Box() {
		this.boxName = "lucid64";
        this.boxUrl = "http://files.vagrantup.com/lucid64.box";
        return this;
	}
	
	public VagrantVmConfigBuilder withBoxName(String boxName) {
		this.boxName = boxName;
		return this;
	}
	
	public VagrantVmConfigBuilder withBoxUrl(String boxUrl) {
		this.boxUrl = boxUrl;
		return this;
	}

    public VagrantVmConfigBuilder withAdditionalConfig(String additionalConfig) {
        this.additionalConfig = additionalConfig;
        return this;
    }
	
	public VagrantVmConfig build() {
		if(boxName == null) {
			throw new VagrantBuilderException("No boxName defined");
		}
		return new VagrantVmConfig(name, ip, hostName, boxName, boxUrl, portForwardings, puppetProvisionerConfig, guiMode, additionalConfig);
	}
}
