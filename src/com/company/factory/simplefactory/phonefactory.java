package com.company.factory.simplefactory;

public class phonefactory {
    public phone makeMi(){
        //before processing
        return new mi();
    }
    public phone makeIphone(){
        //before processing
        return new iphone();
    }
}
