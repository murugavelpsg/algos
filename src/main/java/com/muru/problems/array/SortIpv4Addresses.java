package com.muru.problems.array;

import org.apache.commons.collections.CollectionUtils;

import javax.xml.bind.ValidationException;
import java.util.*;

/**
 * Write a method to sort the list of IP addresses. Memoized the comparator so that it runs faster
 * Created by msivagna on 8/19/16.
 */
public class SortIpv4Addresses {
    public List<String> sort(List<String> ipAddressList) throws ValidationException {
        if (CollectionUtils.isEmpty(ipAddressList)) {
            return new ArrayList<String>();
        }
        List<String> sortedList = new ArrayList<String>(ipAddressList);
        //Sort
        Collections.sort(sortedList, new Ipv4AddressComparator());
        return sortedList;
    }

    private class Ipv4AddressComparator implements Comparator<String> {
        public Map<String, Double> ipAddressMap = new HashMap<String, Double>();
        public int compare(String ipv4Address1, String ipv4Address2) {
            Double address1 = ipAddressMap.containsKey(ipv4Address1) ? ipAddressMap.get(ipv4Address1) : convertIpAddressToInteger(ipv4Address1);
            Double address2 = ipAddressMap.containsKey(ipv4Address2) ? ipAddressMap.get(ipv4Address2) : convertIpAddressToInteger(ipv4Address2);
            if (address1 == address2) {
                return 0;
            } else if (address1 < address2) {
                return -1;
            } else {
                return 1;
            }
        }

        private double convertIpAddressToInteger(String strIpv4Address) {
            String[] splitAddress = strIpv4Address.split("\\.");
            if (splitAddress.length != 4) {
                String msg = String.format("Invalid input for IP Address = %s", strIpv4Address);
                throw new IllegalArgumentException(msg);
            }

            double address = 0;
            for (int i = 0; i < 4; i++) {
                int octet = Integer.parseInt(splitAddress[splitAddress.length - 1 - i]);
                if (!isValidOctet(octet)) {
                    String msg = String.format("Invalid octet = %d in IP Address = %s", octet, strIpv4Address);
                    throw new IllegalArgumentException(msg);
                }
                address = address + octet * Math.pow(256, i);
            }
            ipAddressMap.put(strIpv4Address, address);
            return address;
        }

        private boolean isValidOctet(Integer octet) {
            if (octet >= 0 && octet <= 255) {
                return true;
            }
            return false;
        }
    }
}
