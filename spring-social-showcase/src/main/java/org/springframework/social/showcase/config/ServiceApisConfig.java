package org.springframework.social.showcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.social.connect.ServiceProviderConnection;
import org.springframework.social.connect.ServiceProviderConnectionRepository;
import org.springframework.social.facebook.api.FacebookApi;
import org.springframework.social.tripit.api.TripItApi;
import org.springframework.social.twitter.api.TwitterApi;

@Configuration
public class ServiceApisConfig {
	
	@Bean
	@Scope(value="request")
	public FacebookApi facebookApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<FacebookApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(FacebookApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}
	
	@Bean
	@Scope(value="request")
	public TripItApi tripitApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<TripItApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TripItApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

	@Bean
	@Scope(value="request")
	public TwitterApi twitterApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<TwitterApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TwitterApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

}