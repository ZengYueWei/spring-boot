/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.jms.activemq;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.jms.JmsPoolConnectionFactoryProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Configuration properties for ActiveMQ.
 *
 * @author Greg Turnquist
 * @author Stephane Nicoll
 * @author Aurélien Leboulanger
 * @author Venil Noronha
 */
@ConfigurationProperties(prefix = "spring.activemq")
public class ActiveMQProperties {

	/**
	 * URL of the ActiveMQ broker. Auto-generated by default.
	 */
	private String brokerUrl;

	/**
	 * Whether the default broker URL should be in memory. Ignored if an explicit broker
	 * has been specified.
	 */
	private boolean inMemory = true;

	/**
	 * Login user of the broker.
	 */
	private String user;

	/**
	 * Login password of the broker.
	 */
	private String password;

	/**
	 * Time to wait before considering a close complete.
	 */
	private Duration closeTimeout = Duration.ofSeconds(15);

	/**
	 * Whether to stop message delivery before re-delivering messages from a rolled back
	 * transaction. This implies that message order is not preserved when this is enabled.
	 */
	private boolean nonBlockingRedelivery = false;

	/**
	 * Time to wait on message sends for a response. Set it to 0 to wait forever.
	 */
	private Duration sendTimeout = Duration.ofMillis(0);

	@NestedConfigurationProperty
	private final JmsPoolConnectionFactoryProperties pool = new JmsPoolConnectionFactoryProperties();

	private final Packages packages = new Packages();

	public String getBrokerUrl() {
		return this.brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public boolean isInMemory() {
		return this.inMemory;
	}

	public void setInMemory(boolean inMemory) {
		this.inMemory = inMemory;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Duration getCloseTimeout() {
		return this.closeTimeout;
	}

	public void setCloseTimeout(Duration closeTimeout) {
		this.closeTimeout = closeTimeout;
	}

	public boolean isNonBlockingRedelivery() {
		return this.nonBlockingRedelivery;
	}

	public void setNonBlockingRedelivery(boolean nonBlockingRedelivery) {
		this.nonBlockingRedelivery = nonBlockingRedelivery;
	}

	public Duration getSendTimeout() {
		return this.sendTimeout;
	}

	public void setSendTimeout(Duration sendTimeout) {
		this.sendTimeout = sendTimeout;
	}

	public JmsPoolConnectionFactoryProperties getPool() {
		return this.pool;
	}

	public Packages getPackages() {
		return this.packages;
	}

	public static class Packages {

		/**
		 * Whether to trust all packages.
		 */
		private Boolean trustAll;

		/**
		 * Comma-separated list of specific packages to trust (when not trusting all
		 * packages).
		 */
		private List<String> trusted = new ArrayList<>();

		public Boolean getTrustAll() {
			return this.trustAll;
		}

		public void setTrustAll(Boolean trustAll) {
			this.trustAll = trustAll;
		}

		public List<String> getTrusted() {
			return this.trusted;
		}

		public void setTrusted(List<String> trusted) {
			this.trusted = trusted;
		}

	}

}
