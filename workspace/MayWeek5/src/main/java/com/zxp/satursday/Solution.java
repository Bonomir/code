package com.zxp.satursday;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> address  = new HashSet<String>();
        for(String email : emails){
            String originAddress = origin(email);
            address.add(originAddress);
        }
        return address.size();
    }

    public String origin(String address){
        int index = address.indexOf("@");
        String originLocalName = address.substring(0,index).split("\\+")[0];
        System.out.println(originLocalName);
        originLocalName = originLocalName.replace(".","");
        System.out.println(originLocalName);
        return (originLocalName + address.substring(index));
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(emails));
    }


    public String origin1(String address){
        String[] add = address.split("@");
        String localName = add[0];
        String domainName = add[1];
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < localName.length(); i++){
            char ch = localName.charAt(i);
            if(ch == '.'){
                continue;
            }else if(ch == '+'){
                break;
            }
            res.append(ch);
        }
        return res.append("@").append(domainName).toString();
    }
}
