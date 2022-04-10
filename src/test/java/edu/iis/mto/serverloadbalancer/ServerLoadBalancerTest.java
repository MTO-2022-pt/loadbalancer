package edu.iis.mto.serverloadbalancer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class ServerLoadBalancerTest {

    @Test
    void itCompiles() {
        assertThat(true, equalTo(true));
    }

    @Test
    void balancingAServer_noVms_serverStaysEmpty() {
        Server theServer = a(server().withCapacity(1));

        balance(aListOfServersWith(theServer), anEmptyListOfVms());

        assertThat(theServer, hasLoadPercentageOf(0.0d));
    }
}
