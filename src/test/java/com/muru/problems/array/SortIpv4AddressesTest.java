package com.muru.problems.array;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 8/19/16.
 */
public class SortIpv4AddressesTest {
    @Test
    public void mustGetNullWhenTheInputIsNull() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = null;
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
        assertEquals(actualIpv4Addresses, new ArrayList<String>());
    }

    @Test
    public void mustGetEmptyListWhenTheInputIsEmpty() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
        assertEquals(actualIpv4Addresses, new ArrayList<String>());
    }

    @Test
    public void mustGetSortedListWhenTheListHasOneElement() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        ipAddresses.add("128.1.121.125");
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
        assertEquals(actualIpv4Addresses, ipAddresses);
    }

    @Test
    public void mustGetSortedListWhenTheListHasSameIpAddresses() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("128.1.121.125");
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
        assertEquals(actualIpv4Addresses, ipAddresses);
    }

    @Test
    public void mustGetSortedListForAValidInputList() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("204.210.121.255");
        ipAddresses.add("204.208.121.255");
        ipAddresses.add("28.1.35.21");
        ipAddresses.add("10.10.101.140");
        ipAddresses.add("78.21.33.44");
        ipAddresses.add("223.231.21.231");
        ipAddresses.add("200.231.231.144");
        ipAddresses.add("172.231.231.144");
        ipAddresses.add("172.23.231.144");
        ipAddresses.add("172.23.231.149");
        ipAddresses.add("10.14.01.60");
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
        List<String> expectedIpAddresses = new ArrayList<String>();
        expectedIpAddresses.add("10.10.101.140");
        expectedIpAddresses.add("10.14.01.60");
        expectedIpAddresses.add("28.1.35.21");
        expectedIpAddresses.add("78.21.33.44");
        expectedIpAddresses.add("128.1.121.125");
        expectedIpAddresses.add("172.23.231.144");
        expectedIpAddresses.add("172.23.231.149");
        expectedIpAddresses.add("172.231.231.144");
        expectedIpAddresses.add("200.231.231.144");
        expectedIpAddresses.add("204.208.121.255");
        expectedIpAddresses.add("204.210.121.255");
        expectedIpAddresses.add("223.231.21.231");
        assertEquals(actualIpv4Addresses, expectedIpAddresses);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenTheInputHasIpAddressesWithIncorrectOctets() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("204.210.121");
        ipAddresses.add("204.208.121.255");
        ipAddresses.add("28.1.35.21");
        ipAddresses.add("10.10.101.140");
        ipAddresses.add("78.21.33.44");
        ipAddresses.add("223.231.21.231");
        ipAddresses.add("172.23.231.144");
        ipAddresses.add("10.14.01.60");
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenTheInputHasInvalidIpAddresses() throws ValidationException {
        SortIpv4Addresses sortIpv4Addresses = new SortIpv4Addresses();
        List<String> ipAddresses = new ArrayList<String>();
        ipAddresses.add("128.1.121.125");
        ipAddresses.add("304.210.121.23");
        ipAddresses.add("204.208.121.255");
        ipAddresses.add("28.1.35.21");
        ipAddresses.add("10.10.101.140");
        ipAddresses.add("78.21.33.44");
        ipAddresses.add("223.231.21.231");
        ipAddresses.add("172.23.231.144");
        ipAddresses.add("10.14.01.60");
        List<String> actualIpv4Addresses = sortIpv4Addresses.sort(ipAddresses);
    }
}