/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.is.portal.user.client.api.unit.test;

import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.ops4j.pax.exam.testng.listener.PaxExam;
import org.osgi.framework.BundleContext;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.meta.claim.mgt.mapping.profile.ProfileEntry;
import org.wso2.carbon.kernel.utils.CarbonServerInfo;
import org.wso2.is.portal.user.client.api.ProfileMgtClientService;
import org.wso2.is.portal.user.client.api.exception.UserPortalUIException;
import org.wso2.is.portal.user.client.api.unit.test.util.UserPortalOSGiTestUtils;

import javax.inject.Inject;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import static org.ops4j.pax.exam.CoreOptions.systemProperty;

@Listeners(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
public class ProfileMgtClientServiceTest {

    private static final String DEFAULT = "default";

    @Inject
    private BundleContext bundleContext;

    @Inject
    private CarbonServerInfo carbonServerInfo;

    @Inject
    private ProfileMgtClientService profileMgtClientService;

    @Configuration
    public Option[] createConfiguration() {

        List<Option> optionList = UserPortalOSGiTestUtils.getDefaultSecurityPAXOptions();

        optionList.add(systemProperty("java.security.auth.login.config")
                .value(Paths.get(UserPortalOSGiTestUtils.getCarbonHome(), "conf", "security", "carbon-jaas.config")
                        .toString()));

        return optionList.toArray(new Option[optionList.size()]);
    }

    @Test(groups = "getProfile")
    public void testGetProfileNames() throws UserPortalUIException {
        ProfileMgtClientService profileMgtClientService =
                bundleContext.getService(bundleContext.getServiceReference(ProfileMgtClientService.class));
        Assert.assertNotNull(profileMgtClientService, "Failed to get ProfileMgtClientService instance");

        /*Set<String> profileNames = profileMgtClientService.getProfileNames();
        Assert.assertNotNull(profileNames, "Failed to retrieve the default profile.");*/
    }

    @Test(groups = "getProfile")
    public void testGetProfile() throws UserPortalUIException {
        ProfileMgtClientService profileMgtClientService =
                bundleContext.getService(bundleContext.getServiceReference(ProfileMgtClientService.class));
        Assert.assertNotNull(profileMgtClientService, "Failed to get ProfileMgtClientService instance");

        /*ProfileEntry profileEntry = profileMgtClientService.getProfile(DEFAULT);

        Assert.assertNotNull(profileEntry, "Failed to retrieve the default profile.");
        Assert.assertNotEquals(profileEntry.getProfileName(), DEFAULT, "Retrived profile is an invalid profile.");*/
    }
}
