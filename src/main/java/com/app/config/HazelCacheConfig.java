package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazelCacheConfig {
	@Bean
	public Config configObj() {
		return new Config().setInstanceName("hazel-inst")
				.addMapConfig(
						new MapConfig()
						.setName("customer-cache")
						.setTimeToLiveSeconds(2000)
						.setEvictionPolicy(EvictionPolicy.LRU)						
						.setMaxSizeConfig(
								new MaxSizeConfig().setSize(200)								
								)
						);
	}
}
