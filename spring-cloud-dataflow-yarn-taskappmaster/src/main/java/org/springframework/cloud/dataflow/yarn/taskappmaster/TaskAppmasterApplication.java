/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.dataflow.yarn.taskappmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.dataflow.yarn.common.DataflowModuleYarnProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.yarn.YarnSystemConstants;
import org.springframework.yarn.am.AppmasterTrackService;

/**
 * Yarn application bootstrapping appmaster.
 *
 * @author Janne Valkealahti
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({ DataflowModuleYarnProperties.class })
public class TaskAppmasterApplication {

	@Configuration
	public static class Config {

		@Bean(name=YarnSystemConstants.DEFAULT_ID_AMTRACKSERVICE)
		public AppmasterTrackService appmasterTrackService() {
			return new EmbeddedAppmasterTrackService();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskAppmasterApplication.class, args);
	}

}
